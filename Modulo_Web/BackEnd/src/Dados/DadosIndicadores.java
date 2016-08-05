package Dados;

import static App.AppWs.conn;
import Modelo.ModeloEmpresa;
import Modelo.ModeloGrupo;
import Modelo.ModeloIndEmpresa;
import Modelo.ModeloIndicador;
import Modelo.ModeloResultado;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DadosIndicadores {
    protected boolean calcularIndicadores(String sAno1, String sAno2, String sAno3) throws Exception{
        try{         
            ArrayList<ModeloEmpresa> lmEmpresas = new DadosEmpresa().consultarEmpresas();
            
            for (int i = 0; i < lmEmpresas.size();i++){
                ModeloEmpresa mEmpresa = lmEmpresas.get(i);
                conn.abrirConexao();
                String sSql  = "{call BVSP_SP_INDICADORES(?,?,?,?)}";
                CallableStatement  cs = conn.getConnection().prepareCall(sSql);
                cs.setInt(1, mEmpresa.getEmpresa_ID());
                cs.setString(2, sAno1);
                cs.setString(3, sAno2);
                cs.setString(4, sAno3);
                cs.execute();    
                conn.fecharConexao();
            }
             
            return true;
        }catch (Exception ex) {
            throw ex;
        }
    }
    
    protected ArrayList<ModeloResultado> gerarResultados(int iEmpresa_ID,String sCampo) throws Exception{
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
            
            return lmResultados;
        }catch (Exception ex) {
            throw ex;
        }finally{
            conn.fecharConexao();
        }
    } 
}
