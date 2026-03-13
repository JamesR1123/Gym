package memberpay;

import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;

public class payment extends javax.swing.JFrame {

    private int transactionId;

    public payment(int transactionId) {
        initComponents();
        this.transactionId = transactionId;

        loadTransactionDetails(); // <-- fetch service & trainer dynamically

        // Group the radio buttons
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(jRadioButton1); // PayMaya
        paymentGroup.add(jRadioButton2); // GCash

        // Disable Pay Now button initially
        jButton1.setEnabled(false);

        // Listen to reference field changes
        referenceField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { updatePayNowButton(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { updatePayNowButton(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { updatePayNowButton(); }
        });

        // Listen to radio button selection changes
        jRadioButton1.addActionListener(e -> updatePayNowButton());
        jRadioButton2.addActionListener(e -> updatePayNowButton());
    }

    // Fetch transaction details from DB
    private void loadTransactionDetails() {
        String sql = "SELECT t.transaction_id, "
                   + "COALESCE(a.U_firstname || ' ' || a.U_lastname, 'No Trainer') AS trainer_name, "
                   + "t.service_name, t.amount "
                   + "FROM transactions t "
                   + "LEFT JOIN gym_services gs ON t.service_id = gs.service_id "
                   + "LEFT JOIN tbl_accounts a ON gs.trainer_id = a.U_id "
                   + "WHERE t.transaction_id = ?";

        try (Connection con = config.connectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, transactionId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                trainername.setText(rs.getString("trainer_name"));
                servicename.setText(rs.getString("service_name"));
                amount.setText("₱" + rs.getDouble("amount"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Enable Pay Now button only if conditions are met
    private void updatePayNowButton() {
        boolean methodSelected = jRadioButton1.isSelected() || jRadioButton2.isSelected();
        boolean referenceEntered = !referenceField.getText().trim().isEmpty();
        jButton1.setEnabled(methodSelected && referenceEntered);
    }

    private void payNow() {
        String method = jRadioButton1.isSelected() ? "PayMaya" :
                        jRadioButton2.isSelected() ? "GCash" : null;

        if (method == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a payment method.");
            return;
        }

        String reference = referenceField.getText().trim();
        if (!reference.matches("\\d{12}")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Reference number must be exactly 12 digits.");
            return;
        }

        boolean success = savePayment(transactionId, method, reference);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Payment submitted successfully!\nStatus: Pending Verification");
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Failed to submit payment. Try again.");
        }
    }

    private boolean savePayment(int transactionId, String method, String reference) {
        String sql = "UPDATE transactions SET payment_method=?, reference_number=?, status='Pending Verification' WHERE transaction_id=?";
        try (Connection con = config.connectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, method);
            pst.setString(2, reference);
            pst.setInt(3, transactionId);

            return pst.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        referenceField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        servicename = new javax.swing.JLabel();
        trainername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 235, 150));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Payment");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 510, 60));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jLabel7.setText("Choose Payment Method");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 21)); // NOI18N
        jRadioButton2.setText("    GCash");
        jPanel4.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 21)); // NOI18N
        jRadioButton1.setText("    PayMaya");
        jPanel4.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel2.setText("Reference Number");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));
        jPanel4.add(referenceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 280, 40));

        jButton1.setBackground(new java.awt.Color(255, 235, 150));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        jButton1.setText("Pay Now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 235, 150));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 150, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel4.setText("Service Name  : ");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel5.setText("Trainer  :");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel6.setText("Amount  :");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        amount.setFont(new java.awt.Font("Segoe UI Semibold", 0, 21)); // NOI18N
        jPanel4.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 340, 30));

        servicename.setFont(new java.awt.Font("Segoe UI Semibold", 0, 21)); // NOI18N
        jPanel4.add(servicename, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 290, 30));

        trainername.setFont(new java.awt.Font("Segoe UI Semibold", 0, 21)); // NOI18N
        jPanel4.add(trainername, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 350, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 510, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
         int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to cancel this payment?",
            "Cancel Payment",
            javax.swing.JOptionPane.YES_NO_OPTION
        );

        if(confirm == javax.swing.JOptionPane.YES_OPTION){
        this.dispose();
    }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        payNow();
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           new payment(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField referenceField;
    private javax.swing.JLabel servicename;
    private javax.swing.JLabel trainername;
    // End of variables declaration//GEN-END:variables
}
