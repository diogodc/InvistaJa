/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Everaldo Cardoso
 */
public class ModeloIndEmpresa {
    private int iEmpresa_ID;
    private ArrayList<ModeloGrupo> lmGrupo;
    
    public ModeloIndEmpresa(){
        this.iEmpresa_ID = 0;
        this.lmGrupo = null;
    }

    public int getEmpresa_ID() {
        return iEmpresa_ID;
    }

    public void setEmpresa_ID(int iEmpresa_ID) {
        this.iEmpresa_ID = iEmpresa_ID;
    }

    public ArrayList<ModeloGrupo> getLmGrupo() {
        return lmGrupo;
    }

    public void setLmGrupo(ArrayList<ModeloGrupo> lmGrupo) {
        this.lmGrupo = lmGrupo;
    }
}
