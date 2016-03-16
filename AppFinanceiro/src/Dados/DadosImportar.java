/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import static App.AppFinanceiro.conn;
import Modelo.ModeloImportarBPA;
import Modelo.ModeloImportarBPP;
import Modelo.ModeloImportarDRE;
import java.util.ArrayList;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosImportar {
        
    public boolean importarDRE(ArrayList<ModeloImportarDRE> lImportar) throws Exception{
        try{
            if (lImportar.size()> 0){
                conn.abrirConexao();
                
                //Inicialmente insere o cabeçalho:
                String sSql = "";
                
                sSql += " INSERT INTO BVSP_DRE(DRE_ID,EMPRESA_ID,PERIODO_1,PERIODO_2,PERIODO_3)";
                sSql += " VALUES( ";
                sSql += "   (SELECT (NVL(MAX(DRE_ID),0)+1) FROM BVSP_DRE),";
                sSql += "   ," + lImportar.get(0).getEmpresa_ID();
                sSql += "   ," + lImportar.get(0).getPeriodo_1();
                sSql += "   ," + lImportar.get(0).getPeriodo_2();
                sSql += "   ," + lImportar.get(0).getPeriodo_3();                
                sSql += " ) '";
                
                if (sSql.trim().isEmpty()){
                    conn.Inserir(sSql);
                }
                
                sSql = "";
                
                //Em seguida insere os filhos:
                for (int i = 1; i < lImportar.size(); i++){
                    ModeloImportarDRE mImportar = lImportar.get(i);

                    sSql += " INSERT INTO BVSP_DRE_DADOS(DRE_ID,EMPRESA_ID,PERIODO_1,PERIODO_2,PERIODO_3)";
                    sSql += " VALUES( ";
                    sSql += "   (SELECT (NVL(MAX(DRE_ID),0)+1) FROM BVSP_DRE),";
                    sSql += "   ," + mImportar.getEmpresa_ID();
                    sSql += "   ," + mImportar.getPeriodo_1();
                    sSql += "   ," + mImportar.getPeriodo_2();
                    sSql += "   ," + mImportar.getPeriodo_3();                
                    sSql += " ) '";

                    if (!sSql.trim().isEmpty()){
                        conn.Inserir(sSql);
                        sSql = "";                     
                    }
                    conn.fecharConexao();
                }
            }
            return true; 
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean importarBPP(ArrayList<ModeloImportarBPP> lImportar) throws Exception{
       try{
            if (lImportar.size()> 0){
                StringBuilder sbSql = new StringBuilder();
                conn.abrirConexao();
                for (int i = 0; i < lImportar.size(); i++){
                    //ModeloImportarDRE mImportar = lImportar.get(i);
                    sbSql.append(" INSERT INTO TAB_TESTE(DESCRICAO) ");
                    //sbSql.append(" VALUES( '" + mImportar.getDescricao().replace("'", "''")  + "') ");
                    if (!sbSql.toString().trim().isEmpty()){
                        conn.Inserir(sbSql.toString());
                        sbSql.delete(0,sbSql.length());                      
                    }
                }
                conn.fecharConexao();
            }
            return true; 
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean importarBPA(ArrayList<ModeloImportarBPA> lImportar) throws Exception{
        try{
            if (lImportar.size()> 0){
                StringBuilder sbSql = new StringBuilder();
                conn.abrirConexao();
                for (int i = 0; i < lImportar.size(); i++){
                    //ModeloImportarDRE mImportar = lImportar.get(i);
                    sbSql.append(" INSERT INTO TAB_TESTE(DESCRICAO) ");
                    //sbSql.append(" VALUES( '" + mImportar.getDescricao().replace("'", "''")  + "') ");
                    if (!sbSql.toString().trim().isEmpty()){
                        conn.Inserir(sbSql.toString());
                        sbSql.delete(0,sbSql.length());                      
                    }
                }
                conn.fecharConexao();
            }
            return true; 
        }catch(Exception ex){
            throw ex;
        }
    }
}
