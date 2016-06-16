package Visao;

import static App.AppFinanceiro.abrirVisaoArquivo;
import Controle.ControleImpExp;
import javax.swing.JOptionPane;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class VisaoImpExp extends javax.swing.JInternalFrame {
    
    private ControleImpExp cManipulacao;
    
    public VisaoImpExp() {
        initComponents(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtCaminhoArquivo = new javax.swing.JTextField();
        btnImportar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        cboTipoRelatorio = new javax.swing.JComboBox<>();
        txtCodEmpresa = new javax.swing.JTextField();
        txtDscEmpresa = new javax.swing.JTextField();
        btnProcurarEmpresa = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        chkBPP = new javax.swing.JCheckBox();
        chkDRE = new javax.swing.JCheckBox();
        chkBPA = new javax.swing.JCheckBox();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Importar Arquivos");
        setToolTipText("Importar Arquivos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Informe os dados para a importação:");

        btnImportar.setText("Importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        btnSelecionar.setText("Arquivo");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        cboTipoRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DRE-Demostrativo de Resultados", "BPA-Balanço Patrimonial Ativo", "BPP-Balanço Patrimonial Passivo" }));

        txtCodEmpresa.setEnabled(false);

        txtDscEmpresa.setEnabled(false);
        txtDscEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDscEmpresaActionPerformed(evt);
            }
        });

        btnProcurarEmpresa.setText("Empresa");
        btnProcurarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarEmpresaActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        chkBPP.setText("BPP");
        chkBPP.setEnabled(false);

        chkDRE.setText("DRE");
        chkDRE.setEnabled(false);

        chkBPA.setText("BPA");
        chkBPA.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnProcurarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDscEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboTipoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkDRE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkBPA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkBPP)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcurarEmpresa)
                    .addComponent(txtDscEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboTipoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkDRE)
                        .addComponent(chkBPA)
                        .addComponent(chkBPP))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnImportar)
                        .addComponent(btnExportar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        try{
            txtCaminhoArquivo.setText(abrirVisaoArquivo(this));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(),0);
        } 
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
         try{
             cManipulacao.Importar();
         }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(),0);
        } 
    }//GEN-LAST:event_btnImportarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try{    
            cManipulacao = new ControleImpExp(this);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(),0);
        } 
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtDscEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDscEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDscEmpresaActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try{
            cManipulacao.exportar();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(),0);
        } 
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnProcurarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarEmpresaActionPerformed
         try {
           cManipulacao.carregaBusca();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(), 0);
        }
    }//GEN-LAST:event_btnProcurarEmpresaActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExportar;
    public javax.swing.JButton btnImportar;
    public javax.swing.JButton btnProcurarEmpresa;
    public javax.swing.JButton btnSelecionar;
    public javax.swing.JComboBox<String> cboTipoRelatorio;
    public javax.swing.JCheckBox chkBPA;
    public javax.swing.JCheckBox chkBPP;
    public javax.swing.JCheckBox chkDRE;
    private javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JTextField txtCaminhoArquivo;
    public javax.swing.JTextField txtCodEmpresa;
    public javax.swing.JTextField txtDscEmpresa;
    // End of variables declaration//GEN-END:variables
}
