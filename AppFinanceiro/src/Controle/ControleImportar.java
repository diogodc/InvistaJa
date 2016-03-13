/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Visao.VisaoImportar;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ControleImportar {
 
    private VisaoImportar visao;
    void ControlerImportar(VisaoImportar visao){
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

    public boolean importarArquivo(JLabel lblProgresso,JTextField txtCaminho) throws Exception{
        try{
            if (txtCaminho.getText().isEmpty()) { return false;}
            StringBuilder sbMensagem = new StringBuilder();
            String sLinha;
            BufferedReader brLeitor = new BufferedReader( new FileReader(txtCaminho.getText()));
            while ((sLinha = brLeitor.readLine()) != null){
                String [] sCelula = sLinha.split(";");
                sbMensagem.append(sCelula[0] + "  " + sCelula[1] + "  " + sCelula[2]);
                sbMensagem.append(System.getProperty("line.separator"));
                sbMensagem.append("\n");
            }
            return true;
        }catch(Exception ex){
                throw ex;
        }
    }
}