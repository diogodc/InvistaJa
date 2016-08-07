package Modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModeloResultado {
    private int iAno;
    private double dValor;

    public ModeloResultado(){
        this.iAno = 0;
        this.dValor = 0.0;
    }
    
    public int getAno() {
        return iAno;
    }

    public void setAno(int iAno) {
        this.iAno = iAno;
    }

    public double getValor() {
        return dValor;
    }

    public void setValor(double dValor) {
        this.dValor = dValor;
    }
    
    
}
