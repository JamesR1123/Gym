package config;

import static config.config.connectDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import config.config;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Services {
    
    public boolean addService(String name, String description, String duration, double price, String status) {

    String sql = "INSERT INTO gym_services(service_name, description, duration, price, status) VALUES(?,?,?,?,?)";

    try (Connection conn = connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, name);
        pst.setString(2, description);
        pst.setString(3, duration);
        pst.setDouble(4, price);
        pst.setString(5, status);

        pst.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Error adding service: " + e.getMessage());
        return false;
    }
}

    public void searchService(String keyword, JTable table) {
        String sql = "SELECT * FROM gym_services WHERE service_name LIKE ? OR description LIKE ?";
        
        try (Connection conn = config.connectDB();
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
    
public boolean updateService(int id, String name, String description, String duration, double price, String status) {
    String sql = "UPDATE gym_services SET service_name=?, description=?, duration=?, price=?, status=? WHERE service_id=?";
    try (Connection conn = connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, name);
        pst.setString(2, description);
        pst.setString(3, duration);
        pst.setDouble(4, price);
        pst.setString(5, status);
        pst.setInt(6, id);

        pst.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Error updating service: " + e.getMessage());
        return false;
    }
}

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

}
