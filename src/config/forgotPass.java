
package config;

import static config.config.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class forgotPass {
    
  public static boolean emailExists(String email) {
    String sql = "SELECT U_email FROM tbl_accounts WHERE U_email=?";
    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        return rs.next(); // true if exists
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        return false;
    }
}

    public static String getSecurityQuestion(String email) {
    String question = null;
    String sql = "SELECT security_question FROM tbl_accounts WHERE U_email=?";
    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            question = rs.getString("security_question");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
    }
    return question;
}

    public static boolean verifySecurityAnswer(String email, String answer) {
    String sql = "SELECT security_answer FROM tbl_accounts WHERE U_email=?";
    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String correctAnswer = rs.getString("security_answer");
            return correctAnswer.equalsIgnoreCase(answer.trim());
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
    }
    return false;
}

    public static boolean updatePassword(String email, String newPassword) {
    if (newPassword == null || newPassword.trim().length() < 6) {
        JOptionPane.showMessageDialog(null,
            "Password must be at least 6 characters",
            "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    String sql = "UPDATE tbl_accounts SET U_password=? WHERE U_email=?";
    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, newPassword);
        pst.setString(2, email);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Password updated successfully!");
        return true;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        return false;
    }
}
    
    
}
