package Dados;

import static App.AppFinanceiro.conn;
import Modelo.ModeloPesquisar;
import Modelo.Tree.Branch.Leaf.Leaf;
import Modelo.Tree.Tree;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosPesquisar {

    private String sqlPesquisar(ModeloPesquisar mPesquisar) {
        try {
            String sQuery = "";
            String sFiltro;

            /**
             * RAFAEL 31/05/2016 -> sFiltro recebe mPesquisar.getFiltro() ->
             * mPesquisar.geModeloArvore() se a pesquisa utiliza arvore
             */
            sFiltro = mPesquisar.getFiltro();
            if (mPesquisar.geModeloArvore() != null) {
				mPesquisar.geModeloArvore().setSearch("");
                if (mPesquisar.geModeloArvore().searchOption().equals(mPesquisar.getCampoFiltro()) && !sFiltro.equals("")) {
                    mPesquisar.geModeloArvore().setSearch(sFiltro);
                    sFiltro = "";
                }
            }

            /**
             * RAFAEL 31/05/2016
             */
            if (sFiltro.equals("")) {
                sQuery = "SELECT " + mPesquisar.getParamentros() + " FROM " + mPesquisar.getTabela();
            } else if ("Iniciado por".equals(mPesquisar.getTipoFiltro())) {
                sQuery = "SELECT " + mPesquisar.getParamentros() + " FROM " + mPesquisar.getTabela();
                sQuery += " WHERE " + mPesquisar.getCampoFiltro() + " LIKE '" + sFiltro + "%'";
            } else if ("Contendo".equals(mPesquisar.getTipoFiltro())) {
                sQuery = "SELECT " + mPesquisar.getParamentros() + " FROM " + mPesquisar.getTabela();
                sQuery += " WHERE " + mPesquisar.getCampoFiltro() + " LIKE '%" + sFiltro + "%'";
            }

            return sQuery;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public HashMap carregarTabela(ModeloPesquisar mPesquisar)
            throws SQLException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, Exception {
        try {
            Vector vLinhas = new Vector();
            Vector vCabecalho = new Vector();
            Tree tBuscaEmArvore = null;
            String sQuery = sqlPesquisar(mPesquisar);
            String sCodigo = "";
            HashMap hmRetorno = new HashMap();

            if (!mPesquisar.getCondicao().equals("")) {
                sQuery += " " + mPesquisar.getCondicao();
            }

            /**
             * RAFAEL 31/05/2016
             */
            if (mPesquisar.geModeloArvore() != null) {
                tBuscaEmArvore = new Tree();
                sQuery += " " + mPesquisar.getOrderBy();
            }

            conn.abrirConexao();

            ResultSet rs = conn.Selecionar(sQuery);

            while (rs.next()) {
                if (mPesquisar.geModeloArvore() == null) {
                    vLinhas.addElement(proximaLinha(conn.getResultSet(), conn.getResultSetMetaData()));
                } else {
                    tBuscaEmArvore.add(mPesquisar.geModeloArvore().Get(proximaLinha(conn.getResultSet(),
                            conn.getResultSetMetaData())));
                }
            }

            /**
             * RAFAEL 31/05/2016
             */
            if (mPesquisar.geModeloArvore() != null) {
                if (!mPesquisar.geModeloArvore().getSearch().equals("")) {
                    /*  BUSCA EM ARVORE PELA CHAVE  */
                    Leaf lSearch = mPesquisar.geModeloArvore().getModel();
                    /*  CRIA OBJETO DO MESMO TIPO QUE ESTÁ CONTIDO NA ARVORE  */
                    lSearch.setKey(mPesquisar.geModeloArvore().getSearch());
                    /*  PEGA A CHAVE PROCURADA  */
                    vLinhas = (Vector) tBuscaEmArvore.search(lSearch, true);
                    /*  RETORNA O OBJETO ENCONTRA EM FORMA DE VECTOR  */
                } else {
                    vLinhas = tBuscaEmArvore.parseVector();
                }
            }

            for (int i = 1; i <= conn.getResultSetMetaData().getColumnCount(); i++) {
                vCabecalho.addElement(conn.getResultSetMetaData().getColumnLabel(i));
            }

            sCodigo = conn.getResultSetMetaData().getColumnName(1);
            TableModel tmResultado = new javax.swing.table.DefaultTableModel(vLinhas, vCabecalho);

            conn.fecharConexao();

            hmRetorno.put("Tabela", tmResultado);
            hmRetorno.put("Codigo", sCodigo);

            return hmRetorno;
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

    private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
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
}
