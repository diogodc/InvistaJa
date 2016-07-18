/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import static App.AppFinanceiro.conn;
import Modelo.ModeloUsuario;
import java.sql.ResultSet;

/**
 *
 * @author Everaldo Cardoso
 */
public class DadosAutenticacao {
    public ModeloUsuario autenticar(ModeloUsuario mUsuario) throws Exception{
        try{
            conn.abrirConexao();
            
            String sSql;
            
            sSql =  " SELECT ";
            sSql += "   BVSP_USUARIO.ID_USUARIO,";
            sSql += "   BVSP_USUARIO.NOME_COMPLETO";
            sSql += " FROM BVSP_USUARIO ";
            sSql += " WHERE BVSP_USUARIO.USUARIO = '" + mUsuario.getUsuario() + "' ";
            sSql += " AND BVSP_USUARIO.SENHA = '" + mUsuario.getSenha() + "'";
            sSql += " LIMIT 1";
            
            ResultSet rs = conn.Selecionar(sSql);
            
            if (rs.next()){
               mUsuario.setUsuario_ID(rs.getString("ID_USUARIO"));
               mUsuario.setUsuario_Nome(rs.getString("NOME_COMPLETO"));
            } 
            
            return mUsuario;
        }catch(Exception ex){
             throw ex;
        }finally{
            conn.fecharConexao();
        }
    }
}
