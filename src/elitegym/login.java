package elitegym;


import config.config;
import javax.swing.JOptionPane;
import admin.accountmanager;
import config.Session;
import forgotPassword.enterEmail;
import member.memberProfile;


public class login extends javax.swing.JFrame {

    
    public login() {
        initComponents();
        ps.setEchoChar('*');
        showPass.setVisible(true);
        hidePass.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        showPass = new javax.swing.JLabel();
        hidePass = new javax.swing.JLabel();
        ps = new javax.swing.JPasswordField();
        forgotPass = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        register = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(30, 30, 30));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel2.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 240, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        showPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view.png"))); // NOI18N
        showPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPassMouseClicked(evt);
            }
        });
        jPanel2.add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 20, 30));

        hidePass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hidePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hide-gray.png"))); // NOI18N
        hidePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidePassMouseClicked(evt);
            }
        });
        jPanel2.add(hidePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 20, 30));

        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        jPanel2.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 240, 30));

        forgotPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        forgotPass.setForeground(new java.awt.Color(0, 153, 255));
        forgotPass.setText("Forgot password?");
        forgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPassMouseClicked(evt);
            }
        });
        jPanel2.add(forgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setText("Login");
        jButton1.setToolTipText("");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 240, 40));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setAutoscrolls(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, 10));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, 30));

        register.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("Dont have an account? Register Here.");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });
        jPanel2.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 235, 150));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finallogo.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(148, 161));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 140, 550, 260));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 490));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 40, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // 1. Get email and password
    String email = em.getText().trim();
    String password = new String(ps.getPassword());

    // 2. Check empty fields
    if (email.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please fill in all fields",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    // 3. Check login details
    config con = new config();
    String[] loginDetails = con.getLoginDetails(email, password);
    String status = loginDetails[0];
    String type = loginDetails[1];

    if (status == null || type == null) {
        JOptionPane.showMessageDialog(this,
                "Login failed! Incorrect email or password.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    // 4. Handle Pending Accounts
    if (status.equalsIgnoreCase("Pending")) {
        JOptionPane.showMessageDialog(this,
                "Your account is still pending approval. Please wait for admin confirmation.",
                "Pending",
                JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // 5. Approved Accounts
    if (status.equalsIgnoreCase("Approved")) {
        // 5a. Set logged-in user in config
        con.setLoggedInUser(email, password);

        // 5b. Set session
        Session session = Session.getInstance();
        session.setEmail(config.loggedInEmail != null ? config.loggedInEmail : email);
        session.setType(config.loggedInType != null ? config.loggedInType : type);
        session.setFirstName(config.loggedInFirstName != null ? config.loggedInFirstName : "");
        session.setLastName(config.loggedInLastName != null ? config.loggedInLastName : "");

        // 5c. Show welcome message
        JOptionPane.showMessageDialog(this,
                "Login successful! Welcome " + session.getFullName(),
                "Welcome",
                JOptionPane.INFORMATION_MESSAGE);

        // 5d. Redirect based on type
        if (type.equalsIgnoreCase("Admin")) {
            new admin.dashboard().setVisible(true);
        } else if (type.equalsIgnoreCase("Member")) {
            new member.memberDashB().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Unknown user type!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Close login form
        this.dispose();
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        register reg = new register();
        reg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerMouseClicked

    private void showPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPassMouseClicked
        ps.setEchoChar((char) 0);  // show password
        showPass.setVisible(false);
        hidePass.setVisible(true);
    }//GEN-LAST:event_showPassMouseClicked

    private void hidePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePassMouseClicked
        ps.setEchoChar('*');  // hide password again
        showPass.setVisible(true);
        hidePass.setVisible(false);
    }//GEN-LAST:event_hidePassMouseClicked

    private void forgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPassMouseClicked
        enterEmail mai = new enterEmail();
        mai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_forgotPassMouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField em;
    private javax.swing.JLabel forgotPass;
    private javax.swing.JLabel hidePass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField ps;
    private javax.swing.JLabel register;
    private javax.swing.JLabel showPass;
    // End of variables declaration//GEN-END:variables
}
