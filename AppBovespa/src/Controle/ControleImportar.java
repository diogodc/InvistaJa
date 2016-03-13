/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Visao.VisaoImportar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class ControleImportar {
 
    private VisaoImportar visao;
    void ControlerImportar(VisaoImportar visao){
        this.visao = visao;
    }
    
    public String AbrirVisaoArquivo(){
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

    public boolean ImportarArquivo(JProgressBar pgb, JLabel lbl,JTextField txt,JLabel imp) throws Exception{
        try{
            if (txt.getText().isEmpty()) { return false;}
            StringBuilder sbMensagem = new StringBuilder();
            String sLinha;
            BufferedReader brLeitor = new BufferedReader( new FileReader(txt.getText()));
            while ((sLinha = brLeitor.readLine()) != null){
                String [] sCelula = sLinha.split(";");
                sbMensagem.append(sCelula[0] + "  " + sCelula[1] + "  " + sCelula[2]);
                sbMensagem.append(System.getProperty("line.separator"));
                sbMensagem.append("\n");
            }
            imp.setText(sbMensagem.toString());
            return true;
        }catch(Exception ex){
                throw ex;
        }
    }
}