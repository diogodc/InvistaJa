/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import static App.AppFinanceiro.conn;
import Dados.DadosAutenticacao;
import static Dados.DadosConexao.sIpServidor;
import Dados.DadosManipulacao;
import Modelo.ModeloUsuario;
import Visao.VisaoAutenticacao;
import Visao.VisaoInicio;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Everaldo Cardoso
 */
public class ControleAutenticacao {
    private VisaoAutenticacao vAutenticacao;
    private DadosAutenticacao dAutenticacao;
    
    public ControleAutenticacao(VisaoAutenticacao vAutenticacao){
        this.vAutenticacao = vAutenticacao;
        this.dAutenticacao = new DadosAutenticacao();
    }
    
    public void autenticar() throws Exception{
        try{
            if(this.validaCampos()){
                this.setIpServidor();
                ModeloUsuario mUsuario = this.dAutenticacao.autenticar(this.getModelo());
                if (!mUsuario.getUsuario_ID().isEmpty()){
                    this.abrirView(mUsuario); 
                }else{
                    JOptionPane.showMessageDialog(null, "Usuário ou senha invalidos!", "Atenção",0);
                }
            }
        }catch(Exception ex){
             throw ex;
        }
    }
    
    private void setIpServidor(){
        try{
         if (this.vAutenticacao.cboServidor.getSelectedIndex() == 0){
            sIpServidor = "localhost";
        }else{
            sIpServidor = "187.85.160.51";
        }
         conn = new DadosManipulacao();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private ModeloUsuario getModelo(){
        try{
            ModeloUsuario mUsuario = new ModeloUsuario();
            mUsuario.setSenha(this.vAutenticacao.txtSenha.getText().trim());
            mUsuario.setUsuario(this.vAutenticacao.txtUsuario.getText().trim());
            return mUsuario;
        }catch(Exception ex){
             throw ex;
        }
    }
    
    private void abrirView(ModeloUsuario mUsuario){
        try{
            String sRodape = "Seja bem vindo: " + mUsuario.getUsuario_Nome()
                    + " :: Usuário: " + mUsuario.getUsuario_ID() + "-" + mUsuario.getUsuario()
                    + " :: Servidor: " + sIpServidor;
            VisaoInicio vInicio = new VisaoInicio();
            vInicio.txtDados.setText(sRodape);
            vInicio.setVisible(true);
            vInicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.vAutenticacao.dispose();
        }catch(Exception ex){
             throw ex;
        }
    }
    
    private boolean validaCampos(){
        try{
            if (this.vAutenticacao.txtUsuario.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe o usuário!", "Atenção!",1);
                return false;
            }else if (this.vAutenticacao.txtSenha.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Informe a senha!",  "Atenção!",1);
                return false;
            }
            return true;
        }catch(Exception ex){
             throw ex;
        }
    }
}
