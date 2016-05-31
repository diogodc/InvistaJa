/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import static App.AppFinanceiro.conn;
import Modelo.CreateModel;
import Modelo.Tree.Branch.Leaf.Leaf;
import Modelo.Tree.Tree;
import Visao.VisaoPesquisar;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ControlePesquisar {

    private final String tabela;
    private final String parametros;
    private final String condicao;
    private final String join;
    private String codigo;
    private final VisaoPesquisar vPesquisar;
    private final ArrayList<String> dados = new ArrayList();
    private final String orderBy;
    /* add Rafael  21/05/16 ----- para desordenar a consulta */
    private final CreateModel crModel;

    /* add Rafael  21/05/16 ----- para criar o model para a arvore */
    public ControlePesquisar(VisaoPesquisar vPesquisar, String tabela, String parametros,
            String condicao, String join, JTable tabResultados,
            JTextField txtFiltro, JComboBox cboTipoFiltro) {
        this.vPesquisar = vPesquisar;
        this.tabela = tabela;
        this.parametros = parametros;
        this.condicao = condicao;
        this.join = join;
        this.orderBy = " order by sys_guid() desc ";
        /* add Rafael 22/05/16 ----- desordenando a consulta */
        this.crModel = null;
    }

    public ControlePesquisar(VisaoPesquisar vPesquisar, String tabela, String parametros,
            String condicao, String join, JTable tabResultados,
            JTextField txtFiltro, JComboBox cboTipoFiltro, CreateModel crModel) {
        this.vPesquisar = vPesquisar;
        this.tabela = tabela;
        this.parametros = parametros;
        this.condicao = condicao;
        this.join = join;
        this.orderBy = " order by sys_guid() desc ";
        /* add Rafael 22/05/16 ----- desordenando a consulta */

        this.crModel = crModel;
    }

    public void pesquisar(JTable tabResultados, JTextField txtFiltro, JComboBox cboTipoFiltro, JComboBox cboCampoPesquisa) throws Exception {
        try {
            DefaultTableModel dtm = (DefaultTableModel) tabResultados.getModel();
            String sSearchText; /*  add Rafael 25/05/16 */

            dtm.getDataVector().clear();
            dtm.setColumnCount(0);

            sSearchText = txtFiltro.getText();
            if (this.crModel != null) {  /*  add Rafael 25/05/16 ------ SE FOR UTILIZAR ARVORE */
                if (this.crModel.searchOption().equals(cboCampoPesquisa.getSelectedItem()) && !sSearchText.equals("")) { /*  add Rafael 25/05/16 ------ SE FOR UTILIZAR BUSCA EM ARVORE */
                    this.crModel.setSearch(sSearchText);
                    sSearchText = "";
                } else { /*  add Rafael 25/05/16 ------ SE NÃO FOR UTILIZAR BUSCA EM ARVORE */
                    this.crModel.setSearch("");
                }
            }

            if (sSearchText.equals("")) {
                preecheTabela("SELECT " + parametros + " FROM " + tabela + " " + join,
                        tabResultados);
            } else if (cboTipoFiltro.getSelectedItem() == "Iniciado por") {

                preecheTabela("SELECT " + parametros + " FROM " + tabela
                        + " " + join + " WHERE " + cboCampoPesquisa.getSelectedItem()
                        + " LIKE '" + sSearchText + "%'", tabResultados);
            } else if (cboTipoFiltro.getSelectedItem() == "Contendo") {
                preecheTabela("SELECT " + parametros + " FROM " + tabela
                        + " " + join + " WHERE " + cboCampoPesquisa.getSelectedItem()
                        + " LIKE '%" + sSearchText + "%'", tabResultados);
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void selecionar(JTable tabResultados) {
        try {
            int linha = tabResultados.getSelectedRow();
            conn.abrirConexao();
            ResultSet rs = conn.Selecionar("SELECT * FROM " + tabela + " WHERE " + codigo + "=" + tabResultados.getValueAt(linha, 0));

            while (rs.next()) {
                /* add Rafael  25/05/16  */
                for (int i = 1; i <= conn.getResultSetMetaData().getColumnCount(); ++i) {
                    dados.add(rs.getString(i));
                }
            }

            vPesquisar.dispose();
            conn.fecharConexao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro Interno:", 0);//Alerta de falha;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preecheTabela(String sQuery, JTable tabResultados)
            throws SQLException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, Exception {
        try {
            Vector linhas = new Vector();
            Vector cabecalho = new Vector();
            Tree tree = new Tree();

            if (!condicao.equals("")) {
                sQuery = sQuery + " " + condicao;
            }

            sQuery = sQuery + " " + this.orderBy;
            /* add Rafael 22/05/16 */

            conn.abrirConexao();
            ResultSet rs = conn.Selecionar(sQuery);

            while (rs.next()) {
                if (this.crModel == null) {
                    linhas.addElement(proximaLinha(conn.getResultSet(),
                            conn.getResultSetMetaData()));
                } else {
                    /*  add Rafael 22/05/16 ------ ADICIONANDO NA ARVORE */
                    tree.add(this.crModel.Get(proximaLinha(conn.getResultSet(),
                            conn.getResultSetMetaData())));
                }
            }

            if (this.crModel != null) {
                /* add Rafael 22/05/16 ----- TRASNFORMA A ARVORE EM VECTOR, ORDENADO PELA CHAVE  */
                linhas = tree.parseVector();
                if (!this.crModel.getSearch().equals("")) { /*  BUSCA EM ARVORE PELA CHAVE  */
                    Leaf lSearch = this.crModel.getModel(); /*  CRIA OBJETO DO MESMO TIPO QUE ESTÁ CONTIDO NA ARVORE  */
                    lSearch.setKey(this.crModel.getSearch()); /*  PEGA A CHAVE PROCURADA  */
                    linhas = (Vector) tree.search(lSearch, true); /*  RETORNA O OBJETO ENCONTRA EM FORMA DE VECTOR  */
                }
            }

            for (int i = 1; i <= conn.getResultSetMetaData().getColumnCount(); i++) {
                cabecalho.addElement(conn.getResultSetMetaData().getColumnLabel(i));
            }

            codigo = getColumnName(conn.getResultSetMetaData().getColumnName(1));
            tabResultados.setModel(new javax.swing.table.DefaultTableModel(linhas, cabecalho));
            tabResultados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            conn.fecharConexao();
        } catch (SQLException ex) {
            throw ex;
        } catch (ClassNotFoundException ex) {
            throw ex;
        } catch (InstantiationException ex) {
            throw ex;
        } catch (IllegalAccessException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
        Vector linhaAtual = new Vector();
        try {
            for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                linhaAtual.add(rs.getString(i));
            }
            return linhaAtual;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public String getColumnName(String aliasName) {
        /* add Rafael  25/05/16 ----- pega nome da coluna pelo ALIAS */
        String fields[];
        String searchAliasName;
        String alias;
        String columnName;

        columnName = "";
        alias = " AS ";
        searchAliasName = "\"" + aliasName + "\"";
        fields = parametros.split(",");

        for (int i = 0; i < fields.length - 1; ++i) {
            String field = fields[i];
            Integer beforeName;

            if (field.contains(searchAliasName)) {
                beforeName = field.indexOf(searchAliasName);
                if (field.contains(" AS ")) {
                    beforeName = field.indexOf(alias);
                }
                columnName = field.substring(0, beforeName);
            }
        }

        return columnName;
    }
}
