package Dados;

import static App.AppFinanceiro.conn;
import App.AppFinanceiro.tipoRelatorio;
import Modelo.ModeloImpExp;
import Modelo.ModeloIndicadores;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosImpExp {
        
    public boolean importarDados(ArrayList<ModeloImpExp> lImportar, 
            tipoRelatorio tRelatorio) throws Exception{
        try{
            if (lImportar.size()> 0){
                return this.inserirDados(
                        selecionarTipoRelatorio(tRelatorio),lImportar);
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    } 
    
    private HashMap selecionarTipoRelatorio(tipoRelatorio tRelatorio){
        try{
            String sTabela,sIndice;
            HashMap hDadosTabela = new HashMap();
            
            if (tRelatorio == tipoRelatorio.DRE){
                sTabela = "BVSP_DRE";
                sIndice = "DRE";
            }else if (tRelatorio == tipoRelatorio.BPA){
                sTabela = "BVSP_BPA";
                sIndice = "BPA";
            }else{
                sTabela = "BVSP_BPP";
                sIndice = "BPP";
            }
            
            hDadosTabela.put("sTabela", sTabela);
            hDadosTabela.put("sIndice", sIndice);
            
            return hDadosTabela;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private boolean inserirDados(HashMap hDadosTabela,  
            ArrayList<ModeloImpExp> lImportar) throws Exception{
        try{
            String sSql;
            int iEmpresa_ID = 0;
            String sTabela = hDadosTabela.get("sTabela").toString();
            String sIndice = hDadosTabela.get("sIndice").toString();
            
            if (lImportar.size() == 0){return false;}
            
            for (int i = 0; i < lImportar.size(); i++){
                conn.abrirConexao();

                ModeloImpExp mImportar = lImportar.get(i); 

                sSql  = "";
                sSql += "INSERT INTO " + sTabela;
                sSql += "        (ID_EMPRESA,";    
                sSql += "        " + sIndice + "_PERIODO1,";
                sSql += "        " + sIndice + "_PERIODO2,";
                sSql += "        " + sIndice + "_PERIODO3,";
                sSql += "        " + sIndice + "_VALOR1,";
                sSql += "        " + sIndice + "_VALOR2,";
                sSql += "        " + sIndice + "_VALOR3,";
                sSql += "        " + sIndice + "_CONTA_CONTABIL,";
                sSql += "        " + sIndice + "_DESCRICAO";
                sSql += "        )";
                sSql += "      VALUES";
                sSql += "        (" + mImportar.getEmpresa_ID()+ ",";
                sSql += "         '" + mImportar.getPeriodo_1()+ "',";
                sSql += "         '" + mImportar.getPeriodo_2()+ "',";
                sSql += "         '" + mImportar.getPeriodo_3()+ "',";
                sSql += "          " + mImportar.getValor_1()   + ",";
                sSql += "          " + mImportar.getValor_2()   + ",";
                sSql += "          " + mImportar.getValor_3()   + ",";
                sSql += "         '" + mImportar.getConta()    + "',";
                sSql += "         '" + mImportar.getDescricao()+ "'";
                sSql += "        )";
                
                iEmpresa_ID = mImportar.getEmpresa_ID();
                
                if (!sSql.trim().isEmpty()){
                    conn.Inserir(sSql);                        
                }  
                conn.fecharConexao();
            }
             this.atualizarIndiceImportado(sIndice,iEmpresa_ID);
            return true;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private void atualizarIndiceImportado(String sIndice,
            int iEmpresa_ID) throws Exception{
        try{
            conn.abrirConexao();
            String sSql;
            
            sSql  = "UPDATE BVSP_EMPRESA SET ";
            sSql += "   BVSP_EMPRESA." + sIndice + " = 'S' ";
            sSql += "WHERE BVSP_EMPRESA.ID_EMPRESA = " + iEmpresa_ID;
            
            conn.Alterar(sSql);
            
            conn.fecharConexao();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean calcularIndicadores(int iEmpresa_ID, String sAno1, 
            String sAno2, String sAno3) throws Exception{
        try{
            CallableStatement  cs = conn.getConnection().prepareCall("{call BVSP_SP_INDICADORES(?,?,?,?)}");
            cs.setInt(1,iEmpresa_ID);
            cs.setString(2, sAno1);
            cs.setString(3, sAno2);
            cs.setString(4, sAno3);
            cs.execute();         
            return false;
        }catch (Exception ex) {
            throw ex;
        }
    }
    
    public ArrayList<ModeloIndicadores> gerarIndicadores(){
        try{
            return new ArrayList<ModeloIndicadores>();
        }catch (Exception ex) {
            throw ex;
        }
    }
}
