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
public class ModeloIndicadores {
    private int iEmpresa_ID;
    private ArrayList<ModeloResultados> mrEndividamento;
    private ArrayList<ModeloResultados> mrLiquidez;
    private ArrayList<ModeloResultados> mrRentabilidade;
    private ArrayList<ModeloResultados> mrPrazosMedios;

    public ModeloIndicadores(){
        this.iEmpresa_ID = 0;
        this.mrEndividamento = new ArrayList<ModeloResultados>();
        this.mrLiquidez = new ArrayList<ModeloResultados>();
        this.mrRentabilidade = new ArrayList<ModeloResultados>();
        this.mrPrazosMedios = new ArrayList<ModeloResultados>();
    }
    
    public ModeloIndicadores(int iEmpresa_ID,ArrayList<ModeloResultados> mrEndividamento,
             ArrayList<ModeloResultados> mrLiquidez,ArrayList<ModeloResultados> mrRentabilidade,
             ArrayList<ModeloResultados> mrPrazosMedios){
        this.iEmpresa_ID = iEmpresa_ID;
        this.mrEndividamento = mrEndividamento;
        this.mrLiquidez = mrLiquidez;
        this.mrRentabilidade = mrRentabilidade;
        this.mrPrazosMedios = mrPrazosMedios;
    }
        
    public int getEmpresa_ID() {
        return iEmpresa_ID;
    }

    public void setEmpresa_ID(int iEmpresa_ID) {
        this.iEmpresa_ID = iEmpresa_ID;
    }

    public ArrayList<ModeloResultados> getEndividamento() {
        return mrEndividamento;
    }

    public void setEndividamento(ArrayList<ModeloResultados> mrEndividamento) {
        this.mrEndividamento = mrEndividamento;
    }

    public ArrayList<ModeloResultados> getLiquidez() {
        return mrLiquidez;
    }

    public void setLiquidez(ArrayList<ModeloResultados> mrLiquidez) {
        this.mrLiquidez = mrLiquidez;
    }

    public ArrayList<ModeloResultados> getRentabilidade() {
        return mrRentabilidade;
    }

    public void setRentabilidade(ArrayList<ModeloResultados> mrRentabilidade) {
        this.mrRentabilidade = mrRentabilidade;
    }

    public ArrayList<ModeloResultados> getMrPrazosMedios() {
        return mrPrazosMedios;
    }

    public void setMrPrazosMedios(ArrayList<ModeloResultados> mrPrazosMedios) {
        this.mrPrazosMedios = mrPrazosMedios;
    }
}
