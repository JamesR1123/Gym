
package gymServices.crud;

import admin.gymServices;
import static config.config.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import trainer.trainerServices;


public class editServicesTrainer extends javax.swing.JFrame {

   
        private int serviceId;
        private trainerServices parent;
        
    public editServicesTrainer(int serviceId, trainerServices parent) {
        initComponents();
        this.serviceId = serviceId;
        this.parent = parent;
        loadServiceData();
    }

    // Load service data
    private void loadServiceData() {
        String sql = "SELECT service_name, description, duration, price FROM gym_services WHERE service_id = ?";
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, serviceId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                servicename.setText(rs.getString("service_name"));
                serviceDes.setText(rs.getString("description"));
                price.setText(rs.getString("price"));

                int totalMinutes = rs.getInt("duration");
                int hours = totalMinutes / 60;
                int minutes = totalMinutes % 60;
                String durationText = "";
                if (hours > 0) durationText += hours + " hour" + (hours > 1 ? "s " : " ");
                if (minutes > 0) durationText += minutes + " minute" + (minutes > 1 ? "s" : "");
                duration.setText(durationText.trim());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load service data: " + e.getMessage());
        }
    }

    private int parseDuration(String text) throws NumberFormatException {
    if (!isValidDuration(text)) {
        throw new NumberFormatException("Invalid format");
    }

    int totalMinutes = 0;
    text = text.toLowerCase().trim();
    String[] parts = text.split("\\s+");

    for (int i = 0; i < parts.length; i++) {
        if (parts[i].contains("hour")) {
            totalMinutes += Integer.parseInt(parts[i - 1]) * 60;
        } else if (parts[i].contains("minute")) {
            totalMinutes += Integer.parseInt(parts[i - 1]);
        }
    }

    return totalMinutes;
}
    
    private boolean isValidDuration(String text) {
    // Trim and normalize
    text = text.trim().toLowerCase();
    // Regex: start -> 1 or more digits -> 'hour' or 'hours' -> optional space and digits -> 'minute(s)' -> end
    String regex = "^(\\d+)\\s+hour(s)?(\\s+(\\d+)\\s+minute(s)?)?$";
    return text.matches(regex);
}

    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        servicename = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        duration = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        serviceDes = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setText("Edit Service ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 60));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Service Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));
        jPanel1.add(servicename, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 380, 40));

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Duration");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));
        jPanel1.add(duration, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 160, 40));

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Price");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 160, 40));

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Service Description");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        serviceDes.setColumns(20);
        serviceDes.setRows(5);
        jScrollPane1.setViewportView(serviceDes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 380, 160));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setText("Save Changes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 170, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 100, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String name = servicename.getText().trim();
        String desc = serviceDes.getText().trim();
        String priceStr = price.getText().trim();
        String durationText = duration.getText().trim();

        if (name.isEmpty() || desc.isEmpty() || priceStr.isEmpty() || durationText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        int totalMinutes;
        try {
            totalMinutes = parseDuration(durationText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Duration must be in correct format, e.g., '2 hours 30 minutes'.");
            return;
        }

    // Existing database update logic...

        try (Connection conn = connectDB()) {
            String sql = "UPDATE gym_services SET service_name = ?, description = ?, duration = ?, price = ? WHERE service_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, desc);
            pst.setInt(3, totalMinutes);
            pst.setString(4, priceStr);
            pst.setInt(5, serviceId);

            int updated = pst.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Service updated successfully!");
                if (parent != null) {
                    parent.loadTrainerServices();
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update service.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        this.dispose();
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

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
            java.util.logging.Logger.getLogger(editServicesTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editServicesTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editServicesTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editServicesTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             int exampleServiceId = 1;  // Replace with a real service ID from your DB
            gymServices parent = new gymServices(); // create or pass the parent table instance
            parent.setVisible(true); // optional, if you want parent visible
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField duration;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField price;
    private javax.swing.JTextArea serviceDes;
    private javax.swing.JTextField servicename;
    // End of variables declaration//GEN-END:variables
}
