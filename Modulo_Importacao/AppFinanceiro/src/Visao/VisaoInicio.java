package Visao;

import static App.AppFinanceiro.abrirVisao;
import static App.AppFinanceiro.conn;
import Dados.DadosManipulacao;
import javax.swing.JOptionPane;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class VisaoInicio extends javax.swing.JFrame {

    /**
     * Creates new form VisaoInicio
     */
    public VisaoInicio() {
        initComponents();
        conn = new DadosManipulacao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuDados = new javax.swing.JMenu();
        mnuCadEmpresas = new javax.swing.JMenuItem();
        mnuImportar = new javax.swing.JMenuItem();
        mnuAcoes = new javax.swing.JMenu();
        mnuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bovespa Analytics");

        pnlInicio.setBackground(new java.awt.Color(204, 204, 255));
        pnlInicio.setToolTipText("");
        pnlInicio.setAutoscrolls(true);

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 854, Short.MAX_VALUE)
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        mnuDados.setText("Dados");

        mnuCadEmpresas.setText("Cadastrar empresas");
        mnuCadEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadEmpresasActionPerformed(evt);
            }
        });
        mnuDados.add(mnuCadEmpresas);

        mnuImportar.setText("Importar dados");
        mnuImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuImportarActionPerformed(evt);
            }
        });
        mnuDados.add(mnuImportar);

        jMenuBar1.add(mnuDados);

        mnuAcoes.setText("Ações");
        mnuAcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcoesActionPerformed(evt);
            }
        });

        mnuSair.setText("Sair");
        mnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSairActionPerformed(evt);
            }
        });
        mnuAcoes.add(mnuSair);

        jMenuBar1.add(mnuAcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInicio)
                .addGap(0, 0, 0))
        );

        getAccessibleContext().setAccessibleName("Bovespa Analytics");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAcoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuAcoesActionPerformed

    private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
        try{
            this.dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getStackTrace(), this.getTitle(),0);
        }
    }//GEN-LAST:event_mnuSairActionPerformed

    private void mnuImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuImportarActionPerformed
        try{
            abrirVisao(pnlInicio,new VisaoImpExp());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getStackTrace(), this.getTitle(),0);
        }
    }//GEN-LAST:event_mnuImportarActionPerformed

    private void mnuCadEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadEmpresasActionPerformed
        try {
            abrirVisao(pnlInicio,new VisaoEmpresa());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getStackTrace(), this.getTitle(),0);
        }
    }//GEN-LAST:event_mnuCadEmpresasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisaoInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisaoInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuAcoes;
    private javax.swing.JMenuItem mnuCadEmpresas;
    private javax.swing.JMenu mnuDados;
    private javax.swing.JMenuItem mnuImportar;
    private javax.swing.JMenuItem mnuSair;
    public javax.swing.JDesktopPane pnlInicio;
    // End of variables declaration//GEN-END:variables
}
