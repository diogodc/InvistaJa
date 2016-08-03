package Dados;

import java.sql.ResultSet;

import App.AppWs;
import Modelo.ModeloUsuario;

public class DadosUsuario {
	public ModeloUsuario consultarUsuario (ModeloUsuario mUsuario){
		try{
			AppWs.conn.abrirConexao();
			
			String sSql;
			
			sSql  = " SELECT"; 
			sSql += "	BVSP_USUARIO.ID_USUARIO,";
			sSql += "	BVSP_USUARIO.NOME_COMPLETO";
			sSql += " FROM BVSP_USUARIO"; 
			sSql += " WHERE BVSP_USUARIO.USUARIO = '" + mUsuario.getUsuario() + "' ";
            sSql += " AND BVSP_USUARIO.SENHA = '" + mUsuario.getSenha() + "'";
            sSql += " LIMIT 1";
            
            ResultSet rs = AppWs.conn.Selecionar(sSql);
            
            if (rs.next()){
                mUsuario.setUsuario_ID(rs.getString("ID_USUARIO"));
                mUsuario.setUsuario_Nome(rs.getString("NOME_COMPLETO"));
            } 
            
			return mUsuario;
		}catch(Exception ex){
			AppWs.gravarLog("ControleAutenticacao", "autenticar","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
}
