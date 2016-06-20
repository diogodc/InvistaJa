/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.ResultSet;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosManipulacao extends DadosConexao {

    public ResultSet Selecionar(String sQuery) throws Exception{
        try{
            return consultar(sQuery);
        }catch(Exception ex){
            throw ex;
        }
    }
    public boolean Alterar(String sQuery) throws Exception{
        try{
            return alterar(sQuery);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean Excluir(String sQuery) throws Exception{
        try{
            return alterar(sQuery);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean Inserir(String sQuery) throws Exception{
        try{
            return alterar(sQuery);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean Procedure(String sQuery) throws Exception{
        try{
            return alterar(sQuery);
        }catch(Exception ex){
            throw ex;
        }
    }
}
