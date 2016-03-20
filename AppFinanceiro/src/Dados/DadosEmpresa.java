/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import static App.AppFinanceiro.conn;
import Modelo.ModeloEmpresa;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class DadosEmpresa {
    public ArrayList<ModeloEmpresa> carregaEmpresa() throws Exception{
        try{
            conn.abrirConexao();
            
            ArrayList<ModeloEmpresa> lmEmpresa = new ArrayList<ModeloEmpresa>(); 
            String sSql;
            
            sSql = " SELECT  ";
            sSql +="    BVSP_EMPRESA.EMPRESA_ID, " ;
            sSql +="    BVSP_EMPRESA.RAZAO_SOCIAL, " ;
            sSql +="    BVSP_EMPRESA.NOME_FANTASIA, " ;
            sSql +="    BVSP_EMPRESA.CNPJ, " ;
            sSql +=" FROM BVSP_EMPRESA " ;
            
            ResultSet rs = conn.Selecionar(sSql);
            
            while(rs.next()){
                ModeloEmpresa mEmpresa = new ModeloEmpresa();
                mEmpresa.setEmpresa_ID(rs.getInt("EMPRESA_ID"));
                mEmpresa.setCNPJ(rs.getString("RAZAO_SOCIAL"));
                mEmpresa.setNome_Fantasia(rs.getString("NOME_FANTASIA"));
                mEmpresa.setRazao_Social(rs.getString("RAZAO_SOCIAL"));
                lmEmpresa.add(mEmpresa);
            }
            
            conn.fecharConexao();
            
            return lmEmpresa;
        }catch(Exception ex){
            throw ex;
        }
    }
}
