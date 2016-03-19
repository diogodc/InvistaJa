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
public class ModeloImportar {
   private int iEmpresa_ID;
   private String sConta;
   private String sDescricao;
   private String sPeriodo_1;
   private String sPeriodo_2;
   private String sPeriodo_3;
   
   public ModeloImportar(){
       iEmpresa_ID = 0;
       sConta = "";
       sDescricao = "";
       sPeriodo_1 = "";
       sPeriodo_2 = "";
       sPeriodo_3 = "";
   }
   
    public ModeloImportar(int iEmpresa_ID,String sConta,String sDescricao,
            String sPeriodo_1,String sPeriodo_2,String sPeriodo_3){
       this.iEmpresa_ID = iEmpresa_ID;
       this.sConta = sConta;
       this.sDescricao = sDescricao;
       this.sPeriodo_1 = sPeriodo_1;
       this.sPeriodo_2 = sPeriodo_2;
       this.sPeriodo_3 = sPeriodo_3;
   }
    
    public void setEmpresa_ID(int iEmpresa_ID){
        this.iEmpresa_ID = iEmpresa_ID;
    }
    public void setConta(String sConta){
        this.sConta = sConta;
    }
    public void setDescricao(String sDescricao){
        this.sDescricao = sDescricao;
    }
    public void setPeriodo_1(String sPeriodo_1){
        this.sPeriodo_1 = sPeriodo_1;
    }
    public void setPeriodo_2(String sPeriodo_2){
        this.sPeriodo_2 = sPeriodo_2;
    }
    public void setPeriodo_3(String sPeriodo_3){
        this.sPeriodo_3 = sPeriodo_3;
    }
        
    public int getEmpresa_ID(){
        return this.iEmpresa_ID;
    }
    public String getConta(){
        return this.sConta;
    }
    public String getDescricao(){
        return this.sDescricao;
    }
    public String getPeriodo_1(){
        return this.sPeriodo_1;
    }
    public String getPeriodo_2(){
        return this.sPeriodo_2;
    }
    public String getPeriodo_3(){
        return this.sPeriodo_3;
    }
}
