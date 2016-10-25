package Controle;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import App.AppWs;
import Dados.DadosUsuario;
import Modelo.ModeloUsuario;

@Path("/usuarios")
public class ControleUsuario extends DadosUsuario {
	
	@Context private javax.servlet.http.HttpServletRequest hsr;
	
	@POST
	@Path("/autenticar/{jUsuario}")
	@Produces("application/json")
	public ModeloUsuario autenticar(@PathParam("jUsuario") String jUsuario){
		try{
			AppWs.logAcesso(hsr,"ControleUsuario","autenticar");
			
			ModeloUsuario mUsuario = new ModeloUsuario();
			
			mUsuario = AppWs.gJson.fromJson(jUsuario, ModeloUsuario.class);
			
			return autenticarUsuario(mUsuario);
		}catch(Exception ex){
			AppWs.gravarLog("ControleUsuario", "autenticar","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
	
	@POST
	@Path("/listar/{sUsuarioLogado_Id}")
	@Produces("application/json")
	public ArrayList<ModeloUsuario> listar(@PathParam("sUsuarioLogado_Id") String sUsuarioLogado_Id){
		try{
			AppWs.logAcesso(hsr,"ControleUsuario","listar");
			
			if (sUsuarioLogado_Id.isEmpty() || 
					Integer.parseInt(sUsuarioLogado_Id) == 0){
				return null;
			}
			
			if (consultarUsuarios(
					Integer.parseInt(sUsuarioLogado_Id)).size() == 0){
				return null;
			}
			
			return consultarUsuarios();
		}catch(Exception ex){
			AppWs.gravarLog("ControleAutenticacao", "listar","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
	
	@POST
	@Path("/consultar/{sUsuarioLogado_Id}/{sUsuario_Id}")
	@Produces("application/json")
	public ArrayList<ModeloUsuario> consultar(@PathParam("sUsuarioLogado_Id") String sUsuarioLogado_Id,
			@PathParam("sUsuario_Id") String sUsuario_Id){
		try{
			AppWs.logAcesso(hsr,"ControleUsuario","consultar");
			
			if (sUsuarioLogado_Id.isEmpty() || 
					Integer.parseInt(sUsuarioLogado_Id) == 0){
				return null;
			}
			
			if (consultarUsuarios(
					Integer.parseInt(sUsuarioLogado_Id)).size() == 0){
				return null;
			}
			
			if (sUsuario_Id.isEmpty()){
				return null;
			}
			
			return consultarUsuarios(
					Integer.parseInt(sUsuario_Id));
		}catch(Exception ex){
			AppWs.gravarLog("ControleAutenticacao", "consultar","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
}
