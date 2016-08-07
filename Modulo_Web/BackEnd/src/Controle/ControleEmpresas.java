package Controle;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import App.AppWs;
import Dados.DadosEmpresa;
import Dados.DadosUsuario;
import Modelo.ModeloEmpresa;

@Path("/empresas")
public class ControleEmpresas extends DadosEmpresa {
	
	@Context private javax.servlet.http.HttpServletRequest hsr;
	
	@POST
	@Path("/listar/{sUsuarioLogado_Id}")
	@Produces("application/json")
	public ArrayList<ModeloEmpresa> listar(
			@PathParam("sUsuarioLogado_Id") String sUsuarioLogado_Id){
		try{
			AppWs.logAcesso(hsr,"ControleEmpresas","listar");
			
			if (sUsuarioLogado_Id.isEmpty() || 
					Integer.parseInt(sUsuarioLogado_Id) == 0){
				return null;
			}
			
			if (new DadosUsuario().consultarUsuarios(
					Integer.parseInt(sUsuarioLogado_Id)).size() == 0){
				return null;
			}

			return consultarEmpresas();
		}catch(Exception ex){
			AppWs.gravarLog("ControleEmpresas", "empresas","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
	
	@POST
	@Path("/consultar/{sUsuarioLogado_Id}/{sEmpresa_Id}")
	@Produces("application/json")
	public ArrayList<ModeloEmpresa> consultar(
			@PathParam("sUsuarioLogado_Id") String sUsuarioLogado_Id,
			@PathParam("sEmpresa_Id") String sEmpresa_Id){
		try{
			AppWs.logAcesso(hsr,"ControleEmpresas","consultar");
			
			if (sUsuarioLogado_Id.isEmpty() || 
					Integer.parseInt(sUsuarioLogado_Id) == 0){
				return null;
			}
			
			if (new DadosUsuario().consultarUsuarios(
					Integer.parseInt(sUsuarioLogado_Id)).size() == 0){
				return null;
			}
			
			return consultarEmpresas(Integer.parseInt(sEmpresa_Id));
		}catch(Exception ex){
			AppWs.gravarLog("ControleEmpresas", "empresa","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
}
