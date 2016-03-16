/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Dados.DadosImportar;
import Modelo.ModeloImportar;
import Visao.VisaoImportar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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
            
            String sLinha;
            ArrayList<ModeloImportar> lImportar = new ArrayList<ModeloImportar>();
            DadosImportar dImportar = new DadosImportar();
            BufferedReader brLeitor = new BufferedReader( new FileReader(txtCaminho.getText()));
            while ((sLinha = brLeitor.readLine()) != null){
                ModeloImportar mImportar = new ModeloImportar();
                String [] sCelula = sLinha.split(";");
                mImportar.setCodigo(sCelula[0]);
                mImportar.setDescricao(sCelula[1]);    
                lImportar.add(mImportar);
            }
            
            return dImportar.Importar(lImportar,lblProgresso);
            
        }catch(Exception ex){
                throw ex;
        }
    }
}