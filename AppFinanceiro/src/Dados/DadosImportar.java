/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import static App.AppFinanceiro.conn;
import App.AppFinanceiro.tipoRelatorio;
import Modelo.ModeloImportar;
import java.sql.ResultSet;
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
                conn.abrirConexao();
               
                HashMap hDadosTab;
                int iPai_ID;
                
                hDadosTab = selecionaTipoRelatorio(tRelatorio);
                
                iPai_ID = insereCabecalhoRelatorio(hDadosTab.get("sTabela").toString(),
                        hDadosTab.get("sPai_ID").toString(),lImportar);
                
                if (iPai_ID == 0){ return false;}
                
                insereDadosRelatorio(hDadosTab.get("sTabela").toString(),
                        hDadosTab.get("sPai_ID").toString(),iPai_ID,lImportar);
                
                conn.fecharConexao();
            }
            return true; 
        }catch(Exception ex){
            throw ex;
        }
    } 
    
    private HashMap selecionaTipoRelatorio(tipoRelatorio tRelatorio){
        try{
            String sTabela,sPai_ID;
            HashMap hDadosTab = new HashMap();
            
            if (tRelatorio == tipoRelatorio.DRE){
                sTabela = "BVSP_DRE";
                sPai_ID = "DRE_ID";
            }else if (tRelatorio == tipoRelatorio.BPA){
                sTabela = "BVSP_BPA";
                sPai_ID = "BPA_ID";
            }else{
                sTabela = "BVSP_BPP";
                sPai_ID = "BPP_ID";
            }
            
            hDadosTab.put("sTabela", sTabela);
            hDadosTab.put("sPai_ID", sPai_ID);
            
            return hDadosTab;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private int insereCabecalhoRelatorio(String sTabela,
            String sPai_ID,ArrayList<ModeloImportar> lImportar) throws Exception{
        try{
            String sSql;
            int iPai_ID = 0;
            
            sSql = " INSERT INTO " + sTabela + "(EMPRESA_ID,PERIODO_1,PERIODO_2,PERIODO_3)";
            sSql += " VALUES( ";
            sSql += "    " + lImportar.get(0).getEmpresa_ID();
            sSql += "   ,'" + lImportar.get(0).getPeriodo_1().replace("�", "") + "'";
            sSql += "   ,'" + lImportar.get(0).getPeriodo_2().replace("�", "") + "'";
            sSql += "   ,'" + lImportar.get(0).getPeriodo_3().replace("�", "") + "'";                
            sSql += " )";

            if (!sSql.trim().isEmpty()){
                conn.Alterar(sSql);
                ResultSet rs = conn.Selecionar("SELECT MAX(" + sPai_ID + ") FROM " + sTabela );
                if (rs.next()){
                    iPai_ID = rs.getInt(sPai_ID);
                }
            }
            
            return iPai_ID;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private void insereDadosRelatorio(String sTabela, 
            String sPai_ID,int iPai_ID, 
            ArrayList<ModeloImportar> lImportar) throws Exception{
        try{
            String sSql;
            
            for (int i = 1; i < lImportar.size(); i++){
                ModeloImportar mImportar = lImportar.get(i);

                sSql = " INSERT INTO "+ sTabela +"_DADOS("+ sPai_ID +",EMPRESA_ID,PERIODO_1,PERIODO_2,PERIODO_3)";
                sSql += " VALUES( ";
                sSql += "   ," + iPai_ID;
                sSql += "   ," + mImportar.getEmpresa_ID();
                sSql += "   ," + mImportar.getPeriodo_1();
                sSql += "   ," + mImportar.getPeriodo_2();
                sSql += "   ," + mImportar.getPeriodo_3();                
                sSql += " ) '";

                if (!sSql.trim().isEmpty()){
                    conn.Inserir(sSql);                    
                }
            }
        }catch(Exception ex){
            throw ex;
        }
    }
}
