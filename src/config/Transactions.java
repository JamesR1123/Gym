package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Transactions {

    // ---------------- CREATE ----------------
   public boolean createTransaction(int memberId, int serviceId, String serviceName, double amount) {
    String sql = "INSERT INTO transactions(member_id, service_id, service_name, amount, status, transaction_date) " +
              "VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";

    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, memberId);
        pst.setInt(2, serviceId);
        pst.setString(3, serviceName);
        pst.setDouble(4, amount);
        pst.setString(5, "Pending");

        pst.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Error creating transaction: " + e.getMessage());
        return false;
    }
}


    // ---------------- READ ----------------
    // Load only transactions for the logged-in user
   public void loadMyTransactions(int memberId, JTable table) {
    String sql = "SELECT t.transaction_id, " +
                 "COALESCE(a.U_firstname || ' ' || a.U_lastname, 'No Trainer') AS trainer_name, " +
                 "t.service_name, t.amount, t.status, t.transaction_date " +
                 "FROM transactions t " +
                 "LEFT JOIN gym_services gs ON t.service_id = gs.service_id " +
                 "LEFT JOIN tbl_accounts a ON gs.trainer_id = a.U_id " +
                 "WHERE t.member_id = ? " +
                 "ORDER BY t.transaction_date DESC";

    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, memberId);
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = new DefaultTableModel(
        new String[]{"Transaction ID", "Trainer", "Service", "Amount", "Status", "Date"}, 0
        );
        table.setModel(model);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("transaction_id"),
                rs.getString("trainer_name"),
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
    public boolean updateTransactionAmount(int transactionId, int memberId, double newAmount) {
    String sql = "UPDATE transactions SET amount=? WHERE transaction_id=? AND member_id=?";

    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setDouble(1, newAmount);
        pst.setInt(2, transactionId);
        pst.setInt(3, memberId);

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
    public boolean deleteTransaction(int transactionId, int memberId) {
    String sql = "DELETE FROM transactions WHERE transaction_id=? AND member_id=? AND status='Pending'";

    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, transactionId);
        pst.setInt(2, memberId);

        int deleted = pst.executeUpdate();
        return deleted > 0;

    } catch (SQLException e) {
        System.out.println("Error deleting transaction: " + e.getMessage());
        return false;
    }
}
}
