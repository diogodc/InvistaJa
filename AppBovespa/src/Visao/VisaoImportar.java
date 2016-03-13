package Visao;

import Controle.ControleImportar;
import javax.swing.JOptionPane;

public class VisaoImportar extends javax.swing.JFrame {
    private final ControleImportar ctrImp;

    public VisaoImportar() {
        initComponents();
        ctrImp = new ControleImportar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSelecionarArquivo = new javax.swing.JButton();
        txtCaminhoArquivo = new javax.swing.JTextField();
        btnImportarArquivo = new javax.swing.JButton();
        pgbProgressoImportacao = new javax.swing.JProgressBar();
        lblProgresso = new javax.swing.JLabel();
        lblImprimir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Importação de Arquivos");
        setName("Importação de Arquivos"); // NOI18N

        jLabel1.setText("Informe abaixo o caminho para o arquivo de dados em formato .CSV:");

        btnSelecionarArquivo.setText("Selecionar");
        btnSelecionarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarArquivoActionPerformed(evt);
            }
        });

        txtCaminhoArquivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnImportarArquivo.setText("Importar");
        btnImportarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarArquivoActionPerformed(evt);
            }
        });

        pgbProgressoImportacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblProgresso.setText("Progresso:");

        lblImprimir.setText("Imprimir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelecionarArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(pgbProgressoImportacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProgresso)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnImportarArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(139, 139, 139)))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(lblImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarArquivo))
                .addGap(18, 18, 18)
                .addComponent(lblProgresso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgbProgressoImportacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImportarArquivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lblImprimir)
                .addGap(69, 69, 69))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarArquivoActionPerformed
        try{
            txtCaminhoArquivo.setText(ctrImp.AbrirVisaoArquivo());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), this.getTitle(),0);
        } 
    }//GEN-LAST:event_btnSelecionarArquivoActionPerformed

    private void btnImportarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarArquivoActionPerformed
        try{
            if (ctrImp.ImportarArquivo(pgbProgressoImportacao,lblProgresso,txtCaminhoArquivo,lblImprimir)){
                JOptionPane.showMessageDialog(null, "Sucesso!", this.getTitle(),1);
            }else{
                JOptionPane.showMessageDialog(null, "Erro!", this.getTitle(),0);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getStackTrace(), this.getTitle(),0);
        }
    }//GEN-LAST:event_btnImportarArquivoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VisaoImportar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImportarArquivo;
    private javax.swing.JButton btnSelecionarArquivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblImprimir;
    private javax.swing.JLabel lblProgresso;
    private javax.swing.JProgressBar pgbProgressoImportacao;
    private javax.swing.JTextField txtCaminhoArquivo;
    // End of variables declaration//GEN-END:variables
}
