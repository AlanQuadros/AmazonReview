/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import pucrs.DataManager;
import pucrs.Product;
import pucrs.Review;
import pucrs.User;

/**
 *
 * @author Alan Quadros
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    
    DataManager dataManager;
    
    DefaultTableModel dtmAvaliacao = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"Rating", "Data/Hora", "Resumo", "Texto"}) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    DefaultTableModel dtmUsuarios = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"ID", "Nome", "Avaliações"}) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel dtmProdutos = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"ID", "Nome", "Preço", "Avaliações"}) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public Principal() {
        initComponents();
        dataManager = new DataManager(); 
        dataManager.leitura();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTableAvaliacao = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfPesquisarAvaliacao = new javax.swing.JTextField();
        jbPesquisarAvaliacao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfUsuarioId = new javax.swing.JTextField();
        jtfUsuarioNome = new javax.swing.JTextField();
        jbUsuarioClassificacao = new javax.swing.JButton();
        jbPesquisarUsuarioId = new javax.swing.JButton();
        jbUsuarioNome = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtableProdutos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jtfProdutosId = new javax.swing.JTextField();
        jbProdutosId = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfProdutosNome = new javax.swing.JTextField();
        jbProdutosNome = new javax.swing.JButton();
        jbClassificacaoProdutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Rating", "Data/Hora", "Resumo", "Texto"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTableAvaliacao.setViewportView(jTable1);

        jLabel1.setText("Termo");

        jbPesquisarAvaliacao.setText("Pesquisar");
        jbPesquisarAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarAvaliacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTableAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfPesquisarAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPesquisarAvaliacao)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPesquisarAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jbPesquisarAvaliacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTableAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Avaliações", jPanel1);

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Avaliações"
            }
        ));
        jScrollPane2.setViewportView(jTableUsuarios);

        jLabel2.setText("ID");

        jLabel3.setText("Nome");

        jbUsuarioClassificacao.setText("Classificação Usuários com Avaliações");
        jbUsuarioClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUsuarioClassificacaoActionPerformed(evt);
            }
        });

        jbPesquisarUsuarioId.setText("Pesquisar");
        jbPesquisarUsuarioId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarUsuarioIdActionPerformed(evt);
            }
        });

        jbUsuarioNome.setText("Pesquisar");
        jbUsuarioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUsuarioNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfUsuarioNome))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbPesquisarUsuarioId)
                            .addComponent(jbUsuarioNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jbUsuarioClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbPesquisarUsuarioId))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbUsuarioNome))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jbUsuarioClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Usuários", jPanel2);

        jtableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Preço", "Avaliações"
            }
        ));
        jtableProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtableProdutos);

        jLabel4.setText("ID");

        jbProdutosId.setText("Pesquisar");
        jbProdutosId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProdutosIdActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome");

        jbProdutosNome.setText("Pesquisar");
        jbProdutosNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProdutosNomeActionPerformed(evt);
            }
        });

        jbClassificacaoProdutos.setText("Classificação de Produtos mais bem avaliados");
        jbClassificacaoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClassificacaoProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfProdutosNome, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbProdutosNome, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfProdutosId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbProdutosId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addComponent(jbClassificacaoProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfProdutosId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbProdutosId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfProdutosNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbProdutosNome)))
                    .addComponent(jbClassificacaoProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Produtos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPesquisarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarAvaliacaoActionPerformed
        
        dtmAvaliacao.setRowCount(0);
        ArrayList<Review> reviews = dataManager.searchReviewByString(jtfPesquisarAvaliacao.getText());        
        
        for(Review rev : reviews){
            String score = String.valueOf(rev.getScore());
            long time1 = rev.getTime();
            LocalDateTime time2 = LocalDateTime.ofInstant(Instant.ofEpochSecond(time1), ZoneOffset.UTC);
            String time = time2.getMonth()+"/"+time2.getYear();
            String summary = rev.getSummary();
            String text = rev.getText();
            
            dtmAvaliacao.addRow(new String[] {score, time, summary, text});
        }
        
    }//GEN-LAST:event_jbPesquisarAvaliacaoActionPerformed

    private void jbPesquisarUsuarioIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarUsuarioIdActionPerformed
       
        User user = dataManager.searchUserById(jtfUsuarioId.getText()); 
        DefaultTableModel tabUser = (DefaultTableModel) jTableUsuarios.getModel();
        tabUser.setNumRows(0);
        
        String id = user.getUserId();
        String nome = user.getProfileName();
        
        ArrayList<Review> revs = dataManager.getReviewByUser(user);
        
        String reviews = "";
        
        for(Review rev: revs){
            String review = rev.getText();
            reviews = reviews+review+" / ";
        }
        tabUser.addRow(new String[]{id, nome, reviews});
        
        
        
        System.out.println(id+"\n"+nome+"\n"+reviews);
        
    }//GEN-LAST:event_jbPesquisarUsuarioIdActionPerformed

    private void jbUsuarioNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUsuarioNomeActionPerformed
        
        User user = dataManager.searchUserByName(jtfUsuarioNome.getText());
        DefaultTableModel tabUser = (DefaultTableModel) jTableUsuarios.getModel();
        tabUser.setNumRows(0);
        
        String id = user.getUserId();
        String nome = user.getProfileName();
        
        ArrayList<Review> revs = dataManager.getReviewByUser(user);
        String reviews = "";
        
        for(Review rev: revs){
            String review = rev.getText();
            reviews = reviews+review+"\n";
        }
        tabUser.addRow(new String[]{id, nome, reviews});
    }//GEN-LAST:event_jbUsuarioNomeActionPerformed

    private void jbUsuarioClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUsuarioClassificacaoActionPerformed
                
        ArrayList<User> userReview = dataManager.getUsefulUsers();
        for(User user : userReview){
            String id = user.getUserId();
            String nome = user.getProfileName();
            
            ArrayList<Review> reviews = user.returnAllReviews();
            String revs = "";
            for(Review r : reviews){
                String rev = String.valueOf(r.getScore());
                revs = revs + rev + " / ";
            }
            
            dtmUsuarios.addRow(new String[] {id, nome, revs});
        }
    }//GEN-LAST:event_jbUsuarioClassificacaoActionPerformed

    private void jbProdutosIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProdutosIdActionPerformed
       
        Product product = dataManager.searchProductById(jtfProdutosId.getText());
        DefaultTableModel tabProduct = (DefaultTableModel) jtableProdutos.getModel();
        tabProduct.setNumRows(0);
        
        System.out.println(product.getProductId()+"\n"+product.getTitle()+"\n"+product.getPrice());
        
        String id = product.getProductId();
        String nome = product.getTitle();        
        
        Double price1 = product.getPrice();
        String price = "";
        
        System.out.println(price1);
        
        if(price1 == Product.UNKOWN_PRICE){
            price = "Unkown Price";
        } else if(price1 == Product.UNDEFINED_PRICE){
            price = "Undefined Price";
        } else {
            price = String.valueOf(price1);
        }
        
        ArrayList<Review> reviews = product.getAllReviews();
        String revs = "";
        for(Review rev : reviews){
            String r = String.valueOf(rev.getScore());
            revs = revs + r + " / ";
        }
        
        tabProduct.addRow(new String[] {id, nome, price, revs});
    }//GEN-LAST:event_jbProdutosIdActionPerformed

    private void jbProdutosNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProdutosNomeActionPerformed
        
        Product product = dataManager.searchProductByName(jtfProdutosNome.getText());
        
        String id = product.getProductId();
        String nome = product.getTitle();
        double price1 = product.getPrice();
        String price = "";
        
        if(price1 == Product.UNKOWN_PRICE){
            price = "Unkown Price";
        } else if(price1 == Product.UNDEFINED_PRICE){
            price = "Undefined Price";
        } else {
            price = String.valueOf(price1);
        }
        
        ArrayList<Review> reviews = product.getAllReviews();
        String revs = "";
        for(Review rev : reviews){
            String r = String.valueOf(rev.getScore());
            revs = revs + r + " / ";
        }
        
        dtmProdutos.addRow(new String[] {id, nome, price, revs});
    }//GEN-LAST:event_jbProdutosNomeActionPerformed

    private void jbClassificacaoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClassificacaoProdutosActionPerformed
        
        ArrayList<Product> productsReviews = dataManager.getBestReviewed();
        
        for(Product product : productsReviews){
            String id = product.getProductId();
            String nome = product.getTitle();
            
            double price1 = product.getPrice();
            String price = "";
            if(price1 == Product.UNKOWN_PRICE){
                price = "Unkown Price";
            } else if(price1 == Product.UNDEFINED_PRICE){
                price = "Undefined Price";
            } else {
                price = String.valueOf(price1);
            }
            
            ArrayList<Review> reviews = product.getAllReviews();
            String revs = "";
            for(Review rev : reviews){
                String r = String.valueOf(rev.getScore());
                revs = revs + r + " / ";
            }

            dtmProdutos.addRow(new String[] {id, nome, price, revs});
        }
    }//GEN-LAST:event_jbClassificacaoProdutosActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane jTableAvaliacao;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JButton jbClassificacaoProdutos;
    private javax.swing.JButton jbPesquisarAvaliacao;
    private javax.swing.JButton jbPesquisarUsuarioId;
    private javax.swing.JButton jbProdutosId;
    private javax.swing.JButton jbProdutosNome;
    private javax.swing.JButton jbUsuarioClassificacao;
    private javax.swing.JButton jbUsuarioNome;
    private javax.swing.JTable jtableProdutos;
    private javax.swing.JTextField jtfPesquisarAvaliacao;
    private javax.swing.JTextField jtfProdutosId;
    private javax.swing.JTextField jtfProdutosNome;
    private javax.swing.JTextField jtfUsuarioId;
    private javax.swing.JTextField jtfUsuarioNome;
    // End of variables declaration//GEN-END:variables
}
