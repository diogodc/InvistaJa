package Dados;

import static App.AppFinanceiro.conn;
import Modelo.ModeloPesquisar;
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
    
    private String sqlPesquisar(ModeloPesquisar mPesquisar){
        try{
            String sQuery ="";
            if (mPesquisar.getFiltro().equals("")) {
                sQuery = "SELECT " + mPesquisar.getParamentros() + " FROM " + mPesquisar.getTabela();
            }else if ("Iniciado por".equals(mPesquisar.getTipoFiltro())){
                sQuery  = "SELECT " + mPesquisar.getParamentros() + " FROM " + mPesquisar.getTabela();
                sQuery += " WHERE " + mPesquisar.getCampoFiltro() + " LIKE '" + mPesquisar.getFiltro()+ "%'";        
            }else if("Contendo".equals(mPesquisar.getTipoFiltro())){
                sQuery  = "SELECT " + mPesquisar.getParamentros() + " FROM " + mPesquisar.getTabela();
                sQuery += " WHERE " + mPesquisar.getCampoFiltro() + " LIKE '%" + mPesquisar.getFiltro() + "%'";   
            }
            return sQuery;
        }catch (Exception ex) {
            throw ex;
        }
    }
    
    
    public HashMap carregarTabela(ModeloPesquisar mPesquisar) 
            throws SQLException, ClassNotFoundException, 
            InstantiationException, IllegalAccessException, Exception {
        try {
            Vector vLinhas = new Vector();
            Vector vCabecalho = new Vector();
            String sQuery = sqlPesquisar(mPesquisar);
            String sCodigo = "";
            HashMap hmRetorno = new HashMap();
            
            if(!mPesquisar.getCondicao().equals("")){
                sQuery += " " + mPesquisar.getCondicao();
            }
            
            conn.abrirConexao();
            
            ResultSet rs = conn.Selecionar(sQuery);
        
            while(rs.next()){
                vLinhas.addElement(proximaLinha(conn.getResultSet(),conn.getResultSetMetaData()));
            }
            
            for(int i=1;i<=conn.getResultSetMetaData().getColumnCount();i++){
                vCabecalho.addElement(conn.getResultSetMetaData().getColumnLabel(i));
            }
            
            sCodigo=conn.getResultSetMetaData().getColumnName(1);
            TableModel tmResultado = new javax.swing.table.DefaultTableModel(vLinhas,vCabecalho);
            
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
    
    private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) throws SQLException{
        Vector linhaAtual = new Vector();
        try {
            for (int i=1;i<=rsmd.getColumnCount();++i){
                linhaAtual.add(rs.getString(i));
            }
            return linhaAtual;
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
