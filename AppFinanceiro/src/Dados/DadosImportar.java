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
                    ModeloImportar mImportar = lImportar.get(i);

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
}
