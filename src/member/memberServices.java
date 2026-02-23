package member;

import admin.*;
import config.Services;
import config.Session;
import config.Transactions;
import config.config;
import java.awt.Color;
import java.awt.Cursor;
import elitegym.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class memberServices extends javax.swing.JFrame {
   
    public memberServices(){
        
        if (!Session.getInstance().isLoggedIn()) {
        new login().setVisible(true);
        this.dispose();
        return;
    }
       

        initComponents();
        
        serviceTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {},
        new String [] {
        "Service ID", "Service Name", "Category", "Duration", "Price"
        }
    ));
        Services services = new Services();
        services.loadActiveServices(serviceTable);
        
        nav1.setOpaque(true);
        nav2.setOpaque(true);
        logout.setOpaque(true);
        logout.setOpaque(true);
 
        nav1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nav2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }

    public void loadServices() {
    String sql = "SELECT * FROM services"; // or gym_services if that's your table

    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("service_id"),
                rs.getString("service_name"),
                rs.getString("category"),
                rs.getString("duration"),
                rs.getDouble("price")
            });
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
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
        nav4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        serviceTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

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

        jPanel2.add(nav2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 170, 40));

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
        jLabel5.setText("Services");
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

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("My Transaction");
        nav4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.add(nav4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 170, 40));

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

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashB.png"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 30, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrator.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 30, 40));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/servicesG.png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 30, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 30, 40));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashBlogo.png"))); // NOI18N
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 30, 280, 150));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 230, 700));

        jPanel1.setBackground(new java.awt.Color(255, 235, 150));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Services");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 300, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 770, 60));

        jPanel3.setBackground(new java.awt.Color(255, 235, 150));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        serviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(serviceTable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 750, 520));

        jButton1.setText("Avail");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 770, 600));

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
        nav1.setBackground(new Color (30,30,30));
    }//GEN-LAST:event_nav1MouseExited

    private void nav1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav1MouseEntered
        nav1.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav1MouseEntered

    private void nav1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav1MouseClicked
        memberDashB mem = new memberDashB();
        mem.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav1MouseClicked

    private void nav2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav2MouseClicked
        memberProfile me = new memberProfile();
        me.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav2MouseClicked

    private void nav3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseClicked
       
    }//GEN-LAST:event_nav3MouseClicked
 
    private void nav3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseEntered
       nav3.setBackground(new Color (255, 249, 196));    }//GEN-LAST:event_nav3MouseEntered

    private void nav3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseExited
       nav3.setBackground(new Color(30,30,30));
    }//GEN-LAST:event_nav3MouseExited

    private void nav4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav4MouseClicked
        memberTransaction mo = new memberTransaction();
        mo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav4MouseClicked

    private void nav4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav4MouseEntered
        nav4.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav4MouseEntered

    private void nav4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav4MouseExited
        nav4.setBackground(new Color (30,30,30));
    }//GEN-LAST:event_nav4MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int row = serviceTable.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(null, "Select a service first!");
        return;
    }

    int serviceId = Integer.parseInt(serviceTable.getValueAt(row, 0).toString());
    String serviceName = serviceTable.getValueAt(row, 1).toString();
    double price = Double.parseDouble(serviceTable.getValueAt(row, 4).toString());

    Transactions t = new Transactions();

    boolean success = t.createTransaction(
            Session.getInstance().getEmail(),
            serviceId,
            serviceName,
            price
    );

    if (success) {
        JOptionPane.showMessageDialog(null, "Transaction Created!");
        Services services = new Services();
        services.loadActiveServices(serviceTable);
    } else {
        JOptionPane.showMessageDialog(null, "Failed to create transaction.");
    }    
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(memberServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(memberServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(memberServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(memberServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new memberServices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel nav1;
    private javax.swing.JPanel nav2;
    private javax.swing.JPanel nav3;
    private javax.swing.JPanel nav4;
    private javax.swing.JTable serviceTable;
    // End of variables declaration//GEN-END:variables
}
