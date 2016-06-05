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
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleImportar {
 
    private final VisaoImportar visao;

    public ControleImportar(VisaoImportar visao){
        this.visao = visao;
    }
     
    public static void abrirVisao(JDesktopPane pnl) throws Exception{
        try{
            VisaoImportar visaoImportar = new VisaoImportar(); 
            pnl.add(visaoImportar);
            visaoImportar.setVisible(true);
            visaoImportar.setMaximum(true);
        }catch(Exception ex){
            throw ex;
        }
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
                JComboBox cboTipoRelatorio,JTextField txtCodEmpresa) throws Exception{
        try{
            if (!validarArquivo(txtCaminho)){ return false;}  
            if (txtCodEmpresa.getText().trim().isEmpty()){return false;}
            
            DadosImportar dImportar = new DadosImportar();
            BufferedReader brLeitor = new BufferedReader( new FileReader(txtCaminho.getText()));
            
            switch (cboTipoRelatorio.getSelectedIndex()) {
                case 0:
                    return dImportar.importarDados(manipularArquivo(brLeitor,
                            txtCodEmpresa.getText().trim()),tipoRelatorio.DRE);
                case 1:
                    return dImportar.importarDados(manipularArquivo(brLeitor,
                            txtCodEmpresa.getText().trim()),tipoRelatorio.BPA);
                default:
                    return dImportar.importarDados(manipularArquivo(brLeitor,
                            txtCodEmpresa.getText().trim()),tipoRelatorio.BPP);
            }
        }catch(Exception ex){
            throw ex;                                       
        }
    }
    
    /*
    ----Desuso devido a mudança de filtro-----
    private int getEmpresaSelecionada(JComboBox cboEmpresa) throws Exception{
        try{
            String sEmpresa = cboEmpresa.getSelectedItem().toString();
            String sStringAtual = cboEmpresa.getSelectedItem().toString();
            String sEmpresa_ID;
            int iContador = 0;
            
            if (sEmpresa.equals("Empresa")){return 0;}
            
            while(!sStringAtual.equals("-")){
                sStringAtual = sEmpresa.substring(iContador,iContador+1);
                iContador ++;
                if (sStringAtual.isEmpty()){
                    return 0;
                }
            }
            
            sEmpresa_ID = sEmpresa.substring(0, iContador-1);
            
            return Integer.valueOf(sEmpresa_ID);
        }catch(Exception ex){
            throw ex;
        }
    }*/
    
    private boolean validarArquivo(JTextField txtCaminho){
        try{
            if (txtCaminho.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o caminho do .CSV", "Atenção!",0);
                return false;
            }else if (!txtCaminho.getText().trim().toUpperCase().contains(".CSV")){
                JOptionPane.showMessageDialog(null, "Informe um arquivo do tipo .CSV", "Atenção!",0);
                return false;
            }
            return true;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private ArrayList<ModeloImportar> manipularArquivo(BufferedReader brLeitor,String sEmpresa_ID) throws Exception{
        try{
            int iEmpresa_ID = Integer.parseInt(sEmpresa_ID);
            String sLinha;
            ArrayList<ModeloImportar> lMImportar = new ArrayList<ModeloImportar>();
            ArrayList<String> lPeriodo = new ArrayList<String>();
            int iCont = 0;
            
            while ((sLinha = brLeitor.readLine()) != null){
                iCont++;
                if (iCont == 1){
                    String [] sVetCelula = sLinha.split(";");
                    lPeriodo.add(sVetCelula[2]);
                    lPeriodo.add(sVetCelula[3]);
                    lPeriodo.add(sVetCelula[4]);
                }else{
                    ModeloImportar mImportar = new ModeloImportar();
                    String [] sVetCelula = sLinha.split(";");
                    int iQuantReg = sVetCelula.length;
                    mImportar.setEmpresa_ID(iEmpresa_ID);
 
                    if (iQuantReg > 0){
                        mImportar.setConta(sVetCelula[0].trim());
                    }
                    if (iQuantReg>1){
                        mImportar.setDescricao(sVetCelula[1].trim());
                    }
                    if (iQuantReg>2){
                        mImportar.setPeriodo_1(lPeriodo.get(0));
                        mImportar.setValor_1(sVetCelula[2].trim());
                    }
                    if (iQuantReg>3){
                        mImportar.setPeriodo_2(lPeriodo.get(1));
                        mImportar.setValor_2(sVetCelula[3].trim());
                    }
                    if (iQuantReg>4){
                        mImportar.setPeriodo_3(lPeriodo.get(2));
                        mImportar.setValor_3(sVetCelula[4].trim());
                    }
                    lMImportar.add(mImportar); 
                } 
            }
            
            return lMImportar;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void carregarEmpresas(JComboBox cboEmpresa) throws Exception{
        try{
            DadosEmpresa dEmpresa = new DadosEmpresa();
            ArrayList<ModeloEmpresa> lmEmpresa = dEmpresa.carregarEmpresa();
            
            if (lmEmpresa.isEmpty()){ return;}
            
            for (int i = 0; i<lmEmpresa.size();i++){
                ModeloEmpresa mEmpresa = lmEmpresa.get(i);
                cboEmpresa.addItem(mEmpresa.getEmpresa_ID() + "-" + mEmpresa.getRazao_Social());
            }
        }catch(Exception ex){
            throw ex;
        }
    }
}