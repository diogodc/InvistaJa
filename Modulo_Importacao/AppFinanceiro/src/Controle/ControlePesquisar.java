package Controle;

import static App.AppFinanceiro.conn;
import Dados.DadosPesquisar;
import Modelo.ModeloPesquisar;
import Visao.VisaoPesquisar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class ControlePesquisar {

    private final String sTabela;
    private final String sParametros;
    private final String sCondicao;
    private final String sJoin;
    private String sCodigo;
    private final VisaoPesquisar vPesquisar;
    private final ArrayList<String> dados = new ArrayList();

    public ControlePesquisar(VisaoPesquisar vPesquisar, String tabela, String parametros,
            String condicao, String join, JTable tabResultados,
            JTextField txtFiltro, JComboBox cboTipoFiltro) {
        this.vPesquisar = vPesquisar;
        this.sTabela = tabela;
        this.sParametros = parametros;
        this.sCondicao = condicao;
        this.sJoin = join;
    }

    public void pesquisar(JTable tabResultados, JTextField txtFiltro,
            JComboBox cboTipoFiltro, JComboBox cboCampoFiltro) throws Exception {
        try {
            DefaultTableModel dtm = (DefaultTableModel) tabResultados.getModel();
            dtm.getDataVector().clear();
            dtm.setColumnCount(0);

            ModeloPesquisar mPesquisar = new ModeloPesquisar();
            mPesquisar.setFiltro(txtFiltro.getText());
            mPesquisar.setJoin(sJoin);
            mPesquisar.setParamentros(sParametros);
            mPesquisar.setTabela(sTabela);
            mPesquisar.setCondicao(sCondicao);
            mPesquisar.setTipoFiltro(cboTipoFiltro.getSelectedItem().toString());
            mPesquisar.setCampoFiltro(cboCampoFiltro.getSelectedItem().toString());
            mPesquisar.setModeloArvore(this.vPesquisar.getModeloArvore());

            DadosPesquisar dPesquisar = new DadosPesquisar();

            HashMap hmRetorno = dPesquisar.carregarTabela(mPesquisar);
            tabResultados.setModel((TableModel) hmRetorno.get("Tabela"));
            sCodigo = (String) hmRetorno.get("Codigo");
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ArrayList<String> selecionar(JTable tabResultados) throws SQLException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, Exception {
        try {
            conn.abrirConexao();

            String sSql = "";
            int linha = tabResultados.getSelectedRow();

            sSql += "SELECT * FROM " + sTabela;
            sSql += " WHERE " + sCodigo + "=" + tabResultados.getValueAt(linha, 0);

            ResultSet rs = conn.Selecionar(sSql);

            rs.next();
            for (int iCont = 1; iCont <= conn.getResultSetMetaData().getColumnCount(); iCont++) {
                dados.add(rs.getString(iCont));
            }

            vPesquisar.dispose();

            conn.fecharConexao();

            return dados;
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
}
