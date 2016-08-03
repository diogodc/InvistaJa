package Controle;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import App.AppWs;
import Dados.DadosEmpresa;
import Modelo.ModeloEmpresa;

@Path("/empresas")
public class ControleEmpresas {
	DadosEmpresa dEmpresa = new DadosEmpresa();
	
	@Context private javax.servlet.http.HttpServletRequest hsr;
	
	@POST
	@Path("/listar/{sUsuario_Id}")
	@Produces("application/json")
	public ArrayList<ModeloEmpresa> listar(@PathParam("sUsuario_Id") String sUsuario_Id){
		try{
			AppWs.logAcesso(hsr,"ControleEmpresas","empresas");
			if (sUsuario_Id.isEmpty()){return null;}
			return dEmpresa.consultarEmpresas();
		}catch(Exception ex){
			AppWs.gravarLog("ControleEmpresas", "empresas","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
	
	@POST
	@Path("/consultar/{sUsuario_Id}/{sEmpresa_Id}")
	@Produces("application/json")
	public ArrayList<ModeloEmpresa> consultar(@PathParam("sEmpresa_Id") String sUsuario_Id,
			@PathParam("sEmpresa_Id") String sEmpresa_Id){
		try{
			if (sUsuario_Id.isEmpty()){return null;}
			AppWs.logAcesso(hsr,"ControleEmpresas","empresa");
			return dEmpresa.consultarEmpresas(Integer.parseInt(sEmpresa_Id));
		}catch(Exception ex){
			AppWs.gravarLog("ControleEmpresas", "empresa","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
}
