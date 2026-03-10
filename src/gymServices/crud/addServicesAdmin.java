
package gymServices.crud;

import config.Services;
import static config.config.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class addServicesAdmin extends javax.swing.JFrame {


    public addServicesAdmin() {
        initComponents();
        loadTrainers();
    }

private void loadTrainers() {
    
        trainerComboBox.removeAllItems();

        // Add a header-like placeholder at the top
        trainerComboBox.addItem("ID | Trainer Name");

        String sql = "SELECT U_id, U_firstname, U_lastname FROM tbl_accounts WHERE U_type='Trainer'";
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("U_id");
                String name = rs.getString("U_firstname") + " " + rs.getString("U_lastname");
                trainerComboBox.addItem(id + " - " + name);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load trainers: " + e.getMessage());
        }
}

private int parseDuration(String text) throws NumberFormatException {
    if (!isValidDuration(text)) {
        throw new NumberFormatException("Invalid duration format");
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
    text = text.trim().toLowerCase();
    String regex = "^(\\d+)\\s+hour(s)?(\\s+(\\d+)\\s+minute(s)?)?$";
    return text.matches(regex);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        price = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        serviceDes = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        servicename = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        duration = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        trainerComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 160, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setText("Add Service");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 60));

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Service Description");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        serviceDes.setColumns(20);
        serviceDes.setRows(5);
        jScrollPane1.setViewportView(serviceDes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 380, 160));

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Price");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));
        jPanel1.add(servicename, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 380, 40));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Assign Trainer");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));
        jPanel1.add(duration, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 160, 40));

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Duration");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 120, 40));
        jButton1.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 100, 70));

        trainerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Choose a Trainer)" }));
        jPanel1.add(trainerComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 380, 40));

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Service Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                      
        String selectedTrainer = (String) trainerComboBox.getSelectedItem();
    if (selectedTrainer == null || selectedTrainer.equals("ID | Trainer Name") || selectedTrainer.equals("(Choose a Trainer)")) {
        JOptionPane.showMessageDialog(this, "Please select a trainer for this service.");
        return;
    }

    int trainerId = Integer.parseInt(selectedTrainer.split(" - ")[0]);
    String name = servicename.getText().trim();
    String desc = serviceDes.getText().trim();
    String dur = duration.getText().trim();
    String priceStr = price.getText().trim();

    if (name.isEmpty() || desc.isEmpty() || dur.isEmpty() || priceStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }

    // Validate duration format
    if (!isValidDuration(dur)) {
        JOptionPane.showMessageDialog(this, "Duration must be in the format: 'X hour Y minutes', e.g., '1 hour 30 minutes'.");
        return;
    }

    // Optional: convert duration to minutes for database insertion
    int totalMinutes;
    try {
        totalMinutes = parseDuration(dur);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid duration. Please use format like '2 hours 15 minutes'.");
        return;
    }

    Services svc = new Services();
    if (svc.addService(name, desc, dur, priceStr, trainerId)) { // send totalMinutes instead of raw text
        JOptionPane.showMessageDialog(this, "Service added successfully!");
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to add service.");
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
            java.util.logging.Logger.getLogger(addServicesAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addServicesAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addServicesAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addServicesAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addServicesAdmin().setVisible(true);
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField price;
    private javax.swing.JTextArea serviceDes;
    private javax.swing.JTextField servicename;
    private javax.swing.JComboBox<String> trainerComboBox;
    // End of variables declaration//GEN-END:variables
}
