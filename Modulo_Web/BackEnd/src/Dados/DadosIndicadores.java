package Dados;

import static App.AppWs.conn;
import Modelo.ModeloResultado;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import App.AppWs;


public class DadosIndicadores {
        
    protected boolean calcularIndicadores(int iEmpresa_Id, String sAno1, 
    		String sAno2, String sAno3){
        try{                     
            conn.abrirConexao();
            
            String sSql  = "{call BVSP_SP_INDICADORES(?,?,?,?)}";
            CallableStatement  cs = conn.getConnection().prepareCall(sSql);
            cs.setInt(1, iEmpresa_Id);
            cs.setString(2, sAno1);
            cs.setString(3, sAno2);
            cs.setString(4, sAno3);
            cs.execute();    
            
            conn.fecharConexao();
            
            return true;
        }catch (Exception ex) {
        	AppWs.gravarLog("DadosIndicadores", "calcularIndicadores","",
					ex.getMessage(),ex.getStackTrace().toString());
        	return false;
        }
    }
    
    protected ArrayList<ModeloResultado> gerarResultados(int iEmpresa_ID,
    		String sCampo){
        try{
            conn.abrirConexao();
            
            ArrayList<ModeloResultado> lmResultados = new ArrayList<ModeloResultado>();
            
            String sSql;
            
            sSql  = " SELECT";
            sSql += "	 BVSP_INDICADORES.ANO,";
            sSql += "	 ROUND(BVSP_INDICADORES." + sCampo + ",2) AS INDICADOR";
            sSql += " FROM BVSP_INDICADORES";
            sSql += " WHERE BVSP_INDICADORES.ID_EMPRESA = " + iEmpresa_ID;
            
            ResultSet rs = conn.Selecionar(sSql);
            while(rs.next()){
                ModeloResultado mResultado = new ModeloResultado();
                mResultado.setAno(rs.getInt("ANO"));
                mResultado.setValor(rs.getDouble("INDICADOR"));
                lmResultados.add(mResultado);
            }
            
            conn.fecharConexao();
            
            return lmResultados;
        }catch (Exception ex) {
        	AppWs.gravarLog("DadosIndicadores", "gerarResultados","",
					ex.getMessage(),ex.getStackTrace().toString());
        	return null;
        }
    } 
}
