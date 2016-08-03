package Controle;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import App.AppWs;
import Dados.DadosUsuario;
import Modelo.ModeloUsuario;

@Path("/autenticacao")
public class ControleUsuario {
	private DadosUsuario dAutenticacao = new  DadosUsuario();
	
	@Context private javax.servlet.http.HttpServletRequest hsr;
	
	@POST
	@Path("/autenticar/{jUsuario}")
	@Produces("application/json")
	public ModeloUsuario autenticar(@PathParam("jUsuario") String jUsuario){
		try{
			AppWs.logAcesso(hsr,"DadosAutenticacao","autenticar");
			ModeloUsuario mUsuario = new ModeloUsuario();
			mUsuario = AppWs.gJson.fromJson(jUsuario, ModeloUsuario.class);
			return dAutenticacao.consultarUsuario(mUsuario);
		}catch(Exception ex){
			AppWs.gravarLog("ControleAutenticacao", "autenticar","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
}
