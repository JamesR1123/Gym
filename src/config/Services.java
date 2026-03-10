package config;

import static config.config.connectDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Services {

    // Add a new service
    public boolean addService(String name, String description, String duration, String priceStr, int trainerId) {
        double price = 0;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format: " + e.getMessage());
            return false;
        }

        // Updated column name: trainer_id
        String sql = "INSERT INTO gym_services(service_name, description, duration, price, trainer_id, status) " +
                     "VALUES(?,?,?,?,?,?)";

        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, name);
            pst.setString(2, description);
            pst.setString(3, duration);
            pst.setDouble(4, price);
            pst.setInt(5, trainerId);
            pst.setString(6, "Active");

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error adding service: " + e.getMessage());
            return false;
        }
    }

    // Search services
    public void searchService(String keyword, JTable table) {
        String sql = "SELECT * FROM gym_services WHERE service_name LIKE ? OR description LIKE ?";

        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            String searchPattern = "%" + keyword + "%";
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);

            try (ResultSet rs = pst.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // clear table before adding

                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("service_id"),
                        rs.getString("service_name"),
                        rs.getString("description"),
                        rs.getString("duration"),
                        rs.getDouble("price"),
                        rs.getString("status")
                    });
                }
            }

        } catch (SQLException e) {
            System.out.println("Error searching service: " + e.getMessage());
        }
    }

    // Update status (Active / Inactive)
    public boolean updateServiceStatus(int id, String newStatus) {
        String sql = "UPDATE gym_services SET status=? WHERE service_id=?";
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, newStatus);
            pst.setInt(2, id);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete service
    public boolean deleteService(int id) {
        String sql = "DELETE FROM gym_services WHERE service_id=?";
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error deleting service: " + e.getMessage());
            return false;
        }
    }

    // Load active services (for admin or general display)
    public void loadActiveServices(JTable table) {
        String sql = "SELECT service_id, service_name, description, duration, price " +
                     "FROM gym_services WHERE status='Active'";

        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("service_id"),
                    rs.getString("service_name"),
                    rs.getString("description"),
                    rs.getString("duration"),
                    rs.getDouble("price")
                });
            }

        } catch (SQLException e) {
            System.out.println("Error loading services: " + e.getMessage());
        }
    }
}
