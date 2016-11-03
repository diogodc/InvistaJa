package br.com.invistaja.invistaja.model;

public class ArtigosModel {
    private String strTitulo;
    private String strCorpo;

    public ArtigosModel(){
        this.strTitulo = null;
        this.strCorpo = null;
    }

    public ArtigosModel(String strTitulo, String strCorpo){
        this.strTitulo = strTitulo;
        this.strCorpo = strCorpo;
    }

    public void setTitulo(String strTitulo){
        this.strTitulo = strTitulo;
    }

    public void setCorpo(String strCorpo){
        this.strCorpo = strCorpo;
    }

    public String getTitulo(){return this.strTitulo;}

    public String getCorpo(){
        return  this.strTitulo;
    }
}
