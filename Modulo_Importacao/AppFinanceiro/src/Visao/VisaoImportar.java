package Visao;

import Controle.ControleImportar;
import Modelo.CreateModel;
import Modelo.ModeloEmpresa;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class VisaoImportar extends javax.swing.JInternalFrame {
    
    private ControleImportar cImportar;
    
    public VisaoImportar() {
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
                            .addComponent(cboTipoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelecionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProcurarEmpresa)
                            .addComponent(txtDscEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTipoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnImportar)
                        .addComponent(btnExportar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        try{
            txtCaminhoArquivo.setText(cImportar.abrirVisaoArquivo());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(),0);
        } 
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
         try{
           if (cImportar.lerArquivo(txtCaminhoArquivo,cboTipoRelatorio,txtCodEmpresa)){
               JOptionPane.showMessageDialog(null, "Sucesso!", this.getTitle(),1);
           }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(),0);
        }
    }//GEN-LAST:event_btnImportarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try{    
            cImportar = new ControleImportar(this);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(),0);
        } 
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtDscEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDscEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDscEmpresaActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnProcurarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarEmpresaActionPerformed
         try {
           this.carregaBusca();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(), 0);
        }
    }//GEN-LAST:event_btnProcurarEmpresaActionPerformed

    private void carregaCampos(ArrayList<String> alDados){
        if (alDados != null){
            this.txtCodEmpresa.setText(alDados.get(0));
            this.txtDscEmpresa.setText(alDados.get(2));
        }
        
    }

    private void carregaBusca(){
        try{
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

            vPesquisar.setModeloArvore(new <ModeloEmpresa>CreateModel(new ModeloEmpresa(), "RAZAO_SOCIAL"));

            vPesquisar.setVisible(true);
            carregaCampos(vPesquisar.getDados());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(),0);
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnImportar;
    private javax.swing.JButton btnProcurarEmpresa;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox<String> cboTipoRelatorio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCaminhoArquivo;
    private javax.swing.JTextField txtCodEmpresa;
    private javax.swing.JTextField txtDscEmpresa;
    // End of variables declaration//GEN-END:variables
}
