/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import App.AppFinanceiro.tipoRelatorio;
import Dados.DadosEmpresa;
import Dados.DadosImportar;
import Modelo.ModeloEmpresa;
import Modelo.ModeloImportar;
import Visao.VisaoImportar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
            if (!validarArquivo(txtCaminho)){ return false;}  
            
            DadosImportar dImportar = new DadosImportar();
            BufferedReader brLeitor = new BufferedReader( new FileReader(txtCaminho.getText()));
            
            switch (cboTipoRelatorio.getSelectedIndex()) {
                case 0:
                    return dImportar.importarDados(manipularArquivo(brLeitor),tipoRelatorio.DRE);
                case 1:
                    return dImportar.importarDados(manipularArquivo(brLeitor),tipoRelatorio.BPA);
                default:
                    return dImportar.importarDados(manipularArquivo(brLeitor),tipoRelatorio.BPP);
            }
        }catch(Exception ex){
            throw ex;                                       
        }
    }
    
    private boolean validarArquivo(JTextField txtCaminho){
        try{
            if (txtCaminho.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o caminho do CSV", "Atenção!",0);
                return false;
            }else if (!txtCaminho.getText().trim().contains(".CSV")){
                JOptionPane.showMessageDialog(null, "Informe um arquivo do tipo .CSV", "Atenção!",0);
                return false;
            }
            return true;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private ArrayList<ModeloImportar> manipularArquivo(BufferedReader brLeitor) throws Exception{
        try{
            String sLinha;
            ArrayList<ModeloImportar> lMImportar = new ArrayList<ModeloImportar>();
            
            while ((sLinha = brLeitor.readLine()) != null){
                ModeloImportar mImportar = new ModeloImportar();
                String [] sVetCelula = sLinha.split(";");
                mImportar.setConta(sVetCelula[0]);
                mImportar.setDescricao(sVetCelula[1]);
                mImportar.setPeriodo_1(sVetCelula[2]);
                mImportar.setPeriodo_2(sVetCelula[3]);
                mImportar.setPeriodo_3(sVetCelula[4]);
                lMImportar.add(mImportar);
            }
            
            return lMImportar;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void carregarEmpresas(JComboBox cboEmpresa) throws Exception{
        try{
            DadosEmpresa dEmpresa = new DadosEmpresa();
            ArrayList<ModeloEmpresa> lmEmpresa = dEmpresa.carregaEmpresa();
            
            if (lmEmpresa.isEmpty()){ return;}
            
            cboEmpresa.addItem(lmEmpresa);
        }catch(Exception ex){
            throw ex;
        }
    }
}