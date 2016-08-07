package Modelo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
