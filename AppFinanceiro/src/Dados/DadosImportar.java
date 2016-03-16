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
import javax.swing.JLabel;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosImportar {
    
    public boolean importar(ArrayList<ModeloImportar> lImportar,
            tipoRelatorio tRelatorio) throws Exception{
        try{
            switch (tRelatorio) {
                case DRE:
                    return importarDRE(lImportar);
                case BPA:
                    return  importarBPP(lImportar);
                default:
                    return importarBPA(lImportar);
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private boolean importarDRE(ArrayList<ModeloImportar> lImportar) throws Exception{
        try{
            if (lImportar.size()> 0){
                StringBuilder sbSql = new StringBuilder();
                conn.abrirConexao();
                for (int i = 0; i < lImportar.size(); i++){
                    ModeloImportar mImportar = lImportar.get(i);
                    sbSql.append(" INSERT INTO TAB_TESTE(DESCRICAO) ");
                    sbSql.append(" VALUES( '" + mImportar.getDescricao().replace("'", "''")  + "') ");
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
    
    private boolean importarBPP(ArrayList<ModeloImportar> lImportar) throws Exception{
       try{
            if (lImportar.size()> 0){
                StringBuilder sbSql = new StringBuilder();
                conn.abrirConexao();
                for (int i = 0; i < lImportar.size(); i++){
                    ModeloImportar mImportar = lImportar.get(i);
                    sbSql.append(" INSERT INTO TAB_TESTE(DESCRICAO) ");
                    sbSql.append(" VALUES( '" + mImportar.getDescricao().replace("'", "''")  + "') ");
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
    
    private boolean importarBPA(ArrayList<ModeloImportar> lImportar) throws Exception{
        try{
            if (lImportar.size()> 0){
                StringBuilder sbSql = new StringBuilder();
                conn.abrirConexao();
                for (int i = 0; i < lImportar.size(); i++){
                    ModeloImportar mImportar = lImportar.get(i);
                    sbSql.append(" INSERT INTO TAB_TESTE(DESCRICAO) ");
                    sbSql.append(" VALUES( '" + mImportar.getDescricao().replace("'", "''")  + "') ");
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
