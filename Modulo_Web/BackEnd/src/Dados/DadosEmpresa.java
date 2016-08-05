package Dados;

import java.sql.ResultSet;
import java.util.ArrayList;

import App.AppWs;
import Modelo.ModeloEmpresa;

public class DadosEmpresa {
	protected ArrayList<ModeloEmpresa> consultarEmpresas(){
		return consultar(0);
	}
	
	protected ArrayList<ModeloEmpresa> consultarEmpresas(int iEmpresa_Id){
		return consultar(iEmpresa_Id);
	}
	
	private ArrayList<ModeloEmpresa> consultar(int iEmpresa_Id){
		try{
			AppWs.conn.abrirConexao();
			
			ArrayList<ModeloEmpresa> lmEmpresa = new ArrayList<ModeloEmpresa>();
			String sSql;
			
			sSql =  " SELECT ";
			sSql += " 	BVSP_EMPRESA.ID_EMPRESA, ";
			sSql += "   BVSP_EMPRESA.RAZAO_SOCIAL, ";
			sSql += "   BVSP_EMPRESA.NOME_FANTASIA, ";
			sSql += "   BVSP_EMPRESA.CNPJ, ";
			sSql += "   BVSP_EMPRESA.ATIVIDADE, ";
			sSql += "   BVSP_EMPRESA.DRE, ";
			sSql += "   BVSP_EMPRESA.BPA, ";
			sSql += "   BVSP_EMPRESA.BPP ";
			sSql += " FROM BVSP_EMPRESA ";
			if (iEmpresa_Id != 0){sSql += " WHERE BVSP_EMPRESA.ID_EMPRESA = " + iEmpresa_Id;}
			
			ResultSet rs = AppWs.conn.Selecionar(sSql);
			
			while(rs.next()){
				ModeloEmpresa mEmpresa = new ModeloEmpresa();
				
				mEmpresa.setEmpresa_ID(rs.getInt("ID_EMPRESA"));
				mEmpresa.setNomeFantasia(rs.getString("RAZAO_SOCIAL"));
				mEmpresa.setRazaoSocial(rs.getString("NOME_FANTASIA"));
				mEmpresa.setCNPJ(rs.getString("CNPJ"));
				mEmpresa.setAtividade(rs.getString("ATIVIDADE"));
				if (rs.getString("BPA").equals("S")){mEmpresa.setBPA(true);}
				else{mEmpresa.setBPA(false);}
				if (rs.getString("BPP").equals("S")){mEmpresa.setBPP(true);}
				else{mEmpresa.setBPP(false);}
				if (rs.getString("DRE").equals("S")){mEmpresa.setDRE(true);}
				else{mEmpresa.setDRE(false);}
				
				lmEmpresa.add(mEmpresa);
			}
			
			AppWs.conn.fecharConexao();
			
			return lmEmpresa;
		}catch(Exception ex){
			AppWs.gravarLog("ControleEmpresas", "empresa","",
					ex.getMessage(),ex.getStackTrace().toString());
			return null;
		}
	}
}
