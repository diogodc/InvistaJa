package Controle;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import App.AppWs;
import Dados.DadosIndicadores;

@Path("/indicadores")
public class ControleIndicadores extends DadosIndicadores {
	
	@Context private javax.servlet.http.HttpServletRequest hsr;
	
	@POST
	@Path("/listar/")
	@Produces("application/json")
	protected void listar(){
		try{
			//return null;
		}catch(Exception ex){
			AppWs.gravarLog("ControleIndicadores", "listar","",
					ex.getMessage(),ex.getStackTrace().toString());
			//return null;
		}
	}

	
	@POST
	@Path("/consultar/{sEmpresa_Id}")
	@Produces("application/json")
	protected void consultar(@PathParam("sEmpresa_Id") String sEmpresa_Id){
		try{
			//return null;
		}catch(Exception ex){
			AppWs.gravarLog("ControleIndicadores", "consultar","",
					ex.getMessage(),ex.getStackTrace().toString());
			//return null;
		}
	}
}
