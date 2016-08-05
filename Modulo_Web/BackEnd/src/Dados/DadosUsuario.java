package Dados;

import java.sql.ResultSet;
import java.util.ArrayList;

import App.AppWs;
import Modelo.ModeloUsuario;

public class DadosUsuario {
	protected ModeloUsuario autenticarUsuario (ModeloUsuario mUsuario){
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
                mUsuario.setRetorno(true);
            }else{
            	mUsuario.setSenha("");
            	mUsuario.setUsuario("");
            	mUsuario.setUsuario_ID("");
                mUsuario.setUsuario_Nome("");
                mUsuario.setRetorno(false);
            }
            
            AppWs.conn.fecharConexao();
            
			return mUsuario;
		}catch(Exception ex){
			AppWs.gravarLog("DadosUsuario", "autenticarUsuario","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
	
	public ArrayList<ModeloUsuario> consultarUsuarios(){
		return consultar(0);
	}
	
	public ArrayList<ModeloUsuario> consultarUsuarios(int iUsuario_Id){
		return consultar(iUsuario_Id);
	}
	
	private ArrayList<ModeloUsuario> consultar(int iUsuario_Id){
		try{
			AppWs.conn.abrirConexao();
			
			ArrayList<ModeloUsuario> lmUsuario = new ArrayList<ModeloUsuario>(); 
			String sSql;
			
			sSql  = " SELECT";
			sSql += "	BVSP_USUARIO.ID_USUARIO,";
			sSql += "	BVSP_USUARIO.NOME_COMPLETO,";
			sSql += "	BVSP_USUARIO.SENHA,";
			sSql += "	BVSP_USUARIO.USUARIO";
			sSql += " FROM BVSP_USUARIO";
			if (iUsuario_Id != 0){sSql += " WHERE BVSP_USUARIO.ID_USUARIO = " + iUsuario_Id;}
			
            ResultSet rs = AppWs.conn.Selecionar(sSql);
            
            while (rs.next()){
            	ModeloUsuario mUsuario = new ModeloUsuario();
            	mUsuario.setUsuario_ID(rs.getString("ID_USUARIO"));
                mUsuario.setUsuario_Nome(rs.getString("NOME_COMPLETO"));
                mUsuario.setSenha(rs.getString("SENHA"));
                mUsuario.setUsuario(rs.getString("USUARIO"));
                mUsuario.setRetorno(true);
                lmUsuario.add(mUsuario);
            }
            
            AppWs.conn.fecharConexao();
            
			return lmUsuario;
		}catch(Exception ex){
			AppWs.gravarLog("DadosUsuario", "consultarUsuarios","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
}
