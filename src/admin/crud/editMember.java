
package admin.crud;

import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;


public class editMember extends javax.swing.JFrame {

    public editMember(String id, String firstname, String lastname, String phone, String email, String birthdate) {
        initComponents();
        idField.setText(String.valueOf(id));       // ID
        this.firstname.setText(firstname);        // First Name
        this.lastname.setText(lastname);         // Last Name
        this.phone.setText(phone);            // Phone Number
        this.email.setText(email);            // Email
        this.birth.setText(birthdate);         // Birthdate
    }
    
    

private boolean isValidDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd")
                .withResolverStyle(java.time.format.ResolverStyle.STRICT);

        try {
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        birth = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        birth.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        birth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthActionPerformed(evt);
            }
        });
        jPanel2.add(birth, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 370, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 100, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setText("Edit Member Information");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 320, 60));

        firstname.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel2.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 370, 40));

        lastname.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel2.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 370, 40));

        phone.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        jPanel2.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 370, 40));

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("First Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Last Name");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Phone Number");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        email.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 370, 40));

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Email Address");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Birthdate");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setText("Save Changes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel1.setText("ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        jPanel2.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 60, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void birthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // Get updated values from the text fields
        String id = idField.getText().trim();
        String firstName = firstname.getText().trim();
        String lastName = lastname.getText().trim();
        String phoneNumber = phone.getText().trim();
        String emailAddress = email.getText().trim();
        String birthDate = birth.getText().trim();

        // ===== Validation =====
        if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() 
            || emailAddress.isEmpty() || birthDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!");
            return;
        }

        // Phone number: only digits & exactly 11 digits
        if (!phoneNumber.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(this, "Phone number must be exactly 11 digits!");
            return;
        }

        // Email format validation
        if (!emailAddress.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Invalid email address!");
            return;
        }

        // Birthdate validation
        if (!isValidDate(birthDate)) {
            JOptionPane.showMessageDialog(this, "Invalid birthdate! Use YYYY/MM/DD");
            return;
        }

        // ===== Check if email already exists for another member =====
        try {
            Connection conn = config.connectDB();
            String checkEmail = "SELECT U_id FROM tbl_accounts WHERE U_email = ? AND U_id <> ?";
            PreparedStatement pstCheck = conn.prepareStatement(checkEmail);
            pstCheck.setString(1, emailAddress);
            pstCheck.setString(2, id);
            java.sql.ResultSet rs = pstCheck.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "This email is already used by another member!");
                pstCheck.close();
                conn.close();
                return;
            }
            pstCheck.close();

            // ===== Update DB =====
            String sql = "UPDATE tbl_accounts SET " +
                         "U_firstname = ?, " +
                         "U_lastname = ?, " +
                         "U_phone = ?, " +
                         "U_email = ?, " +
                         "U_birthdate = ? " +
                         "WHERE U_id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, phoneNumber);
            pst.setString(4, emailAddress);
            pst.setString(5, birthDate);
            pst.setString(6, id);

            int updated = pst.executeUpdate();

            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Member updated successfully!");
                this.dispose(); // close the edit window
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update member.");
            }

            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(editMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               String id = null;
                String firstname = null;
                String lastname = null;
                String phone = null;
                String email = null;
                String birthdate = null;

                new editMember(id, firstname, lastname, phone, email, birthdate).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField birth;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField phone;
    // End of variables declaration//GEN-END:variables
}
