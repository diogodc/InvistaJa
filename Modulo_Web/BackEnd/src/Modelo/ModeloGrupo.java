package Modelo;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModeloGrupo {
    private String sGrupo;
    private ArrayList<ModeloIndicador> lmIndicador;
    
    public ModeloGrupo(){
        this.sGrupo = "";
        this.lmIndicador = null;
    }

    public String getGrupo() {
        return sGrupo;
    }

    public void setGrupo(String sGrupo) {
        this.sGrupo = sGrupo;
    }

    public ArrayList<ModeloIndicador> getlmIndicador() {
        return lmIndicador;
    }

    public void setlmIndicador(ArrayList<ModeloIndicador> lmIndicador) {
        this.lmIndicador = lmIndicador;
    }
}
