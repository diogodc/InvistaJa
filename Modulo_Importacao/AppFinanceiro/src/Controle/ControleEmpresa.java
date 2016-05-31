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
            
            return dEmpresa.salvar(mEmpresa);
               
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private boolean validarCampos(JFormattedTextField txtCNPJ,
            JTextField txtAtividade,JTextField txtRazaoSocial,JTextField txtNomeFantasia){
        try{
            if(txtCNPJ.getText().replace(".", "").replace("-", "").replace("/", "").trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe o CNPJ da empresa!", "Atenção!",1);
                return false;
            }else if (txtCNPJ.getText().replace(".", "").replace("-", "").replace("/", "").trim().length() != 14){
                JOptionPane.showMessageDialog(null, "O CNPJ deve ter 14 números!", "Atenção!",1);
                return false;
            }else if(txtAtividade.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a atividade da empresa!", "Atenção!",1);
                return false;
            }else if(txtRazaoSocial.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a razão social da empresa!", "Atenção!",1);
                return false;
            }else if(txtNomeFantasia.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a nome fantasia da empresa!", "Atenção!",1);
                return false;
            }
            return true;    
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean excluir(JTextField txtCodEmpresa) throws Exception{
        try{
            if (txtCodEmpresa.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe uma empresa!", "Atenção!",1);
                return false;
            }
            
            DadosEmpresa dEmpresa = new DadosEmpresa();
            
            return dEmpresa.excluir(Integer.parseInt(txtCodEmpresa.getText()));  
        }catch(Exception ex){
            throw ex;
        }
    }
}
