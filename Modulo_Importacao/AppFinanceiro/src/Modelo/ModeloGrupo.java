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
 * @author Everaldo Cardoso
 */
@XmlRootElement
public class ModeloGrupo {
    private String sGrupo;
    private ModeloIndicador mIndicador;
    
    public ModeloGrupo(){
        this.sGrupo = "";
        this.mIndicador = null;
    }

    public String getGrupo() {
        return sGrupo;
    }

    public void setGrupo(String sGrupo) {
        this.sGrupo = sGrupo;
    }

    public ModeloIndicador getmIndicador() {
        return mIndicador;
    }

    public void setmIndicador(ModeloIndicador lmIndicador) {
        this.mIndicador = mIndicador;
    }
}
