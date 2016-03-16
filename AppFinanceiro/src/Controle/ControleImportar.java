/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Dados.DadosImportar;
import Modelo.ModeloImportarBPA;
import Modelo.ModeloImportarBPP;
import Modelo.ModeloImportarDRE;
import Visao.VisaoImportar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class ControleImportar {
 
    private final VisaoImportar visao;

    public ControleImportar(VisaoImportar visao){
        this.visao = visao;
    }
    
    
    public String abrirVisaoArquivo(){
        try{
            JFileChooser fileChooser = new JFileChooser();  
            fileChooser.setDialogTitle("Informe o caminho do arquivo"); 
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (fileChooser.showOpenDialog(visao) == JFileChooser.APPROVE_OPTION){  
                return fileChooser.getSelectedFile().getPath();
            }
            return "";
        }catch(Exception ex){
            throw ex;
        } 
    }

    public boolean lerArquivo(JTextField txtCaminho,
            JComboBox cboTipoRelatorio) throws Exception{
        try{
            if (txtCaminho.getText().isEmpty()) { return false;} 
            
            DadosImportar dImportar = new DadosImportar();
            BufferedReader brLeitor = new BufferedReader( new FileReader(txtCaminho.getText()));
            
            switch (cboTipoRelatorio.getSelectedIndex()) {
                case 0:
                    return dImportar.importarDRE(lerArquivoDRE(brLeitor));
                case 1:
                    return  dImportar.importarBPA(lerArquivoBPA(brLeitor));
                default:
                    return dImportar.importarBPP(lerArquivoBPP(brLeitor));
            }
        }catch(Exception ex){
            throw ex;                                       
        }
    }
    
    private ArrayList<ModeloImportarDRE> lerArquivoDRE(BufferedReader brLeitor) throws Exception{
        try{
            String sLinha;
            ArrayList<ModeloImportarDRE> lMIDRE = new ArrayList<ModeloImportarDRE>();
            
            while ((sLinha = brLeitor.readLine()) != null){
                ModeloImportarDRE mImportarDRE = new ModeloImportarDRE();
                String [] sVetCelula = sLinha.split(";");
                mImportarDRE.setConta(sVetCelula[0]);
                mImportarDRE.setDescricao(sVetCelula[1]);
                mImportarDRE.setPeriodo_1(sVetCelula[2]);
                mImportarDRE.setPeriodo_2(sVetCelula[3]);
                mImportarDRE.setPeriodo_3(sVetCelula[4]);
                lMIDRE.add(mImportarDRE);
            }
            
            return lMIDRE;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private ArrayList<ModeloImportarBPP> lerArquivoBPP(BufferedReader brLeitor) throws Exception{
        try{
            String sLinha;
            ArrayList<ModeloImportarBPP> lMIBPP = new ArrayList<ModeloImportarBPP>();
            
            while ((sLinha = brLeitor.readLine()) != null){
                ModeloImportarBPP mImportarBPP = new ModeloImportarBPP();
                String [] sVetCelula = sLinha.split(";");
                mImportarBPP.setConta(sVetCelula[0]);
                mImportarBPP.setDescricao(sVetCelula[1]);
                mImportarBPP.setPeriodo_1(sVetCelula[2]);
                mImportarBPP.setPeriodo_2(sVetCelula[3]);
                mImportarBPP.setPeriodo_3(sVetCelula[4]);
                lMIBPP.add(mImportarBPP);
            }
            
            return lMIBPP;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private ArrayList<ModeloImportarBPA> lerArquivoBPA(BufferedReader brLeitor) throws Exception{
        try{
            String sLinha;
            ArrayList<ModeloImportarBPA> lMIBPA = new ArrayList<ModeloImportarBPA>();
            
            while ((sLinha = brLeitor.readLine()) != null){
                ModeloImportarBPA mImportarBPA = new ModeloImportarBPA();
                String [] sVetCelula = sLinha.split(";");
                mImportarBPA.setConta(sVetCelula[0]);
                mImportarBPA.setDescricao(sVetCelula[1]);
                mImportarBPA.setPeriodo_1(sVetCelula[2]);
                mImportarBPA.setPeriodo_2(sVetCelula[3]);
                mImportarBPA.setPeriodo_3(sVetCelula[4]);
                lMIBPA.add(mImportarBPA);
            }
            
            return lMIBPA;
        }catch(Exception ex){
            throw ex;
        }
    }
}