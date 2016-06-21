package Dados;

import static App.AppFinanceiro.conn;
import App.AppFinanceiro.tipoRelatorio;
import Modelo.ModeloEmpresa;
import Modelo.ModeloGrupo;
import Modelo.ModeloImpExp;
import Modelo.ModeloIndicador;
import Modelo.ModeloResultado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosImpExp {
        
    public boolean importarDados(ArrayList<ModeloImpExp> lImportar, 
            tipoRelatorio tRelatorio) throws Exception{
        try{
            if (lImportar.size()> 0){
                return this.inserirDados(
                        selecionarTipoRelatorio(tRelatorio),lImportar);
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    } 
    
    private HashMap selecionarTipoRelatorio(tipoRelatorio tRelatorio){
        try{
            String sTabela,sIndice;
            HashMap hDadosTabela = new HashMap();
            
            if (tRelatorio == tipoRelatorio.DRE){
                sTabela = "BVSP_DRE";
                sIndice = "DRE";
            }else if (tRelatorio == tipoRelatorio.BPA){
                sTabela = "BVSP_BPA";
                sIndice = "BPA";
            }else{
                sTabela = "BVSP_BPP";
                sIndice = "BPP";
            }
            
            hDadosTabela.put("sTabela", sTabela);
            hDadosTabela.put("sIndice", sIndice);
            
            return hDadosTabela;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private boolean inserirDados(HashMap hDadosTabela,  
            ArrayList<ModeloImpExp> lImportar) throws Exception{
        try{
            String sSql;
            int iEmpresa_ID = 0;
            String sTabela = hDadosTabela.get("sTabela").toString();
            String sIndice = hDadosTabela.get("sIndice").toString();
            
            if (lImportar.size() == 0){return false;}
            
            for (int i = 0; i < lImportar.size(); i++){
                conn.abrirConexao();

                ModeloImpExp mImportar = lImportar.get(i); 

                sSql  = "";
                sSql += "INSERT INTO " + sTabela;
                sSql += "        (ID_EMPRESA,";    
                sSql += "        " + sIndice + "_PERIODO1,";
                sSql += "        " + sIndice + "_PERIODO2,";
                sSql += "        " + sIndice + "_PERIODO3,";
                sSql += "        " + sIndice + "_VALOR1,";
                sSql += "        " + sIndice + "_VALOR2,";
                sSql += "        " + sIndice + "_VALOR3,";
                sSql += "        " + sIndice + "_CONTA_CONTABIL,";
                sSql += "        " + sIndice + "_DESCRICAO";
                sSql += "        )";
                sSql += "      VALUES";
                sSql += "        (" + mImportar.getEmpresa_ID()+ ",";
                sSql += "         '" + mImportar.getPeriodo_1()+ "',";
                sSql += "         '" + mImportar.getPeriodo_2()+ "',";
                sSql += "         '" + mImportar.getPeriodo_3()+ "',";
                sSql += "          " + mImportar.getValor_1()   + ",";
                sSql += "          " + mImportar.getValor_2()   + ",";
                sSql += "          " + mImportar.getValor_3()   + ",";
                sSql += "         '" + mImportar.getConta()    + "',";
                sSql += "         '" + mImportar.getDescricao()+ "'";
                sSql += "        )";
                
                iEmpresa_ID = mImportar.getEmpresa_ID();
                
                if (!sSql.trim().isEmpty()){
                    conn.Inserir(sSql);                        
                }  
                conn.fecharConexao();
            }
             this.atualizarIndiceImportado(sIndice,iEmpresa_ID);
            return true;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private void atualizarIndiceImportado(String sIndice,
            int iEmpresa_ID) throws Exception{
        try{
            conn.abrirConexao();
            String sSql;
            
            sSql  = "UPDATE BVSP_EMPRESA SET ";
            sSql += "   BVSP_EMPRESA." + sIndice + " = 'S' ";
            sSql += "WHERE BVSP_EMPRESA.ID_EMPRESA = " + iEmpresa_ID;
            
            conn.Alterar(sSql);
            
            conn.fecharConexao();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean calcularIndicadores(String sAno1, String sAno2, String sAno3) throws Exception{
        try{
            conn.abrirConexao();
            
            ArrayList<ModeloEmpresa> lmEmpresas = new DadosEmpresa().carregarEmpresa();
            
            for (int i = 0; i < lmEmpresas.size();i++){
                ModeloEmpresa mEmpresa = lmEmpresas.get(i);
                conn.Procedure("{call BVSP_SP_INDICADORES("+ mEmpresa.getEmpresa_ID() + "," + sAno1 + "," + sAno2 + ","+ sAno3 +")}");
            }
             
            return true;
        }catch (Exception ex) {
            throw ex;
        }finally{
            conn.fecharConexao();
        }
    }
    
    public ArrayList<ModeloIndicador> gerarIndicadores() throws Exception{
        try{
            ArrayList<ModeloEmpresa> lmEmpresas = new DadosEmpresa().carregarEmpresa();
            ArrayList<ModeloIndicador> lmIndicadores = new ArrayList<ModeloIndicador>();
            
            for (int i = 0; i < lmEmpresas.size();i++){
                ModeloEmpresa mEmpresa = lmEmpresas.get(i);
                ModeloIndicador mIndicadores = new ModeloIndicador();
                
                mIndicadores.setEmpresa_ID(mEmpresa.getEmpresa_ID());
                mIndicadores.setEstrutura(this.gerarIndicadoresEstrutura(mEmpresa.getEmpresa_ID()));
                mIndicadores.setLiquidez(this.gerarIndicadoresLiquidez(mEmpresa.getEmpresa_ID()));
                mIndicadores.setRentabilidade(this.gerarIndicadoresRentabilidade(mEmpresa.getEmpresa_ID()));
                mIndicadores.setAtividades(this.gerarIndicadoresAtividade(mEmpresa.getEmpresa_ID()));
                
                lmIndicadores.add(mIndicadores);
            }
                      
            return lmIndicadores;
        }catch (Exception ex) {
            throw ex;
        }
    }
    
    
    private void gerarGrupo(int iEmpresa_ID){
        try{
            ModeloGrupo mGrupo = new ModeloGrupo();
            mGrupo.setGrupo("endividamento");
            mGrupo.setmIndicador(gerarIndicador(iEmpresa_ID,""));
        }catch (Exception ex) {
            throw ex;
        }
    }
    
    
    private ModeloIndicador gerarIndicador(int iEmpresa_ID,String sIndice,String sIndicador) throws Exception{
        try{
            ModeloIndicador mIndicador = new ModeloIndicador();
            mIndicador.setIndicador(sIndicador);
            mIndicador.setLmResultado(this.gerarResultados(iEmpresa_ID,sIndice));
            return mIndicador;
        }catch (Exception ex) {
            throw ex;
        }
    }
    
    
    private ArrayList<ModeloResultado> gerarResultados(int iEmpresa_ID,String sIndice) throws Exception{
         try{
            ArrayList<ModeloResultado> lmResultado = new ArrayList<ModeloResultado>();
            
            String sSql;
            
            sSql =  "SELECT ";
            sSql += "	BVSP_INDICADORES.ANO, ";
            sSql += "	BVSP_INDICADORES." + sIndice + " AS INDICADOR ";
            sSql += "FROM BVSP_INDICADORES ";
            sSql += "WHERE BVSP_INDICADORES.ID_EMPRESA =" + iEmpresa_ID;  
            
            ResultSet rs = conn.Selecionar(sSql);
            
            while(rs.next()){
                ModeloResultado mResultado = new ModeloResultado();
                mResultado.setAno(rs.getInt("ANO"));
                mResultado.setValor(rs.getInt("INDICADOR"));
                lmResultado.add(mResultado);    
            }
            
            return lmResultado;
        }catch (Exception ex) {
            throw ex;
        }
    }
}
