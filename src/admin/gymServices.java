package admin;

import config.Session;
import config.config;
import java.awt.Color;
import java.awt.Cursor;
import elitegym.login;

public class gymServices extends javax.swing.JFrame {
   
    public gymServices(){
        
        if (!Session.getInstance().isLoggedIn()) {
        new login().setVisible(true);
        this.dispose();
        return;
    }
        initComponents();
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
        nav2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nav3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

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
        nav1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(nav1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 120, 40));

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

        jPanel2.add(nav2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 150, 40));

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
        nav3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(nav3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 150, 40));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 700));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 770, 670));

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
        nav1.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_nav1MouseExited

    private void nav1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav1MouseEntered
        nav1.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav1MouseEntered

    private void nav1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav1MouseClicked
        gymServices db = new gymServices();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav1MouseClicked

    private void nav2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav2MouseClicked
        profile us = new profile();
        us.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav2MouseClicked

    private void nav3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseClicked
       accountmanager user = new accountmanager();
       user.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_nav3MouseClicked
 
    private void nav3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseEntered
       nav3.setBackground(new Color (255, 249, 196));    }//GEN-LAST:event_nav3MouseEntered

    private void nav3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseExited
       nav3.setBackground(new Color(30,30,30));
    }//GEN-LAST:event_nav3MouseExited

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gymServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gymServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gymServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gymServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gymServices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel nav1;
    private javax.swing.JPanel nav2;
    private javax.swing.JPanel nav3;
    // End of variables declaration//GEN-END:variables
}
