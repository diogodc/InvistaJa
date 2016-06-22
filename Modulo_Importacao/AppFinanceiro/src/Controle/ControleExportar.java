/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import App.AppFinanceiro;
import static App.AppFinanceiro.converteObjetoParaJson;
import static App.AppFinanceiro.gravarArquivo;
import static App.AppFinanceiro.sCaminhoArquivos;
import Dados.DadosEmpresa;
import Dados.DadosExportar;
import Visao.VisaoExportar;
import javax.swing.JOptionPane;

/**
 *
 * @author Everaldo Cardoso
 */
public class ControleExportar {
    VisaoExportar vExportar;
    DadosEmpresa dEmpresa;
    DadosExportar dExportar;
    
    public ControleExportar(VisaoExportar vExportar){
        this.vExportar = vExportar;
        this.dEmpresa = new DadosEmpresa();
        this.dExportar = new DadosExportar();
    }
    
    
    public void Exportar() throws Exception{
        try{
            if (vExportar.cboTipoExportacao.getSelectedIndex() == 0){
                if (gravarArquivo("json_Empresa.json",
                        converteObjetoParaJson(this.dEmpresa.carregarEmpresas(AppFinanceiro.tipoEmpresas.TODAS)))){
                    JOptionPane.showMessageDialog(null, "Sucesso!\nArquivo gerado em: " + sCaminhoArquivos, "Atenção!", 1);
                }else{
                    JOptionPane.showMessageDialog(null, "Houve(ram) problema(s) na geração do(s) arquivo(s)!", "Atenção!", 0);
                }
            }else{
                if (dExportar.calcularIndicadores("2013", "2014", "2015")){
                if (gravarArquivo("json_Bovespa.json",
                        converteObjetoParaJson(dExportar.gerarIndicadoresEmpresa()))){
                    JOptionPane.showMessageDialog(null, "Sucesso!\nArquivo gerado em: " + sCaminhoArquivos, "Atenção!", 1);
                }else{
                    JOptionPane.showMessageDialog(null, "Houve(ram) problema(s) na geração do(s) arquivo(s)!", "Atenção!", 0);
                }
            }
            }
        }catch(Exception ex){
            throw ex;
        }
    }
}
