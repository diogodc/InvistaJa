/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Tree.Branch.Leaf.String.SLeaf;
import java.awt.List;
import java.util.Vector;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author E. Cardoso de Araújo
 */
@XmlRootElement
public class ModeloEmpresa extends SLeaf {

    private int iEmpresa_ID;
    private String sRazao_Social;
    private String sNome_Fantasia;
    private String sCNPJ;
    private String sAtividade;

    public ModeloEmpresa() {
        this.iEmpresa_ID = 0;
        this.sRazao_Social = "";
        this.sNome_Fantasia = "";
        this.sCNPJ = "";
        this.sAtividade = "";
    }

    public ModeloEmpresa(int iEmpresa_ID, String sRazao_Social,
            String sNome_Fantasia, String sCNPJ,
            String sAtividade) {
        this.iEmpresa_ID = iEmpresa_ID;
        this.sRazao_Social = sRazao_Social;
        this.sNome_Fantasia = sNome_Fantasia;
        this.sCNPJ = sCNPJ;
        this.sAtividade = sAtividade;
    }

    public void setEmpresa_ID(int iEmpresa_ID) {
        this.iEmpresa_ID = iEmpresa_ID;
    }

    public void setRazao_Social(String sRazao_Social) {
        this.sRazao_Social = sRazao_Social;
    }

    public void setNome_Fantasia(String sNome_Fantasia) {
        this.sNome_Fantasia = sNome_Fantasia;
    }

    public void setCNPJ(String sCNPJ) {
        this.sCNPJ = sCNPJ;
    }

    public void setAtividade(String sAtividade) {
        this.sAtividade = sAtividade;
    }

    public int getEmpresa_ID() {
        return this.iEmpresa_ID;
    }

    public String getRazao_Social() {
        return this.sRazao_Social;
    }

    public String getNome_Fantasia() {
        return this.sNome_Fantasia;
    }

    public String getCNPJ() {
        return this.sCNPJ.replace(".", "").replace("-", "").replace("/", "");
    }

    public String getAtividade() {
        return this.sAtividade;
    }

    @Override
    public Object getKey() {
        /* USADO PARA ORDENAÇÃO NA ARVORE */
        return this.sRazao_Social;
    }

    @Override
    public void setKey(Object _Key) {
        this.sRazao_Social = (String) _Key;
        System.out.println(this.sRazao_Social);
    }

    @Override
    public ModeloEmpresa Get(Vector model) {
        /* add Rafael */
        try {
            ModeloEmpresa mEmpresa = new ModeloEmpresa();

            if ("".equals((String) model.elementAt(0))) {
                return null;
            }

            for (int i = 0; i <= model.size(); i++) {
                if (mEmpresa.iEmpresa_ID <= 0) {
                    mEmpresa.iEmpresa_ID = Integer.parseInt(String.valueOf(model.elementAt(i)));
                } else if ("".equals(mEmpresa.sCNPJ)) {
                    mEmpresa.sCNPJ = (String) model.elementAt(i);
                } else if ("".equals(mEmpresa.sRazao_Social)) {
                    mEmpresa.sRazao_Social = (String) model.elementAt(i);
                } else if ("".equals(mEmpresa.sNome_Fantasia)) {
                    mEmpresa.sNome_Fantasia = (String) model.elementAt(i);
                } else if ("".equals(mEmpresa.sAtividade)) {
                    mEmpresa.sAtividade = (String) model.elementAt(i);
                }
            }
            return mEmpresa;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Vector parseVector() {
        Vector model = new Vector();
        model.add(this.iEmpresa_ID);
        model.add(this.sCNPJ);
        model.add(this.sRazao_Social);
        model.add(this.sNome_Fantasia);
        model.add(this.sAtividade);
        return model;
    }

    @Override
    public ModeloEmpresa Get(List model) {
        /* add Rafael */
        try {
            ModeloEmpresa modelEmpresa = new ModeloEmpresa();
            for (int i = 0; i <= model.getItemCount(); i++) {
                if (modelEmpresa.iEmpresa_ID <= 0) {
                    modelEmpresa.iEmpresa_ID = Integer.parseInt(model.getItem(i));
                } else if ("".equals(modelEmpresa.sCNPJ)) {
                    modelEmpresa.sCNPJ = (String) model.getItem(i);
                } else if ("".equals(modelEmpresa.sRazao_Social)) {
                    modelEmpresa.sRazao_Social = (String) model.getItem(i);
                } else if ("".equals(modelEmpresa.sNome_Fantasia)) {
                    modelEmpresa.sNome_Fantasia = (String) model.getItem(i);
                } else if ("".equals(modelEmpresa.sAtividade)) {
                    modelEmpresa.sAtividade = (String) model.getItem(i);
                }
            }

            return modelEmpresa;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
