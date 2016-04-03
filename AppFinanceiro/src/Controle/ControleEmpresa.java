/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Visao.VisaoEmpresa;
import javax.swing.JDesktopPane;

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
}
