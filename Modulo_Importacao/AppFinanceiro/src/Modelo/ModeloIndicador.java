/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author E. Cardoso de Araújo
 */
@XmlRootElement
public class ModeloIndicador {
    private String sIndicador;
    private ArrayList<ModeloResultado> lmResultado;
    
    public ModeloIndicador(){
        this.sIndicador = "";
        this.lmResultado = null;
    }

    public String getIndicador() {
        return sIndicador;
    }

    public void setIndicador(String sIndicador) {
        this.sIndicador = sIndicador;
    }

    public ArrayList<ModeloResultado> getLmResultado() {
        return lmResultado;
    }

    public void setLmResultado(ArrayList<ModeloResultado> lmResultado) {
        this.lmResultado = lmResultado;
    }
    
}
