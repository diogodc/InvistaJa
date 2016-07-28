package Controle;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import App.AppWs;
import Modelo.ModeloUsuario;

@Path("/autenticacao")
public class ControleAutenticacao {
	
	@GET
	@Path("/autenticar/{usuario}/{senha}")
	@Produces("application/json")
	public ModeloUsuario autenticar(@PathParam("usuario") String sUsuario, @PathParam("senha") String sSenha){
		try{
			
		}catch(Exception ex){
			AppWs.gravarLog("ControleAutenticacao", "autenticar","", ex.getMessage());
		}
		return null;
	}
}
