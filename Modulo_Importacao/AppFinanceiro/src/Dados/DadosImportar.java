/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                return this.inserirDadosRelatorio(
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
            String sTabela,sPai_ID;
            HashMap hDadosTabela = new HashMap();
            
            if (tRelatorio == tipoRelatorio.DRE){
                sTabela = "BVSP_DRE";
                sPai_ID = "ID_DRE";
            }else if (tRelatorio == tipoRelatorio.BPA){
                sTabela = "BVSP_BPA";
                sPai_ID = "ID_BPA";
            }else{
                sTabela = "BVSP_BPP";
                sPai_ID = "ID_BPP";
            }
            
            hDadosTabela.put("sTabela", sTabela);
            hDadosTabela.put("sPai_ID", sPai_ID);
            
            return hDadosTabela;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private boolean inserirDadosRelatorio(HashMap hDadosTabela,  
            ArrayList<ModeloImportar> lImportar) throws Exception{
        try{
            String sSql;
            
            for (int i = 1; i < lImportar.size(); i++){
                ModeloImportar mImportar = lImportar.get(i);

                sSql = " INSERT INTO "+ hDadosTabela.get("sTabela") +"_DADOS(" +",EMPRESA_ID,PERIODO_1,PERIODO_2,PERIODO_3)";
                sSql += " VALUES( ";
                sSql += "   ," ;
                sSql += "   ," + mImportar.getEmpresa_ID();
                sSql += "   ," + mImportar.getPeriodo_1();
                sSql += "   ," + mImportar.getPeriodo_2();
                sSql += "   ," + mImportar.getPeriodo_3();                
                sSql += " ) '";

                if (!sSql.trim().isEmpty()){
                    return conn.Inserir(sSql);                    
                }else{
                    return false;
                }
            }
            return false;
        }catch(Exception ex){
            throw ex;
        }
    }
}
