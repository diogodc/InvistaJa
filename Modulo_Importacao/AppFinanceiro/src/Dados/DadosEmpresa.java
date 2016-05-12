/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import static App.AppFinanceiro.conn;
import Modelo.ModeloEmpresa;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosEmpresa {
    public ArrayList<ModeloEmpresa> carregarEmpresa() throws Exception{
        try{
            conn.abrirConexao();
            
            ArrayList<ModeloEmpresa> lmEmpresa = new ArrayList<ModeloEmpresa>(); 
            String sSql;
            
            sSql = " SELECT  ";
            sSql +="    BVSP_EMPRESA.ID_EMPRESA, " ;
            sSql +="    BVSP_EMPRESA.RAZAO_SOCIAL, " ;
            sSql +="    BVSP_EMPRESA.NOME_FANTASIA, " ;
            sSql +="    BVSP_EMPRESA.CNPJ, " ;
            sSql +="    BVSP_EMPRESA.ATIVIDADE " ;
            sSql +=" FROM BVSP_EMPRESA " ;
            
            ResultSet rs = conn.Selecionar(sSql);
            
            while(rs.next()){
                ModeloEmpresa mEmpresa = new ModeloEmpresa();
                mEmpresa.setEmpresa_ID(rs.getInt("EMPRESA_ID"));
                mEmpresa.setCNPJ(rs.getString("RAZAO_SOCIAL"));
                mEmpresa.setNome_Fantasia(rs.getString("NOME_FANTASIA"));
                mEmpresa.setRazao_Social(rs.getString("RAZAO_SOCIAL"));
                mEmpresa.setAtividade(rs.getString("ATIVIDADE"));
                lmEmpresa.add(mEmpresa);
            }
            
            conn.fecharConexao();
            
            return lmEmpresa;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public String salvarEmpresa(ModeloEmpresa mEmpresa) throws Exception{
        try{
            if(mEmpresa == null){return "";}
            
            conn.abrirConexao();
            String sSql;
            
            sSql =  " INSERT INTO BVSP_EMPRESA ";
            sSql += "     (ID_EMPRESA, ";
            sSql += "     RAZAO_SOCIAL, ";
            sSql += "     NOME_FANTASIA, ";
            sSql += "     CNPJ, ";
            sSql += "     ATIVIDADE) ";
            sSql += " VALUES ";
            sSql += "     ((SELECT NVL(MAX(ID_EMPRESA),0)+1 AS ID_EMPRESA FROM BVSP_EMPRESA)";
            sSql += "     ," + mEmpresa.getRazao_Social().replace("'", "''");
            sSql += "     ," + mEmpresa.getNome_Fantasia().replace("'", "''");
            sSql += "     ," + mEmpresa.getCNPJ().replace("'", "''");
            sSql += "     ," + mEmpresa.getAtividade().replace("'", "''");
            sSql += "    ) ";
            
            if (!sSql.trim().isEmpty()){
                conn.Inserir(sSql);
            }
            
            return "";
        }catch(Exception ex){
            throw ex;
        }
    }
}
