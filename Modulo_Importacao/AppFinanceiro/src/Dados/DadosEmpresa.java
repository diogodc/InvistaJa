/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import static App.AppFinanceiro.conn;
import App.AppFinanceiro.tipoEmpresas;
import Modelo.ModeloEmpresa;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosEmpresa {
      
    public ArrayList<ModeloEmpresa> carregarEmpresas(tipoEmpresas tEmpresas) throws Exception{
        try{
            conn.abrirConexao();
            
            ArrayList<ModeloEmpresa> lmEmpresa = new ArrayList<ModeloEmpresa>(); 
            String sSql;
            
            sSql = " SELECT  ";
            sSql +="    BVSP_EMPRESA.ID_EMPRESA, " ;
            sSql +="    BVSP_EMPRESA.RAZAO_SOCIAL, " ;
            sSql +="    BVSP_EMPRESA.NOME_FANTASIA, " ;
            sSql +="    BVSP_EMPRESA.CNPJ," ;
            sSql +="    BVSP_EMPRESA.ATIVIDADE " ;
            sSql +=" FROM BVSP_EMPRESA " ;
            if (tEmpresas == tipoEmpresas.IMPORTADAS){
                sSql +=" INNER JOIN BVSP_DRE ON BVSP_DRE.ID_EMPRESA = BVSP_EMPRESA.ID_EMPRESA" ;
                sSql +=" INNER JOIN BVSP_BPA ON BVSP_BPA.ID_EMPRESA = BVSP_EMPRESA.ID_EMPRESA" ;
                sSql +=" INNER JOIN BVSP_BPP ON BVSP_BPP.ID_EMPRESA = BVSP_EMPRESA.ID_EMPRESA" ; 
            }
            if (tEmpresas == tipoEmpresas.CALCULADAS){
                sSql +=" INNER JOIN BVSP_INDICADORES ON BVSP_INDICADORES.ID_EMPRESA = BVSP_EMPRESA.ID_EMPRESA" ;
            }
            if (tEmpresas == tipoEmpresas.CALCULADAS || tEmpresas == tipoEmpresas.IMPORTADAS){
                sSql +=" GROUP BY BVSP_EMPRESA.ID_EMPRESA," ;
                sSql +=" BVSP_EMPRESA.RAZAO_SOCIAL,";
                sSql +=" BVSP_EMPRESA.NOME_FANTASIA,";
                sSql +=" BVSP_EMPRESA.CNPJ,";
                sSql +=" BVSP_EMPRESA.ATIVIDADE";
            }
            
            ResultSet rs = conn.Selecionar(sSql);
            
            while(rs.next()){
                ModeloEmpresa mEmpresa = new ModeloEmpresa();
                mEmpresa.setEmpresa_ID(rs.getInt("ID_EMPRESA"));
                mEmpresa.setCNPJ(rs.getString("CNPJ"));
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
            sSql += "    (RAZAO_SOCIAL, ";
            sSql += "     NOME_FANTASIA, ";
            sSql += "     CNPJ, ";
            sSql += "     ATIVIDADE) ";
            sSql += " VALUES ";
            sSql += "     ('" + mEmpresa.getRazao_Social().replace("'", "''") + "'";
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
            sSql += "    RAZAO_SOCIAL = '" + mEmpresa.getRazao_Social() + "',";
            sSql += "    NOME_FANTASIA = '" + mEmpresa.getNome_Fantasia() + "',";
            sSql += "    CNPJ = '" + mEmpresa.getCNPJ() + "',";
            sSql += "    ATIVIDADE = '" + mEmpresa.getAtividade() + "'";
            sSql += " WHERE ID_EMPRESA = " + mEmpresa.getEmpresa_ID();
            
            if (!sSql.trim().isEmpty()){
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
            sSql += "   IFNULL(MAX(BVSP_EMPRESA.ID_EMPRESA),1) AS CURRVAL";
            sSql += " FROM BVSP_EMPRESA ";
            sSql += " LIMIT 1 ";
            
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
    
    public String zerarHistorico(ModeloEmpresa mEmpresa) throws Exception{
        try{
            conn.abrirConexao();
            
            if (mEmpresa.getEmpresa_ID() == 0){ return "Informe uma empresa!";}
            
            String sRetorno = "";
            
            if (conn.Excluir("DELETE FROM BVSP_INDICADORES WHERE ID_EMPRESA = " 
                    + mEmpresa.getEmpresa_ID())){//Deleta o Indices de situação financeira
                sRetorno += "-Indicadores\n";
            }
            if (conn.Excluir("DELETE FROM BVSP_DRE WHERE ID_EMPRESA = " 
                    + mEmpresa.getEmpresa_ID())){//Deleta o DRE
                sRetorno += "-Demostrativo de resultados\n";
            }
            if (conn.Excluir("DELETE FROM BVSP_BPA WHERE ID_EMPRESA = " 
                    + mEmpresa.getEmpresa_ID())){//Deleta o BPA
                sRetorno += "-Balanço patrimonial ativo\n";
            }
            if (conn.Excluir("DELETE FROM BVSP_BPP WHERE ID_EMPRESA = " 
                    + mEmpresa.getEmpresa_ID())){//Deleta o BPP
                sRetorno += "-Balanço patrimonial passivo\n";
            }
            
            conn.Alterar("UPDATE BVSP_EMPRESA SET BPP=NULL,BPA=NULL,DRE=NULL WHERE ID_EMPRESA = " 
                    + mEmpresa.getEmpresa_ID()); //Atualiza os indices importados
            
            if (!sRetorno.isEmpty()){
                sRetorno += "Foram zerados para esta empresa!";
            }
            if (sRetorno.isEmpty()){
                sRetorno += "Não foram encontrado dados!";
            }
            
            conn.fecharConexao();
            
            return sRetorno;
        }catch(Exception ex){
            throw ex;
        }
    }
}
