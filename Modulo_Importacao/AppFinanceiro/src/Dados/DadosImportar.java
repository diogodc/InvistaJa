package Dados;

import static App.AppFinanceiro.conn;
import App.AppFinanceiro.tipoRelatorio;
import Modelo.ModeloImportar;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosImportar {
        
    public boolean importarDados(ArrayList<ModeloImportar> lImportar, 
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
            ArrayList<ModeloImportar> lImportar) throws Exception{
        try{
            String sSql;
            String sTabela = hDadosTabela.get("sTabela").toString();
            String sIndice = hDadosTabela.get("sIndice").toString();
            
            if (lImportar.size() == 0){return false;}
            
            for (int i = 1; i < lImportar.size(); i++){
                conn.abrirConexao();

                ModeloImportar mImportar = lImportar.get(i); 

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

                if (!sSql.trim().isEmpty()){
                    if (conn.Inserir(sSql)){
                        this.atualizarIndiceImportado(sIndice,
                                mImportar.getEmpresa_ID());
                    }                    
                }  
                conn.fecharConexao();
            }
            return true;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private void atualizarIndiceImportado(String sIndice,
            int iEmpresa_ID) throws Exception{
        try{
            String sSql;
            
            sSql  = "UPDATE BVSP_EMPRESA SET ";
            sSql += "   BVSP_EMPRESA." + sIndice + " = 'S' ";
            sSql += "WHERE BVSP_EMPRESA.ID_EMPRESA = " + iEmpresa_ID;
            
            conn.Alterar(sSql);
        }catch(Exception ex){
            throw ex;
        }
    }
}
