/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import static App.AppFinanceiro.conn;
import Modelo.ModeloImportar;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosImportar {
    
    public boolean Importar(ArrayList<ModeloImportar> lImportar,JLabel lblProgresso) throws Exception{
        try{
            if (lImportar.size()> 0){
                StringBuilder sbSql = new StringBuilder();
                conn.abrirConexao();
                for (int i = 0; i < lImportar.size(); i++){
                    ModeloImportar mImportar = lImportar.get(i);
                    sbSql.append(" INSERT INTO TAB_TESTE(DESCRICAO) ");
                    sbSql.append(" VALUES( '" + mImportar.getDescricao().replace("'", "''")  + "') ");
                    if (!sbSql.toString().trim().equals("")){
                        conn.Inserir(sbSql.toString());
                        sbSql.delete(0,sbSql.length());
                        double progresso = ((100 * i) / (lImportar.size()-1));
                        lblProgresso.setText("Progresso: " + progresso + "%");                        
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
