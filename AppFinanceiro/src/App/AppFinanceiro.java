/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Dados.DadosManipulacao;
import Visao.VisaoInicio;
import javax.swing.JFrame;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class AppFinanceiro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VisaoInicio visaoInicio = new VisaoInicio(); 
        visaoInicio.setVisible(true);
        visaoInicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }  
    
    public static DadosManipulacao conn = new DadosManipulacao();
}
