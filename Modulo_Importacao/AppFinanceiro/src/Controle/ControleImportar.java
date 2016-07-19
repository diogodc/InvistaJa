package Controle;

import App.AppFinanceiro.tipoRelatorio;
import Dados.DadosImportar;
import Modelo.CreateModel;
import Modelo.ModeloEmpresa;
import Modelo.ModeloImportar;
import Visao.VisaoImportar;
import Visao.VisaoPesquisar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControleImportar {

    private final VisaoImportar vImportar;
    private final DadosImportar dImpExp;

    public ControleImportar(VisaoImportar vImportar) {
        this.vImportar = vImportar;
        this.dImpExp = new DadosImportar();
    }

    private boolean lerArquivo() throws Exception {
        try {
            if (!validarArquivo()) {
                return false;
            }
            if (this.vImportar.txtCodEmpresa.getText().trim().isEmpty()) {
                return false;
            }

            BufferedReader brLeitor = new BufferedReader(new FileReader(this.vImportar.txtCaminhoArquivo.getText()));

            switch (this.vImportar.cboTipoRelatorio.getSelectedIndex()) {
                case 0:
                    return this.dImpExp.importarDados(manipularArquivo(brLeitor,
                            this.vImportar.txtCodEmpresa.getText().trim()), tipoRelatorio.DRE);
                case 1:
                    return this.dImpExp.importarDados(manipularArquivo(brLeitor,
                            this.vImportar.txtCodEmpresa.getText().trim()), tipoRelatorio.BPA);
                default:
                    return this.dImpExp.importarDados(manipularArquivo(brLeitor,
                            this.vImportar.txtCodEmpresa.getText().trim()), tipoRelatorio.BPP);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private boolean validarArquivo() {
        try {
            if (this.vImportar.txtCaminhoArquivo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o caminho do .CSV", "Atenção!", 0);
                return false;
            } else if (!this.vImportar.txtCaminhoArquivo.getText().trim().toUpperCase().contains(".CSV")) {
                JOptionPane.showMessageDialog(null, "Informe um arquivo do tipo .CSV", "Atenção!", 0);
                return false;
            }
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private ArrayList<ModeloImportar> manipularArquivo(BufferedReader brLeitor, String sEmpresa_ID) throws Exception {
        try {
            int iEmpresa_ID = Integer.parseInt(sEmpresa_ID);
            String sLinha;
            ArrayList<ModeloImportar> lMImportar = new ArrayList<ModeloImportar>();
            ArrayList<String> lPeriodo = new ArrayList<String>();
            int iCont = 0;

            while ((sLinha = brLeitor.readLine()) != null) {
                if (iCont == 0) {
                    String[] sVetCelula = sLinha.split(";");
                    for (int i = 2; i<sVetCelula.length;i++){
                        lPeriodo.add(sVetCelula[i]);
                    }
                } else {
                    ModeloImportar mImportar = new ModeloImportar();
                    String[] sVetCelula = sLinha.split(";");
                    int iQuantReg = sVetCelula.length;
                    mImportar.setEmpresa_ID(iEmpresa_ID);

                    mImportar.setPeriodo_1(lPeriodo.get(0));
                    mImportar.setPeriodo_2(lPeriodo.get(1));
                    mImportar.setPeriodo_3(lPeriodo.get(2));
                    if (iQuantReg > 0) {
                        mImportar.setConta(sVetCelula[0].trim());
                    }
                    if (iQuantReg > 1) {
                        mImportar.setDescricao(sVetCelula[1].trim());
                    }
                    if (iQuantReg > 2) {
                        mImportar.setValor_1(sVetCelula[2].trim());
                    }
                    if (iQuantReg > 3) {
                        mImportar.setValor_2(sVetCelula[3].trim());
                    }
                    if (iQuantReg > 4) {
                        mImportar.setValor_3(sVetCelula[4].trim());
                    }
                    lMImportar.add(mImportar);
                }
                iCont++;
            }

            return lMImportar;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void carregaBusca() {
        try {
            String sCampos;

            sCampos = "ID_EMPRESA,";
            sCampos += "CNPJ,";
            sCampos += "RAZAO_SOCIAL,";
            sCampos += "NOME_FANTASIA,";
            sCampos += "ATIVIDADE,";
            sCampos += "BPA,";
            sCampos += "BPP,";
            sCampos += "DRE";

            VisaoPesquisar vPesquisar = new VisaoPesquisar(null, true, sCampos, "BVSP_EMPRESA", "", "");

            vPesquisar.cboCampoPesquisa.addItem("ID_EMPRESA");
            vPesquisar.cboCampoPesquisa.addItem("CNPJ");
            vPesquisar.cboCampoPesquisa.addItem("RAZAO_SOCIAL");
            vPesquisar.cboCampoPesquisa.addItem("NOME_FANTASIA");
            vPesquisar.cboCampoPesquisa.addItem("ATIVIDADE");
            vPesquisar.cboCampoPesquisa.addItem("BPA");
            vPesquisar.cboCampoPesquisa.addItem("BPP");
            vPesquisar.cboCampoPesquisa.addItem("DRE");

            vPesquisar.setModeloArvore(new <ModeloEmpresa>CreateModel(new ModeloEmpresa(), "RAZAO_SOCIAL"));

            vPesquisar.setVisible(true);
            this.carregaCampos(vPesquisar.getDados());
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void carregaCampos(ArrayList<String> alDados) {
        if (alDados != null) {
            this.vImportar.txtCodEmpresa.setText(alDados.get(0));
            this.vImportar.txtDscEmpresa.setText(alDados.get(2));
            
            this.vImportar.chkDRE.setSelected(false);
            if (alDados.get(5) != null) {
                if (alDados.get(5).equals("S")) {
                    this.vImportar.chkDRE.setSelected(true);
                } else {
                    this.vImportar.chkDRE.setSelected(false);
                }
            }else{
                this.vImportar.chkDRE.setSelected(false);
            }
            
            this.vImportar.chkBPA.setSelected(false);
            if (alDados.get(6) != null) {
                if (alDados.get(6).equals("S")) {
                    this.vImportar.chkBPA.setSelected(true);
                } else {
                    this.vImportar.chkBPA.setSelected(false);
                }
            } else {
                this.vImportar.chkBPA.setSelected(false);
            }
            
            this.vImportar.chkBPP.setSelected(false);
            if (alDados.get(7) != null) {
                if (alDados.get(7).equals("S")) {
                    this.vImportar.chkBPP.setSelected(true);
                } else {
                    this.vImportar.chkBPP.setSelected(false);
                }
            }else{
                this.vImportar.chkBPP.setSelected(false);
            }
        }
    }

    public void Importar() throws Exception {
        try {
            if (this.validaImportar()) {
                if (this.lerArquivo()) {
                    if (this.vImportar.cboTipoRelatorio.getSelectedIndex() == 0) {
                        this.vImportar.chkDRE.setSelected(true);
                    } else if (this.vImportar.cboTipoRelatorio.getSelectedIndex() == 1) {
                        this.vImportar.chkBPA.setSelected(true);
                    } else {
                        this.vImportar.chkBPP.setSelected(true);
                    }
                    JOptionPane.showMessageDialog(null, "Sucesso!", this.vImportar.getTitle(), 1);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    private boolean validaImportar() {
        try {
            if (this.vImportar.cboTipoRelatorio.getSelectedIndex() == 0
                    && this.vImportar.chkDRE.isSelected() == true) {
                JOptionPane.showMessageDialog(null, "DRE já importada!", "Ação cancelada!", 0);
                return false;
            } else if (this.vImportar.cboTipoRelatorio.getSelectedIndex() == 1
                    && this.vImportar.chkBPA.isSelected() == true) {
                JOptionPane.showMessageDialog(null, "Balanço patrimonial ativo já importado!", "Ação cancelada!", 0);
                return false;
            } else if (this.vImportar.cboTipoRelatorio.getSelectedIndex() == 2
                    && this.vImportar.chkBPP.isSelected() == true) {
                JOptionPane.showMessageDialog(null, "Balanço patrimonial passivo já importado!", "Ação cancelada!", 0);
                return false;
            }
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
