/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import App.AppFinanceiro;
import static App.AppFinanceiro.conn;
import Modelo.ModeloEmpresa;
import Modelo.ModeloGrupo;
import Modelo.ModeloIndEmpresa;
import Modelo.ModeloIndicador;
import Modelo.ModeloResultado;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Everaldo Cardoso
 */
public class DadosExportar {
    public boolean calcularIndicadores(String sAno1, String sAno2, String sAno3) throws Exception{
        try{         
            ArrayList<ModeloEmpresa> lmEmpresas = new DadosEmpresa().carregarEmpresas(AppFinanceiro.tipoEmpresas.IMPORTADAS);
            
            for (int i = 0; i < lmEmpresas.size();i++){
                ModeloEmpresa mEmpresa = lmEmpresas.get(i);
                conn.abrirConexao();
                String sSql  = "{call BVSP_SP_INDICADORES(?,?,?,?)}";
                CallableStatement  cs = conn.getConnection().prepareCall(sSql);
                cs.setInt(1, mEmpresa.getEmpresa_ID());
                cs.setString(2, sAno1);
                cs.setString(3, sAno2);
                cs.setString(4, sAno3);
                cs.execute();    
                conn.fecharConexao();
            }
             
            return true;
        }catch (Exception ex) {
            throw ex;
        }
    }
    
    private enum tipoGrupo{
        Endividamento,Liquidez,Rentabilidade,PrazosMedios;
    }
    
    public ArrayList<ModeloIndEmpresa> gerarIndicadoresEmpresa() throws Exception{
        try{
            ArrayList<ModeloIndEmpresa> lmIndEmpresa = new ArrayList<ModeloIndEmpresa>();
            ArrayList<ModeloEmpresa> lmEmpresas = new DadosEmpresa().carregarEmpresas(AppFinanceiro.tipoEmpresas.CALCULADAS);

            for (int i = 0; i<lmEmpresas.size();i++){
                ModeloIndEmpresa mIndEmpresa = new ModeloIndEmpresa();
                ModeloEmpresa mEmpresa = lmEmpresas.get(i);
                mIndEmpresa.setEmpresa_ID(mEmpresa.getEmpresa_ID());
                mIndEmpresa.setLmGrupo(this.gerarGrupo(mEmpresa.getEmpresa_ID()));
                lmIndEmpresa.add(mIndEmpresa);
            }


            return lmIndEmpresa;
        }catch (Exception ex) {
            throw ex;
        }
    }
    
    private ArrayList<ModeloGrupo> gerarGrupo(int iEmpresa_ID) throws Exception{
        try{
            ArrayList<ModeloGrupo> lmGrupo = new ArrayList<ModeloGrupo>();
            ModeloGrupo mGrupoEndividamento = new ModeloGrupo();
            ModeloGrupo mGrupoLiquidez = new ModeloGrupo();
            ModeloGrupo mGrupoRentabilidade = new ModeloGrupo();
            ModeloGrupo mGrupoPrazosMedios = new ModeloGrupo();
            
            mGrupoEndividamento.setGrupo("endividamento");
            mGrupoEndividamento.setlmIndicador(this.gerarIndicadores(iEmpresa_ID,tipoGrupo.Endividamento));
            lmGrupo.add(mGrupoEndividamento);
            
            mGrupoLiquidez.setGrupo("liquidez");
            mGrupoLiquidez.setlmIndicador(this.gerarIndicadores(iEmpresa_ID,tipoGrupo.Liquidez));
            lmGrupo.add(mGrupoLiquidez);
            
            mGrupoRentabilidade.setGrupo("rentabilidade");
            mGrupoRentabilidade.setlmIndicador(this.gerarIndicadores(iEmpresa_ID,tipoGrupo.Rentabilidade));
            lmGrupo.add(mGrupoRentabilidade);
            
            mGrupoPrazosMedios.setGrupo("prazosmedios");
            mGrupoPrazosMedios.setlmIndicador(this.gerarIndicadores(iEmpresa_ID,tipoGrupo.PrazosMedios));
            lmGrupo.add(mGrupoPrazosMedios);
            
            return lmGrupo;
        }catch (Exception ex) {
            throw ex;
        }
    }
    
    private ArrayList<ModeloIndicador> gerarIndicadores(int iEmpresa_ID,tipoGrupo tGrupo) throws Exception{
        try{
            ArrayList<ModeloIndicador> lmIndicadores = new ArrayList<ModeloIndicador>();
                        
            if (tGrupo == tipoGrupo.Endividamento){
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
               
            }else if (tGrupo == tipoGrupo.Liquidez){
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
               
            }else if (tGrupo == tipoGrupo.Rentabilidade){
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
            throw ex;
        }
    }
    
    private ArrayList<ModeloResultado> gerarResultados(int iEmpresa_ID,String sCampo) throws Exception{
        try{
            conn.abrirConexao();
            ArrayList<ModeloResultado> lmResultados = new ArrayList<ModeloResultado>();
            
            String sSql;
            
            sSql  = " SELECT";
            sSql += "	 BVSP_INDICADORES.ANO,";
            sSql += "	 TRUNC(BVSP_INDICADORES." + sCampo + ",2) AS INDICADOR";
            sSql += " FROM BVSP_INDICADORES";
            sSql += " WHERE BVSP_INDICADORES.ID_EMPRESA = " + iEmpresa_ID;
            
            ResultSet rs = conn.Selecionar(sSql);
            while(rs.next()){
                ModeloResultado mResultado = new ModeloResultado();
                mResultado.setAno(rs.getInt("ANO"));
                mResultado.setValor(rs.getDouble("INDICADOR"));
                lmResultados.add(mResultado);
            }
            
            return lmResultados;
        }catch (Exception ex) {
            throw ex;
        }finally{
            conn.fecharConexao();
        }
    } 
}
