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
    private String sCodigo;
    private String sDescricao;
    
    public ModeloImportar(String sCodigo, String sDescricao){
        this.sCodigo = sCodigo;
        this.sDescricao = sDescricao;
    }
    public ModeloImportar(){
        this.sCodigo = "";
        this.sDescricao = "";
    }
    
    public String getCodigo(){
        return this.sCodigo;
    }
    public void setCodigo(String sCodigo){
        this.sCodigo = sCodigo;
    }
    
    public String getDescricao(){
        return this.sDescricao;
    }
    public void setDescricao(String sDescricao){
        this.sDescricao = sDescricao;
    }
}
