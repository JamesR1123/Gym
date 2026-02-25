
package admin.crud;

import config.config;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class addTrainer extends javax.swing.JFrame {

    private ButtonGroup genderGroup;
    
    public addTrainer() {
        initComponents();
        
        // Birthdate auto-format
        birthdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
            formatBirthdate();
            }
        });

        // Hide passwords by default
        pass.setEchoChar('*');
        cpass.setEchoChar('*');

        showPass.setVisible(true);
        hidePass.setVisible(false);

        cshowPass.setVisible(true);
        chidePass.setVisible(false);

        // Gender group
        genderGroup = new ButtonGroup();
        genderGroup.add(jRadioButton1);
        genderGroup.add(jRadioButton2);

        // Default gender selection
        jRadioButton1.setSelected(true);
    }
    

    private void formatBirthdate() {
        

        String text = birthdate.getText().replaceAll("[^0-9]", "");
        
        if (text.length() > 8) {
        text = text.substring(0, 8);
        }

        StringBuilder sb = new StringBuilder();

        if (text.length() > 0) {
            sb.append(text.substring(0, Math.min(4, text.length())));
        }

        if (text.length() >= 5) {
            sb.append("/");
            sb.append(text.substring(4, Math.min(6, text.length())));
        }

        if (text.length() >= 7) {
            sb.append("/");
            sb.append(text.substring(6, Math.min(8, text.length())));
        }

        birthdate.setText(sb.toString());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        showPass = new javax.swing.JLabel();
        hidePass = new javax.swing.JLabel();
        cshowPass = new javax.swing.JLabel();
        chidePass = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        phonenumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        birthdate = new javax.swing.JTextField();
        cpass = new javax.swing.JPasswordField();
        pass = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 480));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setText("Add Trainer");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 60));

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Sex");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        showPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye-gray.png"))); // NOI18N
        showPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPassMouseClicked(evt);
            }
        });
        jPanel1.add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 50, 50));

        hidePass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hidePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blind-gray.png"))); // NOI18N
        hidePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidePassMouseClicked(evt);
            }
        });
        jPanel1.add(hidePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 50, 50));

        cshowPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cshowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye-gray.png"))); // NOI18N
        cshowPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cshowPassMouseClicked(evt);
            }
        });
        jPanel1.add(cshowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 50, 50));

        chidePass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chidePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blind-gray.png"))); // NOI18N
        chidePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chidePassMouseClicked(evt);
            }
        });
        jPanel1.add(chidePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 50, 50));

        lastname.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel1.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 200, 40));

        email.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 200, 40));

        firstname.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel1.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 200, 40));

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("First Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Last Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Birthdate (YYYY/MM/DD)");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        phonenumber.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        phonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonenumberActionPerformed(evt);
            }
        });
        jPanel1.add(phonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 200, 40));

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Confirm Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Email Address");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        birthdate.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        birthdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdateActionPerformed(evt);
            }
        });
        jPanel1.add(birthdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 200, 40));
        jPanel1.add(cpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 430, 50));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 430, 50));

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Phone Number");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Password");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setText("Sumbit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, 120, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 100, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 8, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPassMouseClicked
        pass.setEchoChar((char) 0);   // show password
        showPass.setVisible(false);
        hidePass.setVisible(true);
    }//GEN-LAST:event_showPassMouseClicked

    private void hidePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePassMouseClicked
        pass.setEchoChar('*');        // hide password
        showPass.setVisible(true);
        hidePass.setVisible(false);
    }//GEN-LAST:event_hidePassMouseClicked

    private void cshowPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cshowPassMouseClicked
        cpass.setEchoChar((char) 0);   // show confirm password
        cshowPass.setVisible(false);
        chidePass.setVisible(true);
    }//GEN-LAST:event_cshowPassMouseClicked

    private void chidePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chidePassMouseClicked
        cpass.setEchoChar('*');        // hide confirm password
        cshowPass.setVisible(true);
        chidePass.setVisible(false);
    }//GEN-LAST:event_chidePassMouseClicked

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void phonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonenumberActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void birthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String firstName = firstname.getText().trim();
        String lastName = lastname.getText().trim();
        String phoneNumber = phonenumber.getText().trim();
        String birth = birthdate.getText().trim();
        String emailAddress = email.getText().trim();
        String password = new String(pass.getPassword());
        String confirmPassword = new String(cpass.getPassword());

        if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()
                || birth.isEmpty() || emailAddress.isEmpty()
                || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return;
        }

        if (!isValidDate(birth)) {
            JOptionPane.showMessageDialog(this, "Invalid birthdate! Use YYYY/MM/DD");
            return;
        }

        String gender = jRadioButton1.isSelected() ? "Male" : "Female";

        config con = new config();

        // ✅ Admin adds trainer → auto Approved + Trainer
        boolean success = con.addUser(
                firstName,
                lastName,
                emailAddress,
                phoneNumber,
                birth,
                gender,
                password,
                "Approved",  // status
                "Trainer"    // type
        );

        if (success) {
            JOptionPane.showMessageDialog(this, "Trainer added successfully!");

            firstname.setText("");
            lastname.setText("");
            phonenumber.setText("");
            birthdate.setText("");
            email.setText("");
            pass.setText("");
            cpass.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add trainer!");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(addTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addTrainer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField birthdate;
    private javax.swing.JLabel chidePass;
    private javax.swing.JPasswordField cpass;
    private javax.swing.JLabel cshowPass;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel hidePass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField lastname;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField phonenumber;
    private javax.swing.JLabel showPass;
    // End of variables declaration//GEN-END:variables
}
