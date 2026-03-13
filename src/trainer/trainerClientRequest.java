package trainer;

import member.*;
import admin.*;
import config.Session;
import config.config;
import java.awt.Color;
import java.awt.Cursor;
import elitegym.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class trainerClientRequest extends javax.swing.JFrame {
   
    public trainerClientRequest(){
        Session session = Session.getInstance();
        if (!Session.getInstance().isLoggedIn()) {
        new login().setVisible(true);
        this.dispose();
        return;
    }
         
        initComponents();
        loadClientRequests();
        
        nav1.setOpaque(true);
        nav2.setOpaque(true);
        logout.setOpaque(true);
        logout.setOpaque(true);
 
        nav1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nav2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
  
    
    }
    
    public void loadClientRequests() {
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new String[]{
        "ID", "Member Name", "Service", "Date", "Status", "Type"
    });

    int trainerId = Session.getInstance().getUserId(); // Logged-in trainer ID
    System.out.println("Trainer ID from session: " + trainerId);

    String sql = "SELECT t.transaction_id AS id, " +
                 "m.U_firstname || ' ' || m.U_lastname AS member_name, " +
                 "gs.service_name, t.transaction_date AS date, t.status, 'Transaction' AS type " +
                 "FROM transactions t " +
                 "JOIN tbl_accounts m ON t.member_id = m.U_id " +
                 "JOIN gym_services gs ON t.service_id = gs.service_id " +
                 "WHERE t.trainer_id = ? AND t.status = 'Pending' " +
                 "ORDER BY t.transaction_date DESC";

    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, trainerId);
        ResultSet rs = pst.executeQuery();
        int count = 0;

        while (rs.next()) {
            count++;
            model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("member_name"),
                rs.getString("service_name"),
                rs.getString("date"),
                rs.getString("status"),
                rs.getString("type")
            });
        }

        System.out.println("Total entries loaded: " + count);
        ClientsRequest.setModel(model);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to load client requests: " + e.getMessage());
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
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nav5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClientsRequest = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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
        jLabel3.setText("Client Request");
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
        jLabel5.setText("Service Manager");
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

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dashboard.png"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 50, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Services.png"))); // NOI18N
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 50, 50));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashBlogo.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 30, 280, 150));

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

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Profile");
        nav5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.add(nav5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 170, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Proofile.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 405, 50, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 230, 700));

        jPanel1.setBackground(new java.awt.Color(255, 235, 150));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Trainer Dashboard");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 300, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 770, 60));

        jPanel4.setBackground(new java.awt.Color(255, 235, 150));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ClientsRequest.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ClientsRequest);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 750, 490));

        jButton1.setText("Accept");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        jButton2.setText("Deny");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, -1));

        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 770, 580));

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
        nav1.setBackground(new Color(30,30,30));
    }//GEN-LAST:event_nav1MouseExited

    private void nav1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav1MouseEntered
        nav1.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav1MouseEntered

    private void nav1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav1MouseClicked
   
    }//GEN-LAST:event_nav1MouseClicked

    private void nav2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav2MouseClicked
        
        trainerClientRequest pro = new trainerClientRequest();
        pro.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_nav2MouseClicked

    private void nav3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseClicked
        
        trainerServices ser = new trainerServices();
        ser.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_nav3MouseClicked
 
    private void nav3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseEntered
       nav3.setBackground(new Color (255, 249, 196));    }//GEN-LAST:event_nav3MouseEntered

    private void nav3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav3MouseExited
       nav3.setBackground(new Color(30,30,30));
    }//GEN-LAST:event_nav3MouseExited

    private void nav4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav4MouseClicked
       
    }//GEN-LAST:event_nav4MouseClicked

    private void nav4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav4MouseEntered
        nav4.setBackground(new Color (255, 249, 196));
    }//GEN-LAST:event_nav4MouseEntered

    private void nav4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav4MouseExited
        nav4.setBackground(new Color(30,30,30));
    }//GEN-LAST:event_nav4MouseExited

    private void nav5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav5MouseClicked
        trainerProfile pro = new trainerProfile();
        pro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nav5MouseClicked

    private void nav5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nav5MouseEntered

    private void nav5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_nav5MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
      int selectedRow = ClientsRequest.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a transaction to accept.");
        return;
    }

    String status = (String) ClientsRequest.getValueAt(selectedRow, 4); // Status column
    if (!status.equals("Pending")) {
        JOptionPane.showMessageDialog(this, "Only pending transactions can be accepted.");
        return;
    }

    int transactionId = (int) ClientsRequest.getValueAt(selectedRow, 0);
    String memberName = (String) ClientsRequest.getValueAt(selectedRow, 1);

    int confirm = JOptionPane.showConfirmDialog(this,
            "Accept this transaction for " + memberName + "?",
            "Confirm Accept", JOptionPane.YES_NO_OPTION);

    if (confirm != JOptionPane.YES_OPTION) return;

    try (Connection conn = config.connectDB()) {
        String sqlUpdate = "UPDATE transactions SET status = 'Pending Payment' WHERE transaction_id = ?";
        PreparedStatement pst = conn.prepareStatement(sqlUpdate);
        pst.setInt(1, transactionId);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Transaction approved successfully.");
        loadClientRequests(); // Refresh table

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating transaction: " + e.getMessage());
    }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        loadClientRequests(); // Simply reload the table
        JOptionPane.showMessageDialog(this, "Transactions refreshed.");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int selectedRow = ClientsRequest.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a transaction to deny.");
        return;
    }

    String status = (String) ClientsRequest.getValueAt(selectedRow, 4); // Status column
    if (!status.equals("Pending")) {
        JOptionPane.showMessageDialog(this, "Only pending transactions can be denied.");
        return;
    }

    int transactionId = (int) ClientsRequest.getValueAt(selectedRow, 0);
    String memberName = (String) ClientsRequest.getValueAt(selectedRow, 1);

    int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to deny this transaction for " + memberName + "?",
            "Confirm Deny", JOptionPane.YES_NO_OPTION);

    if (confirm != JOptionPane.YES_OPTION) return;

    try (Connection conn = config.connectDB()) {
        String sqlUpdate = "UPDATE transactions SET status = 'Denied' WHERE transaction_id = ?";
        PreparedStatement pst = conn.prepareStatement(sqlUpdate);
        pst.setInt(1, transactionId);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Transaction denied successfully.");
        loadClientRequests(); // Refresh table

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating transaction: " + e.getMessage());
    }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(trainerClientRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trainerClientRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trainerClientRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trainerClientRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trainerClientRequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ClientsRequest;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel nav1;
    private javax.swing.JPanel nav2;
    private javax.swing.JPanel nav3;
    private javax.swing.JPanel nav4;
    private javax.swing.JPanel nav5;
    // End of variables declaration//GEN-END:variables
}
