/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Dados.DadosEmpresa;
import Modelo.ModeloEmpresa;
import Visao.VisaoEmpresa;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class ControleEmpresa {
    
    private final VisaoEmpresa visao;

    public ControleEmpresa(VisaoEmpresa visao){
        this.visao = visao;
    }
    
    public static void abrirVisao(JDesktopPane pnl) throws Exception{
        try{
            VisaoEmpresa visaoEmpresa = new VisaoEmpresa(); 
            pnl.add(visaoEmpresa);
            visaoEmpresa.setVisible(true);
            visaoEmpresa.setMaximum(true);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void limparVisao(JTextField txtCodEmpresa,JTextField txtCNPJ,
            JTextField txtAtividade,JTextField txtRazaoSocial,JTextField txtNomeFantasia){
        try{
            txtCodEmpresa.setText("");
            txtCNPJ.setText("");
            txtAtividade.setText("");
            txtRazaoSocial.setText("");
            txtNomeFantasia.setText("");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public String salvar(JTextField txtCodEmpresa,JFormattedTextField txtCNPJ,
            JTextField txtAtividade,JTextField txtRazaoSocial,
            JTextField txtNomeFantasia) throws Exception{
        try{
            if (!this.validarCampos(txtCNPJ,txtAtividade,txtRazaoSocial,
                    txtNomeFantasia)){return "";}
            
            DadosEmpresa dEmpresa = new DadosEmpresa();
            ModeloEmpresa mEmpresa = new ModeloEmpresa();
            
            if (!txtCodEmpresa.getText().trim().isEmpty()){
                mEmpresa.setEmpresa_ID(Integer.parseInt(txtCodEmpresa.getText().trim()));
            }else{
                mEmpresa.setEmpresa_ID(0);
            }
            
            mEmpresa.setCNPJ(txtCNPJ.getText().trim());
            mEmpresa.setNome_Fantasia(txtNomeFantasia.getText().trim());
            mEmpresa.setRazao_Social(txtRazaoSocial.getText().trim());
            mEmpresa.setAtividade(txtAtividade.getText().trim());
            
            return dEmpresa.salvarEmpresa(mEmpresa);
               
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private boolean validarCampos(JFormattedTextField txtCNPJ,
            JTextField txtAtividade,JTextField txtRazaoSocial,JTextField txtNomeFantasia){
        try{
            if(txtCNPJ.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe o CNPJ da empresa!", visao.getTitle(),1);
                return false;
            }else if(txtAtividade.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a atividade da empresa!", visao.getTitle(),1);
                return false;
            }else if(txtRazaoSocial.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a razão social da empresa!", visao.getTitle(),1);
                return false;
            }else if(txtNomeFantasia.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a nome fantasia da empresa!", visao.getTitle(),1);
                return false;
            }
            return true;    
        }catch(Exception ex){
            throw ex;
        }
    }
}
