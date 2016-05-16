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
    
    public String salvar(ModeloEmpresa mEmpresa) throws Exception{
        try{
            if(mEmpresa == null){return "";}
            
            if (mEmpresa.getEmpresa_ID() == 0) {
                return this.inserir(mEmpresa);               
            }else{
                return this.atualizar(mEmpresa);
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private String inserir(ModeloEmpresa mEmpresa) throws Exception{
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
            sSql += "     (BVSP_EMPRESA_SEQ.NEXTVAL";
            sSql += "     ,'" + mEmpresa.getRazao_Social().replace("'", "''") + "'";
            sSql += "     ,'" + mEmpresa.getNome_Fantasia().replace("'", "''") + "'";
            sSql += "     ,'" + mEmpresa.getCNPJ().replace("'", "''") + "'";
            sSql += "     ,'" + mEmpresa.getAtividade().replace("'", "''") + "'";
            sSql += "    ) ";
            
            if (!sSql.trim().isEmpty()){
                if (conn.Inserir(sSql)){
                    ResultSet rs = conn.Selecionar(getUltimoID());
                    rs.next();
                    return rs.getString("CURRVAL");
                }
            }
            
            conn.fecharConexao();
            
            return "";
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private String atualizar(ModeloEmpresa mEmpresa) throws Exception{
        try{
            if(mEmpresa == null){return "";}
            
            conn.abrirConexao();
            String sSql;
            
            sSql =  "UPDATE BVSP_EMPRESA SET";
            sSql += "    RAZAO_SOCIAL = " + mEmpresa.getRazao_Social().replace("'", "''");
            sSql += "    NOME_FANTASIA = " + mEmpresa.getNome_Fantasia().replace("'", "''");
            sSql += "    CNPJ = " + mEmpresa.getCNPJ().replace("'", "''");
            sSql += "    ATIVIDADE = " + mEmpresa.getAtividade().replace("'", "''");
            sSql += " WHERE ID_EMPRESA = " + mEmpresa.getEmpresa_ID();
            
            if (sSql.trim().isEmpty()){
                if (conn.Alterar(sSql)){
                   ResultSet rs = conn.Selecionar(getUltimoID());
                   if (rs.next()){
                        return rs.getString("CURRVAL");
                   }
                }
            }
            
            conn.fecharConexao();
            
            return "";
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private String getUltimoID() throws Exception{
        try{
            String sSql;
            
            sSql =  " SELECT  ";
            sSql += "   BVSP_EMPRESA_SEQ.CURRVAL";
            sSql += " FROM BVSP_EMPRESA ";
            sSql += " WHERE ROWNUM < 2 ";
            
            return sSql;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean excluir(int codEmpresa) throws Exception{
        try{
            conn.abrirConexao();
            String sSql;
            
            sSql =  " DELETE FROM BVSP_EMPRESA ";
            sSql += " WHERE ID_EMPRESA = " + codEmpresa;
            
            if (conn.Inserir(sSql)){
                return true;
            }
            
            conn.fecharConexao();
            
            return false;
        }catch(Exception ex){
            throw ex;
        }
    }
}
