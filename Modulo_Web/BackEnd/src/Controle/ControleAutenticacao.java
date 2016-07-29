package Controle;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import App.AppWs;
import Dados.DadosAutenticacao;
import Modelo.ModeloUsuario;

@Path("/autenticacao")
public class ControleAutenticacao {
	private DadosAutenticacao dAutenticacao = new  DadosAutenticacao();
	
	@GET
	@Path("/autenticar/{usuario}/{senha}")
	@Produces("application/json")
	public ModeloUsuario autenticar(@PathParam("usuario") String sUsuario, @PathParam("senha") String sSenha){
		try{
			return dAutenticacao.autenticar(getModeloUsuario(sUsuario,sSenha));
		}catch(Exception ex){
			AppWs.gravarLog("ControleAutenticacao", "autenticar","", ex.getMessage());
			return null;
		}
	}
	
	private ModeloUsuario getModeloUsuario(String sUsuario, String sSenha){
		try{
			ModeloUsuario mUsuario = new ModeloUsuario();
			mUsuario.setUsuario(sUsuario);
			mUsuario.setSenha(sSenha);
			return mUsuario;
		}catch(Exception ex){
			AppWs.gravarLog("ControleAutenticacao", "getModel","", ex.getMessage());
			return null;
		}
	}
}
