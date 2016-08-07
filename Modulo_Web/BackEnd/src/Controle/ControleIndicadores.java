package Controle;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import App.AppWs;
import Dados.DadosEmpresa;
import Dados.DadosIndicadores;
import Dados.DadosUsuario;
import Modelo.ModeloEmpresa;
import Modelo.ModeloGrupo;
import Modelo.ModeloIndEmpresa;
import Modelo.ModeloIndicador;

@Path("/indicadores")
public class ControleIndicadores extends DadosIndicadores {
	
	@Context private javax.servlet.http.HttpServletRequest hsr;
	
	@POST
	@Path("/listar/{sUsuarioLogado_Id}")
	@Produces("application/json")
	public ArrayList<ModeloIndEmpresa> listar(
			@PathParam("sUsuarioLogado_Id") String sUsuarioLogado_Id){
		try{
			AppWs.logAcesso(hsr,"ControleIndicadores","listar");
			
			if (sUsuarioLogado_Id.isEmpty() || 
					Integer.parseInt(sUsuarioLogado_Id) == 0){
				return null;
			}
			
			if (new DadosUsuario().consultarUsuarios(
					Integer.parseInt(sUsuarioLogado_Id)).size() == 0){
				return null;
			}
			
			return gerarIndicadores();
		}catch(Exception ex){
			AppWs.gravarLog("ControleIndicadores", "listar","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}

	@POST
	@Path("/consultar/{sUsuarioLogado_Id}/{sEmpresa_Id}")
	@Produces("application/json")
	public ArrayList<ModeloIndEmpresa> consultar(
			@PathParam("sUsuarioLogado_Id") String sUsuarioLogado_Id,
			@PathParam("sEmpresa_Id") String sEmpresa_Id){
		try{
			AppWs.logAcesso(hsr,"ControleIndicadores","consultar");
			
			if (sUsuarioLogado_Id.isEmpty() || 
					Integer.parseInt(sUsuarioLogado_Id) == 0){
				return null;
			}
			
			if (new DadosUsuario().consultarUsuarios(
					Integer.parseInt(sUsuarioLogado_Id)).size() == 0){
				return null;
			}
			
			return gerarIndicadores(sEmpresa_Id);
		}catch(Exception ex){
			AppWs.gravarLog("ControleIndicadores", "consultar","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
	
	private ArrayList<ModeloIndEmpresa> gerarIndicadores(String sEmpresa_Id){
		try{
			return gerarIndicadoresEmpresa(sEmpresa_Id);
		}catch (Exception ex) {
			AppWs.gravarLog("ControleIndicadores", "gerarIndicadores","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
        }
	}
	
	private ArrayList<ModeloIndEmpresa> gerarIndicadores(){
		try{
			return gerarIndicadoresEmpresa("");
		}catch (Exception ex) {
			AppWs.gravarLog("ControleIndicadores", "gerarIndicadores","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
        }
	}
	
    private ArrayList<ModeloIndEmpresa> gerarIndicadoresEmpresa(String sEmpresa_Id){
        try{
            ArrayList<ModeloIndEmpresa> lmIndEmpresa = new ArrayList<ModeloIndEmpresa>();
            ArrayList<ModeloEmpresa> lmEmpresas;
            
            if (!sEmpresa_Id.isEmpty()){
            	lmEmpresas = new DadosEmpresa().consultarEmpresas(Integer.parseInt(sEmpresa_Id));
            }else{
            	lmEmpresas = new DadosEmpresa().consultarEmpresas();
            }
            
            for (int i = 0; i<lmEmpresas.size();i++){
                ModeloIndEmpresa mIndEmpresa = new ModeloIndEmpresa();
                ModeloEmpresa mEmpresa = lmEmpresas.get(i);
                calcularIndicadores(mEmpresa.getEmpresa_ID(),"2013","2014","2015");
                mIndEmpresa.setEmpresa_ID(mEmpresa.getEmpresa_ID());
                mIndEmpresa.setLmGrupo(this.gerarGrupo(mEmpresa.getEmpresa_ID()));
                lmIndEmpresa.add(mIndEmpresa);
            }

            return lmIndEmpresa;
        }catch (Exception ex) {
        	AppWs.gravarLog("ControleIndicadores", "gerarIndicadoresEmpresa","",
					ex.getMessage(),ex.getStackTrace().toString());
        	return null;
        }
    }
    
    private ArrayList<ModeloGrupo> gerarGrupo(int iEmpresa_ID) {
        try{
            ArrayList<ModeloGrupo> lmGrupo = new ArrayList<ModeloGrupo>();
            ModeloGrupo mGrupoEndividamento = new ModeloGrupo();
            ModeloGrupo mGrupoLiquidez = new ModeloGrupo();
            ModeloGrupo mGrupoRentabilidade = new ModeloGrupo();
            ModeloGrupo mGrupoPrazosMedios = new ModeloGrupo();
            
            mGrupoEndividamento.setGrupo("endividamento");
            mGrupoEndividamento.setlmIndicador(this.gerarIndicadores(iEmpresa_ID,AppWs.tipoGrupo.Endividamento));
            lmGrupo.add(mGrupoEndividamento);
            
            mGrupoLiquidez.setGrupo("liquidez");
            mGrupoLiquidez.setlmIndicador(this.gerarIndicadores(iEmpresa_ID,AppWs.tipoGrupo.Liquidez));
            lmGrupo.add(mGrupoLiquidez);
            
            mGrupoRentabilidade.setGrupo("rentabilidade");
            mGrupoRentabilidade.setlmIndicador(this.gerarIndicadores(iEmpresa_ID,AppWs.tipoGrupo.Rentabilidade));
            lmGrupo.add(mGrupoRentabilidade);
            
            mGrupoPrazosMedios.setGrupo("prazosmedios");
            mGrupoPrazosMedios.setlmIndicador(this.gerarIndicadores(iEmpresa_ID,AppWs.tipoGrupo.PrazosMedios));
            lmGrupo.add(mGrupoPrazosMedios);
            
            return lmGrupo;
        }catch (Exception ex) {
        	AppWs.gravarLog("ControleIndicadores", "gerarGrupo","",
					ex.getMessage(),ex.getStackTrace().toString());
        	return null;
        }
    }
    
    private ArrayList<ModeloIndicador> gerarIndicadores(int iEmpresa_ID,AppWs.tipoGrupo tGrupo) {
        try{
            ArrayList<ModeloIndicador> lmIndicadores = new ArrayList<ModeloIndicador>();
                        
            if (tGrupo == AppWs.tipoGrupo.Endividamento){
               ModeloIndicador mIndicadorPct = new ModeloIndicador();
               ModeloIndicador mIndicadorCe = new ModeloIndicador();
               ModeloIndicador mIndicadorIpl = new ModeloIndicador();

               mIndicadorPct.setIndicador("pct");
               mIndicadorPct.setLmResultado(gerarResultados(iEmpresa_ID,"IE_PCT"));
               lmIndicadores.add(mIndicadorPct);
               
               mIndicadorCe.setIndicador("ce");
               mIndicadorCe.setLmResultado(gerarResultados(iEmpresa_ID,"IE_CE"));
               lmIndicadores.add(mIndicadorCe);
               
               mIndicadorIpl.setIndicador("ipl");
               mIndicadorIpl.setLmResultado(gerarResultados(iEmpresa_ID,"IE_IPL"));
               lmIndicadores.add(mIndicadorIpl);
               
            }else if (tGrupo == AppWs.tipoGrupo.Liquidez){
               ModeloIndicador mIndicadorLg = new ModeloIndicador();
               ModeloIndicador mIndicadorIlc = new ModeloIndicador();
               ModeloIndicador mIndicadorIls = new ModeloIndicador();
               ModeloIndicador mIndicadorCcl = new ModeloIndicador();
               
               mIndicadorLg.setIndicador("lg");
               mIndicadorLg.setLmResultado(gerarResultados(iEmpresa_ID,"IL_LG"));
               lmIndicadores.add(mIndicadorLg);
               
               mIndicadorIlc.setIndicador("ilc");
               mIndicadorIlc.setLmResultado(gerarResultados(iEmpresa_ID,"IL_LC"));
               lmIndicadores.add(mIndicadorIlc);
               
               mIndicadorIls.setIndicador("ils");
               mIndicadorIls.setLmResultado(gerarResultados(iEmpresa_ID,"IL_LS"));
               lmIndicadores.add(mIndicadorIls);
               
               mIndicadorCcl.setIndicador("ccl");
               mIndicadorCcl.setLmResultado(gerarResultados(iEmpresa_ID,"IL_CCL"));
               lmIndicadores.add(mIndicadorCcl);
               
            }else if (tGrupo == AppWs.tipoGrupo.Rentabilidade){
               ModeloIndicador mIndicadorGa = new ModeloIndicador();
               ModeloIndicador mIndicadorMl = new ModeloIndicador();
               ModeloIndicador mIndicadorRa = new ModeloIndicador();
               ModeloIndicador mIndicadorRpl = new ModeloIndicador();
               
               mIndicadorGa.setIndicador("ga");
               mIndicadorGa.setLmResultado(gerarResultados(iEmpresa_ID,"IR_GA"));
               lmIndicadores.add(mIndicadorGa);
               
               mIndicadorMl.setIndicador("ml");
               mIndicadorMl.setLmResultado(gerarResultados(iEmpresa_ID,"IR_ML"));
               lmIndicadores.add(mIndicadorMl);
               
               mIndicadorRa.setIndicador("ra");
               mIndicadorRa.setLmResultado(gerarResultados(iEmpresa_ID,"IR_RA"));
               lmIndicadores.add(mIndicadorRa);
               
               mIndicadorRpl.setIndicador("rpl");
               mIndicadorRpl.setLmResultado(gerarResultados(iEmpresa_ID,"IR_RPL"));
               lmIndicadores.add(mIndicadorRpl);
               
            }else{
               ModeloIndicador mIndicadorPme = new ModeloIndicador();
               ModeloIndicador mIndicadorPmr = new ModeloIndicador();
               ModeloIndicador mIndicadorPmp = new ModeloIndicador();
               ModeloIndicador mIndicadorCo = new ModeloIndicador();
               ModeloIndicador mIndicadorCf = new ModeloIndicador();
               
               mIndicadorPme.setIndicador("pme");
               mIndicadorPme.setLmResultado(gerarResultados(iEmpresa_ID,"IA_PME"));
               lmIndicadores.add(mIndicadorPme);
               
               mIndicadorPmr.setIndicador("pmr");
               mIndicadorPmr.setLmResultado(gerarResultados(iEmpresa_ID,"IA_PMR"));
               lmIndicadores.add(mIndicadorPmr);
               
               mIndicadorPmp.setIndicador("pmp");
               mIndicadorPmp.setLmResultado(gerarResultados(iEmpresa_ID,"IA_PMP"));
               lmIndicadores.add(mIndicadorPmp);
               
               mIndicadorCo.setIndicador("co");
               mIndicadorCo.setLmResultado(gerarResultados(iEmpresa_ID,"IA_CO"));
               lmIndicadores.add(mIndicadorCo);
               
               mIndicadorCf.setIndicador("cf");
               mIndicadorCf.setLmResultado(gerarResultados(iEmpresa_ID,"IA_CF"));
               lmIndicadores.add(mIndicadorCf);
            }
                
            return lmIndicadores;
        }catch (Exception ex) {
        	AppWs.gravarLog("ControleIndicadores", "gerarIndicadores","",
					ex.getMessage(),ex.getStackTrace().toString());
        	return null;
        }
    }
}
