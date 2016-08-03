package Modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModeloEmpresa {
	private int iEmpresa_ID;
	private String sRazaoSocial;
	private String sNomeFantasia;
	private String sCNPJ;
	private String sAtividade;
	private boolean bBPP;
	private boolean bBPA;
	private boolean bDRE;
	
	public ModeloEmpresa(){
		this.iEmpresa_ID = 0;
		this.sRazaoSocial = "";
		this.sNomeFantasia = "";
		this.sCNPJ = "";
		this.sAtividade = "";
		this.bBPP = false;
		this.bBPA = false;
		this.bDRE = false;
	}
	public ModeloEmpresa(int iEmpresa_ID,String sRazaoSocial, String sNomeFantasia,
			String sCNPJ,String sAtividade, boolean bBPP, boolean bBPA, boolean bDRE){
		this.iEmpresa_ID = iEmpresa_ID;
		this.sRazaoSocial = sRazaoSocial;
		this.sNomeFantasia = sNomeFantasia;
		this.sCNPJ = sCNPJ;
		this.sAtividade = sAtividade;
		this.bBPP = bBPP;
		this.bBPA = bBPA;
		this.bDRE = bDRE;
	}
	public int getEmpresa_ID() {
		return iEmpresa_ID;
	}
	public void setEmpresa_ID(int iEmpresa_ID) {
		this.iEmpresa_ID = iEmpresa_ID;
	}
	public String getRazaoSocial() {
		return sRazaoSocial.replace("'", "''");
	}
	public void setRazaoSocial(String sRazaoSocial) {
		this.sRazaoSocial = sRazaoSocial;
	}
	public String getNomeFantasia() {
		return sNomeFantasia.replace("'", "''");
	}
	public void setNomeFantasia(String sNomeFantasia) {
		this.sNomeFantasia = sNomeFantasia;
	}
	public String getCNPJ() {
		return sCNPJ.replace("'", "''");
	}
	public void setCNPJ(String sCNPJ) {
		this.sCNPJ = sCNPJ;
	}
	public String getAtividade() {
		return sAtividade.replace("'", "''");
	}
	public void setAtividade(String sAtividade) {
		this.sAtividade = sAtividade;
	}
	public boolean getBPP() {
		return bBPP;
	}
	public void setBPP(boolean bBPP) {
		this.bBPP = bBPP;
	}
	public boolean getBPA() {
		return bBPA;
	}
	public void setBPA(boolean bBPA) {
		this.bBPA = bBPA;
	}
	public boolean getDRE() {
		return bDRE;
	}
	public void setDRE(boolean bDRE) {
		this.bDRE = bDRE;
	}
}
