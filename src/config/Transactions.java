package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Transactions {

    // ---------------- CREATE ----------------
    public boolean createTransaction(String userEmail, int serviceId, String serviceName, double amount) {
        String sql = "INSERT INTO transactions(user_email, service_id, service_name, amount, status) VALUES(?,?,?,?,?)";

        try (Connection conn = config.connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, userEmail);
            pst.setInt(2, serviceId);
            pst.setString(3, serviceName);
            pst.setDouble(4, amount);
            pst.setString(5, "Pending"); // default status

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error creating transaction: " + e.getMessage());
            return false;
        }
    }

    // ---------------- READ ----------------
    // Load only transactions for the logged-in user
    public void loadMyTransactions(String email, JTable table) {
        String sql = "SELECT transaction_id, service_name, amount, status, transaction_date " +
                     "FROM transactions WHERE user_email=? ORDER BY transaction_date DESC";

        try (Connection conn = config.connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("transaction_id"),
                    rs.getString("service_name"),
                    rs.getDouble("amount"),
                    rs.getString("status"),
                    rs.getString("transaction_date")
                });
            }

        } catch (SQLException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }
    }

    // ---------------- UPDATE ----------------
    // Only update the amount or status if needed, NOT service_name
    public boolean updateTransactionAmount(int transactionId, String userEmail, double newAmount) {
        String sql = "UPDATE transactions SET amount=? WHERE transaction_id=? AND user_email=?";

        try (Connection conn = config.connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setDouble(1, newAmount);
            pst.setInt(2, transactionId);
            pst.setString(3, userEmail);

            int updated = pst.executeUpdate();
            return updated > 0;

        } catch (SQLException e) {
            System.out.println("Error updating transaction: " + e.getMessage());
            return false;
        }
    }

    // Optionally update status (e.g., admin approves transaction)
    public boolean updateTransactionStatus(int transactionId, String newStatus) {
        String sql = "UPDATE transactions SET status=? WHERE transaction_id=?";

        try (Connection conn = config.connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, newStatus);
            pst.setInt(2, transactionId);

            int updated = pst.executeUpdate();
            return updated > 0;

        } catch (SQLException e) {
            System.out.println("Error updating transaction status: " + e.getMessage());
            return false;
        }
    }

    // ---------------- DELETE ----------------
    // Only delete transactions for the logged-in user
    public boolean deleteTransaction(int transactionId, String userEmail) {
        String sql = "DELETE FROM transactions WHERE transaction_id=? AND user_email=? AND status='Pending'";

        try (Connection conn = config.connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, transactionId);
            pst.setString(2, userEmail);

            int deleted = pst.executeUpdate();
            return deleted > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting transaction: " + e.getMessage());
            return false;
        }
    }
}
