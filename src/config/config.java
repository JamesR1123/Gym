package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class config {

    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:gym.db");
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

    public void addRecord(String sql, Object... values) {
        try (Connection conn = this.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                if (values[i] instanceof Integer) {
                    pstmt.setInt(i + 1, (Integer) values[i]);
                } else if (values[i] instanceof Double) {
                    pstmt.setDouble(i + 1, (Double) values[i]);
                } else if (values[i] instanceof Float) {
                    pstmt.setFloat(i + 1, (Float) values[i]);
                } else if (values[i] instanceof Long) {
                    pstmt.setLong(i + 1, (Long) values[i]);
                } else if (values[i] instanceof Boolean) {
                    pstmt.setBoolean(i + 1, (Boolean) values[i]);
                } else if (values[i] instanceof java.util.Date) {
                    pstmt.setDate(i + 1, new java.sql.Date(((java.util.Date) values[i]).getTime()));
                } else if (values[i] instanceof java.sql.Date) {
                    pstmt.setDate(i + 1, (java.sql.Date) values[i]);
                } else if (values[i] instanceof java.sql.Timestamp) {
                    pstmt.setTimestamp(i + 1, (java.sql.Timestamp) values[i]);
                } else {
                    pstmt.setString(i + 1, values[i].toString());
                }
            }

            pstmt.executeUpdate();
            System.out.println("Record added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding record: " + e.getMessage());
        }
    }

    public boolean authenticate(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Login Error: " + e.getMessage());
        }
        return false;
    }

    public void displayData(String sql, javax.swing.JTable table) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            System.out.println("Error displaying data: " + e.getMessage());
        }
    }

    // Validate login with message for pending accounts
    public boolean validateLogin(String email, String password) {
        if (email.trim().isEmpty() || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String status = checkLoginStatus(email, password);

        if (status == null) {
            JOptionPane.showMessageDialog(null, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (status.equalsIgnoreCase("Pending")) {
            JOptionPane.showMessageDialog(null, "Your account is pending approval", "Pending", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (status.equalsIgnoreCase("Approved")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Unknown account status", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Check login status
    public String checkLoginStatus(String email, String password) {
    String status = null;
    String sql = "SELECT U_status FROM tbl_accounts WHERE U_email=? AND U_password=?";
    try (Connection conn = connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, email);
        pst.setString(2, password);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                status = rs.getString("U_status"); 
            }
        }
    } catch (SQLException e) {
        System.out.println("Error checking login status: " + e.getMessage());
    }
    return status;
}

    // Validate registration
    public boolean validateRegister(String fullname, String email, String password, String confirm) {
        if (fullname.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty() || confirm.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.length() < 6) {
            JOptionPane.showMessageDialog(null, "Password must be at least 6 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if email already exists
        String sqlCheck = "SELECT * FROM tbl_accounts WHERE U_email=?";
        try (Connection conn = connectDB();
             PreparedStatement psCheck = conn.prepareStatement(sqlCheck)) {

            psCheck.setString(1, email);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Email already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Insert new user
            String sqlInsert = "INSERT INTO tbl_accounts(U_fullname,U_email,U_password,U_status) VALUES(?,?,?,?)";
            try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
                psInsert.setString(1, fullname);
                psInsert.setString(2, email);
                psInsert.setString(3, password);
                psInsert.setString(4, "Pending"); 
                psInsert.executeUpdate();
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public String[] getLoginDetails(String email, String password) {
    String[] details = new String[2]; // [0] = status, [1] = type
    String sql = "SELECT U_status, U_type FROM tbl_accounts WHERE U_email=? AND U_password=?";
    try (Connection conn = connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, email);
        pst.setString(2, password);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                details[0] = rs.getString("U_status"); // Pending / Approved
                details[1] = rs.getString("U_type");   // Admin / User
            }
        }
    } catch (SQLException e) {
        System.out.println("Error getting login details: " + e.getMessage());
    }
    return details;
}

}
