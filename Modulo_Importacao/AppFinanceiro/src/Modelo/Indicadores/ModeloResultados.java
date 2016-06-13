/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Indicadores;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author E. Cardoso de Araújo
 */
@XmlRootElement
public class ModeloResultados {
    private String sNomeIndicador;
    private int iAno;
    private double dIndicador;

    public ModeloResultados(){
        sNomeIndicador = "xpto";
        iAno = 1900;
        dIndicador = 0.00;
    }
    
    public ModeloResultados(String sNomeIndicador,int iAno,double dIndicador){
        this.sNomeIndicador = sNomeIndicador;
        this.iAno = iAno;
        this.dIndicador = dIndicador;
    }
    
    public int getAno() {
        return iAno;
    }

    public void setAno(int iAno) {
        this.iAno = iAno;
    }

    public double getIndicador() {
        return dIndicador;
    }

    public void setIndicador(double dIndicador) {
        this.dIndicador = dIndicador;
    }
    
    public String getNomeIndicador() {
        return sNomeIndicador;
    }

    public void setNomeIndicador(String sNomeIndicador) {
        this.sNomeIndicador = sNomeIndicador;
    }
}
