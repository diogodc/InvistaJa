package Controle;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import App.AppWs;
import Dados.DadosAutenticacao;
import Modelo.ModeloUsuario;

@Path("")
public class ControleAutenticacao {
	private DadosAutenticacao dAutenticacao = new  DadosAutenticacao();
	
	@Context private javax.servlet.http.HttpServletRequest hsr;
	@POST
	@Path("/autenticar/{jUsuario}")
	@Produces("application/json")
	public ModeloUsuario autenticar(@PathParam("jUsuario") String jUsuario){
		try{
			logAutenticacao();
			ModeloUsuario mUsuario = new ModeloUsuario();
			mUsuario = AppWs.gJson.fromJson(jUsuario, ModeloUsuario.class);
			return dAutenticacao.consultarUsuario(mUsuario);
		}catch(Exception ex){
			AppWs.gravarLog("ControleAutenticacao", "autenticar","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
	
	private void logAutenticacao(){
		try{
			AppWs.gravarLog("ControleAutenticacao", "logAutenticacao",
					"LogWS_InvistaJa_Autenticacao.txt",
					"Dados remotos --> IP: " + hsr.getRemoteAddr() +
					" Porta: " + hsr.getRemotePort(),
					"Dados locais --> IP: " + hsr.getServerName() +
					" Porta: " + hsr.getServerPort());
		}catch(Exception ex){
			
		}
	}
}
