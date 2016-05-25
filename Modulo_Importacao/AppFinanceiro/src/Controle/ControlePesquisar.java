/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import static App.AppFinanceiro.conn;
import Modelo.CreateModel;
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

    private final String orderBy; /* add Rafael  21/05/16 */
    private final CreateModel crModel; /* add Rafael  21/05/16 */


    public ControlePesquisar(VisaoPesquisar vPesquisar, String tabela, String parametros,
            String condicao, String join, JTable tabResultados,
            JTextField txtFiltro, JComboBox cboTipoFiltro) {
        this.vPesquisar = vPesquisar;
        this.tabela = tabela;
        this.parametros = parametros;
        this.condicao = condicao;
        this.join = join;     
        this.orderBy = " order by sys_guid() desc "; /* desordenando a consulta */
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
        this.orderBy = " order by sys_guid() desc ";  /* desordenando a consulta */
        this.crModel = crModel;
    }

    public void pesquisar(JTable tabResultados, JTextField txtFiltro, JComboBox cboTipoFiltro, JComboBox cboCampoPesquisa) throws Exception {
        try {
            DefaultTableModel dtm = (DefaultTableModel) tabResultados.getModel();
            dtm.getDataVector().clear();
            dtm.setColumnCount(0);

            if (txtFiltro.getText().equals("")) {
                preecheTabela("SELECT " + parametros + " FROM " + tabela + " " + join,
                        tabResultados);
            } else if (cboTipoFiltro.getSelectedItem() == "Iniciado por") {
                preecheTabela("SELECT " + parametros + " FROM " + tabela
                        + " " + join + " WHERE " + cboCampoPesquisa.getSelectedItem()
                        + " LIKE '" + txtFiltro.getText() + "%'", tabResultados);
            } else if (cboTipoFiltro.getSelectedItem() == "Contendo") {
                preecheTabela("SELECT " + parametros + " FROM " + tabela
                        + " " + join + " WHERE " + cboCampoPesquisa.getSelectedItem()
                        + " LIKE '%" + txtFiltro.getText() + "%'", tabResultados);
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
            for (int i = 1; i <= conn.getResultSetMetaData().getColumnCount(); ++i) {
                dados.add(rs.getString(i));
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
            
            sQuery = sQuery + " " + this.orderBy; /* add Rafael 22/05/16*/

            conn.abrirConexao();
            ResultSet rs = conn.Selecionar(sQuery);

            while (rs.next()) {
                if (this.crModel == null) {
                    linhas.addElement(proximaLinha(conn.getResultSet(),
                            conn.getResultSetMetaData()));
                } else {
                    /*  ADICIONANDO NA ARVORE */
                    tree.add(this.crModel.Get(proximaLinha(conn.getResultSet(),
                            conn.getResultSetMetaData())));
                }
            }
            
            tree.inOrder();
            
            for (int i = 1; i <= conn.getResultSetMetaData().getColumnCount(); i++) {
                cabecalho.addElement(conn.getResultSetMetaData().getColumnLabel(i));
            }
            
            codigo = conn.getResultSetMetaData().getColumnName(1);
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

    public List proximaLinha(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
        List linhaAtual = new List();
        try {
            for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                linhaAtual.add(rs.getString(i));
            }
            return linhaAtual;
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
