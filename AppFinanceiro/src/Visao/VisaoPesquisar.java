/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import static App.AppFinanceiro.conn;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class VisaoPesquisar extends javax.swing.JDialog {
    
    public String tabela;//Variavel que carrega a tabela para as consultas;
    public Vector linhas = new Vector(); //Vetor que guarda as linhas da consulta;
    public Vector cabecalho = new Vector();//Vetor que guarda o Cabeçalho;  
    public String parametros;//String que recebe a consulta personalizada;
    public ArrayList<String> dados = new ArrayList();//Guarda os dados da consulta;
    public String codigo;//Variavel que carrega o codigo para pegar todos os dados da seleção;
    public String condicao; //passa o where da consulta;
    public String join;
    
    public VisaoPesquisar(java.awt.Frame parent, boolean modal, String paramentros,String tabela,String join, String condicao) {
        super(parent, modal);
        this.tabela = tabela;//Recebe a tabela usada para fazer a consulta;
        this.parametros=paramentros;//Recebe a pesquisa personalizada;
        this.condicao=condicao;
        this.join=join;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabResultado = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboPesquisa = new javax.swing.JComboBox();
        comboModoPesquisa = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabResultado);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Pesquisa:");

        txtFiltro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Campo de pesquisa:");

        comboModoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Iniciado por", "Contendo" }));

        jLabel3.setText("Modo de Pesquisa:");

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(comboModoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(330, 330, 330)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(comboModoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadoMouseClicked
        try {
            int linha=tabResultado.getSelectedRow();   
            conn.abrirConexao();
            ResultSet rs = conn.Selecionar("SELECT * FROM "+tabela+" WHERE "+codigo+"="+tabResultado.getValueAt(linha, 0));
            for (int i=1;i<=conn.getResultSetMetaData().getColumnCount();++i){//For que pega o resultado da linha e joga no vertor;
                dados.add(rs.getString(i));
            }
            this.dispose();
            conn.fecharConexao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro Interno:",0);//Alerta de falha;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabResultadoMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tabResultado.getModel();//Pegando o tipo de tabela;
        dtm.getDataVector().clear();//Limpando as Linhas da tabela;
        dtm.setColumnCount(0);//Limpando as colunas da tabela;
        if (txtFiltro.getText().equals("")) {//Se o filtro estiver vazio faz a pesquisa na tabela inteira;
            preecheTabela("SELECT "+parametros+" FROM "+tabela+" "+join);
        }else if (comboModoPesquisa.getSelectedItem()=="Iniciado por"){//Faz a pesquisa trazendo resultados inciados com o valor da pesquisa;
            preecheTabela("SELECT "+parametros+" FROM " + tabela +" "+join+" WHERE " + comboPesquisa.getSelectedItem() + " LIKE '" + txtFiltro.getText() + "%'");
        }else if(comboModoPesquisa.getSelectedItem()=="Contendo"){//Faz a pesquisa trazendo resultados que contenham o valor da pesquisa;
            preecheTabela("SELECT "+parametros+" FROM " + tabela +" "+join+ " WHERE " + comboPesquisa.getSelectedItem() + " LIKE '%" + txtFiltro.getText() + "%'");
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(VisaoPesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoPesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoPesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoPesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisaoPesquisar dialog = new VisaoPesquisar(new javax.swing.JFrame(), true,"","",null,"");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
     public void preecheTabela(String Query) {
        try {
            if(!condicao.equals("")){
                Query=Query+" "+condicao;
            }
            conn.abrirConexao();//Abrindo a conexão com o banco;
            ResultSet rs = conn.Selecionar(Query);//Passando a Query chamada no ato do click no btnPesquisar;
        
            while(rs.next()){//While que preeche o Vetor das linhas e passa para o metodo proxima linha;
                linhas.addElement(proximaLinha(conn.getResultSet(),conn.getResultSetMetaData()));
            }
            for(int i=1;i<=conn.getResultSetMetaData().getColumnCount();i++){
                cabecalho.addElement(conn.getResultSetMetaData().getColumnLabel(i));//Carregando os nomes das tabelas;
            }
            codigo=conn.getResultSetMetaData().getColumnName(1);
            tabResultado.setModel(new javax.swing.table.DefaultTableModel(linhas, cabecalho));//Inserindo dados dentro do JTable;
            tabResultado.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);//Modo de seleção da tabela: Simples;
            conn.fecharConexao();//Fechando a conexão com Banco;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro Interno:",0);//Alerta de falha;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VisaoPesquisar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd){//Recebe os paramentros de conexão;
        Vector linhaAtual = new Vector();//Vetor da linha Atual;
        try {
            for (int i=1;i<=rsmd.getColumnCount();++i){//For que pega o resultado da linha e joga no vertor;
                linhaAtual.addElement(rs.getString(i));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro Interno:",0);//Alerta de falha;
        }
        return linhaAtual;//Retorna um vetor com os dados da atual linha;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    public javax.swing.JComboBox comboModoPesquisa;
    public javax.swing.JComboBox comboPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabResultado;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
