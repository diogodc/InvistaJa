package Modelo;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

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
