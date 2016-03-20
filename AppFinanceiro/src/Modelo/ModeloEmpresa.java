/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class ModeloEmpresa {
    private int iEmpresa_ID;
    private String sRazao_Social;
    private String sNome_Fantasia;
    private String sCNPJ;
    
    public ModeloEmpresa(){
        this.iEmpresa_ID = 0;
        this.sRazao_Social = "";
        this.sNome_Fantasia = "";
        this.sCNPJ = "";
    }
    
    public ModeloEmpresa(int iEmpresa_ID, String sRazao_Social,
                        String sNome_Fantasia, String sCNPJ){
        this.iEmpresa_ID = iEmpresa_ID;
        this.sRazao_Social = sRazao_Social;
        this.sNome_Fantasia = sNome_Fantasia;
        this.sCNPJ = sCNPJ;
    }
    
    public void setEmpresa_ID(int iEmpresa_ID){
        this.iEmpresa_ID = iEmpresa_ID;
    }
    public void setRazao_Social(String sRazao_Social){
        this.sRazao_Social = sRazao_Social;
    }
    public void setNome_Fantasia(String sNome_Fantasia){
        this.sNome_Fantasia = sNome_Fantasia;
    }
    public void setCNPJ(String sCNPJ){
        this.sCNPJ = sCNPJ;
    }
    
    public int getEmpresa_ID(){
        return this.iEmpresa_ID;
    }
    public String getRazao_Social(){
        return this.sRazao_Social;
    }
    public String getNome_Fantasia(){
        return this.sNome_Fantasia;
    }
    public String getCNPJ(){
        return this.sCNPJ;
    }  
}
