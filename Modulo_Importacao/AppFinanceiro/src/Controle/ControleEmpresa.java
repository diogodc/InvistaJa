package Controle;

import static App.AppFinanceiro.converteStringParaJson;
import static App.AppFinanceiro.gravarArquivo;
import Dados.DadosEmpresa;
import Modelo.CreateModel;
import Modelo.ModeloEmpresa;
import Visao.VisaoEmpresa;
import Visao.VisaoPesquisar;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class ControleEmpresa {
    private VisaoEmpresa vEmpresa;
    private DadosEmpresa dEmpresa;
    
    public ControleEmpresa(VisaoEmpresa vEmpresa){
        this.vEmpresa = vEmpresa;
        this.dEmpresa = new DadosEmpresa(this.getModelo());
    }
    
    public boolean salvar() throws Exception{
        try{
            if (!this.validarCampos()){return false;}
                        
            vEmpresa.txtCodEmpresa.setText(this.dEmpresa.salvar(this.getModelo()));
            
            if (!vEmpresa.txtCodEmpresa.getText().isEmpty()){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private boolean validarCampos(){
        try{
            if(vEmpresa.txtCNPJ.getText().replace(".", "").replace("-", "").replace("/", "").trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe o CNPJ da empresa!", "Atenção!",1);
                return false;
            }else if (vEmpresa.txtCNPJ.getText().replace(".", "").replace("-", "").replace("/", "").trim().length() != 14){
                JOptionPane.showMessageDialog(null, "O CNPJ deve ter 14 números!", "Atenção!",1);
                return false;
            }else if(vEmpresa.txtAtividade.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a atividade da empresa!", "Atenção!",1);
                return false;
            }else if(vEmpresa.txtRazaoSocial.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a razão social da empresa!", "Atenção!",1);
                return false;
            }else if(vEmpresa.txtNomeFantasia.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a nome fantasia da empresa!", "Atenção!",1);
                return false;
            }
            return true;    
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean excluir() throws Exception{
        try{
            if (vEmpresa.txtCodEmpresa.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe uma empresa!", "Atenção!",1);
                return false;
            }
                 
            return this.dEmpresa.excluir(Integer.parseInt(
                    vEmpresa.txtCodEmpresa.getText()));  
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean exportar() throws Exception{
        try{
            return gravarArquivo("empresas.json",
                    converteStringParaJson(this.dEmpresa.carregarEmpresa()));
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public String zerarHistorico() throws Exception{
        try{           
            return this.dEmpresa.zerarHistorico(this.getModelo());
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private ModeloEmpresa getModelo(){
        try{
            ModeloEmpresa mEmpresa = new ModeloEmpresa();
            
            if (!vEmpresa.txtCodEmpresa.getText().trim().isEmpty()){
                mEmpresa.setEmpresa_ID(Integer.parseInt(
                        vEmpresa.txtCodEmpresa.getText().trim()));
            }else{
                mEmpresa.setEmpresa_ID(0);
            }
            mEmpresa.setCNPJ(vEmpresa.txtCNPJ.getText().trim());
            mEmpresa.setNome_Fantasia(vEmpresa.txtNomeFantasia.getText().trim());
            mEmpresa.setRazao_Social(vEmpresa.txtRazaoSocial.getText().trim());
            mEmpresa.setAtividade(vEmpresa.txtAtividade.getText().trim());
            return mEmpresa;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void limpar() {
        try{
            vEmpresa.txtCodEmpresa.setText("");
            vEmpresa.txtCNPJ.setText("");
            vEmpresa.txtAtividade.setText("");
            vEmpresa.txtRazaoSocial.setText("");
            vEmpresa.txtNomeFantasia.setText("");
        }catch(Exception ex){
            throw ex;
        }
    }
    
     private void carregaCampos(ArrayList<String> alDados) {
        try {
            if (alDados != null) {
                vEmpresa.txtCodEmpresa.setText(alDados.get(0));
                vEmpresa.txtNomeFantasia.setText(alDados.get(1));
                vEmpresa.txtRazaoSocial.setText(alDados.get(2));
                vEmpresa.txtCNPJ.setText(alDados.get(3));
                vEmpresa.txtAtividade.setText(alDados.get(4));
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
     
     public void carregaBusca(){
        try {
            String sCampos;

            sCampos = "ID_EMPRESA,";
            sCampos += "CNPJ,";
            sCampos += "RAZAO_SOCIAL,";
            sCampos += "NOME_FANTASIA,";
            sCampos += "ATIVIDADE";

            VisaoPesquisar vPesquisar = new VisaoPesquisar(null, true, sCampos, "BVSP_EMPRESA", "", "");

            vPesquisar.cboCampoPesquisa.addItem("ID_EMPRESA");
            vPesquisar.cboCampoPesquisa.addItem("CNPJ");
            vPesquisar.cboCampoPesquisa.addItem("RAZAO_SOCIAL");
            vPesquisar.cboCampoPesquisa.addItem("NOME_FANTASIA");
            vPesquisar.cboCampoPesquisa.addItem("ATIVIDADE");

            /**
             * RAFAEL 31/05/2016
             */
            vPesquisar.setModeloArvore(new <ModeloEmpresa>CreateModel(new ModeloEmpresa(), "RAZAO_SOCIAL"));

            vPesquisar.setVisible(true);
            carregaCampos(vPesquisar.getDados());
        } catch (Exception ex) {
            throw ex;
        }
    }
}
