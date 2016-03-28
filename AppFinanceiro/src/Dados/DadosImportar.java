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
                
                String sSql;
                String sTabela;
                String sPai_ID;
                int iPai_ID = 0;
                
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
                
                sSql = " INSERT INTO " + sTabela + "(EMPRESA_ID,PERIODO_1,PERIODO_2,PERIODO_3)";
                sSql += " VALUES( ";
                sSql += "    " + lImportar.get(0).getEmpresa_ID();
                sSql += "   ,'" + lImportar.get(0).getPeriodo_1().replace("�", "") + "'";
                sSql += "   ,'" + lImportar.get(0).getPeriodo_2().replace("�", "") + "'";
                sSql += "   ,'" + lImportar.get(0).getPeriodo_3().replace("�", "") + "'";                
                sSql += " )";
                
                if (!sSql.trim().isEmpty()){
                    conn.getStatement().executeUpdate(sSql);
                    ResultSet rs = conn.getStatement().getGeneratedKeys();
                    rs.next();
                    iPai_ID = rs.getInt(1);
                }
                
                if (iPai_ID == 0){ return false;}
                
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
                conn.fecharConexao();
            }
            return true; 
        }catch(Exception ex){
            throw ex;
        }
    }
}
