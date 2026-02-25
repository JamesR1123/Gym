package admin;

import config.Session;
import config.config;
import java.awt.Color;
import java.awt.Cursor;
import elitegym.login;

public class profile extends javax.swing.JFrame {
   
public void loadLoggedInUserProfile() {
        
        // Get current session
        Session session = Session.getInstance();

        // Set full name and email from session
        fullname.setText(session.getFullName() != null && !session.getFullName().isEmpty()
                         ? session.getFullName()
                         : "N/A");
        email.setText(session.getEmail() != null && !session.getEmail().isEmpty()
                      ? session.getEmail()
                      : "N/A");

        // Load additional profile info from DB
        config conf = new config();
        String[] profileData = conf.getLoggedInUserProfile(session.getEmail());

        if (profileData != null && profileData.length >= 5) {
            // profileData[0] = first name
            // profileData[1] = last name
            // profileData[2] = email
            // profileData[3] = phone
            // profileData[4] = password

            // Phone number
            phonenum.setText(profileData[3] != null && !profileData[3].isEmpty()
                             ? profileData[3]
                             : "N/A");

            // Mask password manually (works in all Java versions)
            String password = profileData[4] != null ? profileData[4] : "";
            if (password.isEmpty()) {
                pass.setText("N/A");
            } else {
                StringBuilder masked = new StringBuilder();
                for (int i = 0; i < password.length(); i++) {
                    masked.append("*");
                }
                pass.setText(masked.toString());
            }

        } else {
            // Fallback if profile not loaded correctly
            phonenum.setText("N/A");
            pass.setText("********");
        }
}




    public profile(){
        
        if (!Session.getInstance().isLoggedIn()) {
        new login().setVisible(true);
        this.dispose();
        return;
    }
        initComponents();
        
        loadLoggedInUserProfile();
        nav1.setOpaque(true);
        nav2.setOpaque(true);
        logout.setOpaque(true);
        logout.setOpaque(true);
        
        nav1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nav2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
  
    
    }
    
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        nav1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nav6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        nav5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        nav2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nav3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nav4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fullname = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        phonenum = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(30, 30, 30));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nav1.setBackground(new java.awt.Color(30, 30, 30));
        nav1.setForeground(new java.awt.Color(255, 255, 255));
        nav1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav1MouseExited(evt);
            }
        });
        nav1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dashboard");
        nav1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.add(nav1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 170, 40));

        nav6.setBackground(new java.awt.Color(30, 30, 30));
        nav6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav6MouseExited(evt);
            }
        });
        nav6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Trainer");
        nav6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.add(nav6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 170, 40));

        nav5.setBackground(new java.awt.Color(30, 30, 30));
        nav5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav5MouseExited(evt);
            }
        });
        nav5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Member");
        nav5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.add(nav5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 170, 40));

        nav2.setBackground(new java.awt.Color(30, 30, 30));
        nav2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav2MouseExited(evt);
            }
        });
        nav2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Profile");
        nav2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.add(nav2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 170, 40));

        nav3.setBackground(new java.awt.Color(30, 30, 30));
        nav3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav3MouseExited(evt);
            }
        });
        nav3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Account Manager");
        nav3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.add(nav3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 170, 40));

        nav4.setBackground(new java.awt.Color(30, 30, 30));
        nav4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav4MouseExited(evt);
            }
        });
        nav4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gym Sevices");
        nav4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.add(nav4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 170, 40));

        logout.setBackground(new java.awt.Color(255, 255, 255));
        logout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Logout");
        logout.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jPanel2.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 190, 50));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dashboard.png"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 50, 50));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accountManager.png"))); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Services.png"))); // NOI18N
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 50, 50));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Proofile.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 50, 50));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Member.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 50, 50));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Trainer.png"))); // NOI18N
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 50, 50));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashBlogo.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 30, 280, 150));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 230, 700));

        jPanel1.setBackground(new java.awt.Color(255, 235, 150));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fullname.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fullname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullname.setText("name");
        jPanel1.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 536, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Email");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Personal Information");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        pass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        pass.setText("password");
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        email.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        email.setText("email");
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Phone Number");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        phonenum.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        phonenum.setText("phonenum");
        jPanel1.add(phonenum, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ppass.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 40, 30));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pemail.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 40, 30));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pphone.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 40, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(30, 30, 30));
        jLabel23.setText("+Edit");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(30, 30, 30));
        jLabel24.setText("+Edit");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(30, 30, 30));
        jLabel25.setText("+Edit");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 780, 580));

        jPanel3.setBackground(new java.awt.Color(255, 235, 150));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Admin Profile");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 300, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 780, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nav2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav2MouseEntered
        nav2.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav2MouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setBackground(new Color (240, 240, 240));
    }//GEN-LAST:event_logoutMouseExited

    private void nav2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav2MouseExited
        nav2.setBackground(new Color(30,30,30));
    }//GEN-LAST:event_nav2MouseExited

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logout.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        Session.getInstance().clearSession();
        login lan = new login();
        lan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void nav1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav1MouseExited
        nav1.setBackground(new Color(30, 30, 30));
    }//GEN-LAST:event_nav1MouseExited

    private void nav1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav1MouseEntered
        nav1.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav1MouseEntered

    private void nav1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav1MouseClicked
        dashboard db = new dashboard();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav1MouseClicked

    private void nav2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav2MouseClicked
      
      
    }//GEN-LAST:event_nav2MouseClicked

    private void nav3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseClicked
      accountmanager us = new accountmanager();
      us.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_nav3MouseClicked

    private void nav3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseEntered
        nav3.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav3MouseEntered

    private void nav3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseExited
        nav3.setBackground(new Color(30,30,30));
    }//GEN-LAST:event_nav3MouseExited

    private void nav4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav4MouseClicked
       gymServices gym = new gymServices();
       gym.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_nav4MouseClicked

    private void nav4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav4MouseEntered
        nav4.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav4MouseEntered

    private void nav4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav4MouseExited
        nav4.setBackground(new Color(30,30,30));
    }//GEN-LAST:event_nav4MouseExited

    private void nav5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav5MouseClicked
        memberMenu mi = new memberMenu();
        mi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav5MouseClicked

    private void nav5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav5MouseEntered
        nav5.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav5MouseEntered

    private void nav5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav5MouseExited
       nav5.setBackground(new Color(30,30,30));
    }//GEN-LAST:event_nav5MouseExited

    private void nav6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav6MouseClicked
        trainerMenu mi = new trainerMenu();
        mi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav6MouseClicked

    private void nav6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav6MouseEntered
        nav6.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav6MouseEntered

    private void nav6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav6MouseExited
        nav6.setBackground(new Color(30,30,30));
    }//GEN-LAST:event_nav6MouseExited

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email;
    private javax.swing.JLabel fullname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel nav1;
    private javax.swing.JPanel nav2;
    private javax.swing.JPanel nav3;
    private javax.swing.JPanel nav4;
    private javax.swing.JPanel nav5;
    private javax.swing.JPanel nav6;
    private javax.swing.JLabel pass;
    private javax.swing.JLabel phonenum;
    // End of variables declaration//GEN-END:variables
}
