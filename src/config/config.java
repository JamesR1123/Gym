    package config;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;
    import net.proteanit.sql.DbUtils;

    public class config {

        // ================= LOGGED-IN USER INFO =================
        public static String loggedInFirstName;
        public static String loggedInLastName;
        public static String loggedInEmail;
        public static String loggedInType;

        // ================= DATABASE CONNECTION =================
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

        // ================= GENERIC INSERT =================
        public void addRecord(String sql, Object... values) {
            try (Connection conn = connectDB();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                for (int i = 0; i < values.length; i++) {
                    pstmt.setObject(i + 1, values[i]);
                }

                pstmt.executeUpdate();
                System.out.println("Record added successfully!");
            } catch (SQLException e) {
                System.out.println("Error adding record: " + e.getMessage());
            }
        }

        // ================= DISPLAY DATA TO TABLE =================
        public void displayData(String sql, javax.swing.JTable table) {
            try (Connection conn = connectDB();
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (SQLException e) {
                System.out.println("Error displaying data: " + e.getMessage());
            }
        }

        // ================= LOGIN DETAILS =================
        public String[] getLoginDetails(String email, char[] passwordChars) {
            String password = String.valueOf(passwordChars);
            String[] details = new String[2]; // [0]=status, [1]=type

            String sql = "SELECT U_status, U_type FROM tbl_accounts WHERE U_email=? AND U_password=?";

            try (Connection conn = connectDB();
                 PreparedStatement pst = conn.prepareStatement(sql)) {

                pst.setString(1, email);
                pst.setString(2, password);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        details[0] = rs.getString("U_status");
                        details[1] = rs.getString("U_type");
                    }
                }

            } catch (SQLException e) {
                System.out.println("Error getting login details: " + e.getMessage());
            } finally {
                java.util.Arrays.fill(passwordChars, '\0');
            }

            return details;
        }

        // ================= SET LOGGED-IN USER =================
        public void setLoggedInUser(String email, char[] passwordChars) {
            String password = String.valueOf(passwordChars);

            String sql = "SELECT U_firstname, U_lastname, U_email, U_type FROM tbl_accounts WHERE U_email=? AND U_password=?";

            try (Connection conn = connectDB();
                 PreparedStatement pst = conn.prepareStatement(sql)) {

                pst.setString(1, email);
                pst.setString(2, password);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        loggedInFirstName = rs.getString("U_firstname");
                        loggedInLastName = rs.getString("U_lastname");
                        loggedInEmail = rs.getString("U_email");
                        loggedInType = rs.getString("U_type");
                    }
                }

            } catch (SQLException e) {
                System.out.println("Error setting logged-in user: " + e.getMessage());
            } finally {
                java.util.Arrays.fill(passwordChars, '\0');
            }
        }

        // ================= GET FULL NAME =================
        public static String getFullName() {
            if (loggedInFirstName == null && loggedInLastName == null) return "";
            return loggedInFirstName + " " + loggedInLastName;
        }

        // ================= MASTER LOGIN HANDLER =================
        public boolean handleLogin(String email, char[] passwordChars, javax.swing.JFrame currentFrame) {

            if (email.trim().isEmpty() || passwordChars.length == 0) {
                JOptionPane.showMessageDialog(null,
                        "Please fill in all fields",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String[] loginDetails = getLoginDetails(email, passwordChars);

            if (loginDetails[0] == null) {
                JOptionPane.showMessageDialog(null,
                        "Login failed! Incorrect email or password.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String status = loginDetails[0];
            String type = loginDetails[1];

            if (status.equalsIgnoreCase("Pending")) {
                JOptionPane.showMessageDialog(null,
                        "Your account is still pending approval. Please wait for admin confirmation.",
                        "Pending",
                        JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            if (status.equalsIgnoreCase("Approved")) {

                setLoggedInUser(email, passwordChars);

                JOptionPane.showMessageDialog(null,
                        "Login successful! Welcome " + getFullName(),
                        "Welcome",
                        JOptionPane.INFORMATION_MESSAGE);

                if (type.equalsIgnoreCase("Admin")) {
                    new admin.accountmanager().setVisible(true);
                } else if (type.equalsIgnoreCase("User")) {
                    new user.userprofile().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Unknown user type!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                currentFrame.dispose();
                return true;
            }

            JOptionPane.showMessageDialog(null,
                    "Unknown account status",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // ================= REGISTER =================
        public boolean validateRegister(
                String firstName,
                String lastName,
                String email,
                String phone,
                String birthdate,
                char[] passwordChars,
                char[] confirmChars,
                String gender
        ) {

            if (firstName.trim().isEmpty() || lastName.trim().isEmpty() || email.trim().isEmpty()
                    || phone.trim().isEmpty() || birthdate.trim().isEmpty()
                    || passwordChars.length == 0 || confirmChars.length == 0 || gender.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Please fill in all fields",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String password = String.valueOf(passwordChars);
            String confirm = String.valueOf(confirmChars);

            if (!password.equals(confirm)) {
                JOptionPane.showMessageDialog(null,
                        "Passwords do not match",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (password.length() < 6) {
                JOptionPane.showMessageDialog(null,
                        "Password must be at least 6 characters",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String sqlCheck = "SELECT * FROM tbl_accounts WHERE U_email=?";

            try (Connection conn = connectDB();
                 PreparedStatement psCheck = conn.prepareStatement(sqlCheck)) {

                psCheck.setString(1, email);
                ResultSet rs = psCheck.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null,
                            "Email already exists",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                String sqlInsert = "INSERT INTO tbl_accounts(U_firstname, U_lastname, U_email, U_phone, U_birthdate, U_gender, U_password, U_status, U_type) VALUES(?,?,?,?,?,?,?,?,?)";

                try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
                    psInsert.setString(1, firstName);
                    psInsert.setString(2, lastName);
                    psInsert.setString(3, email);
                    psInsert.setString(4, phone);
                    psInsert.setString(5, birthdate);
                    psInsert.setString(6, gender);
                    psInsert.setString(7, password);
                    psInsert.setString(8, "Pending");
                    psInsert.setString(9, "User");
                    psInsert.executeUpdate();
                    return true;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Database error: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            } finally {
                java.util.Arrays.fill(passwordChars, '\0');
                java.util.Arrays.fill(confirmChars, '\0');
            }
        }

        // ================= LOAD PROFILE =================
        public String[] getLoggedInUserProfile() {
            String[] profile = new String[4]; // first name, last name, email, type
            String sql = "SELECT U_firstname, U_lastname, U_email, U_type FROM tbl_accounts WHERE U_email = ?";

            try (Connection conn = connectDB();
                 PreparedStatement pst = conn.prepareStatement(sql)) {

                pst.setString(1, loggedInEmail);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        profile[0] = rs.getString("U_firstname");
                        profile[1] = rs.getString("U_lastname");
                        profile[2] = rs.getString("U_email");
                        profile[3] = rs.getString("U_type");
                    }
                }

            } catch (SQLException e) {
                System.out.println("Error loading user profile: " + e.getMessage());
            }

            return profile;
        }
        
            // ================= ADMIN ADD USER =================
    public boolean addUser(String firstName,
                           String lastName,
                           String email,
                           String phone,
                           String birthdate,
                           String gender,
                           String password,
                           String status,
                           String type) {

        String sql = "INSERT INTO tbl_accounts(U_firstname, U_lastname, U_email, U_phone, U_birthdate, U_gender, U_password, U_status, U_type) VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, email);
            pst.setString(4, phone);
            pst.setString(5, birthdate);
            pst.setString(6, gender);
            pst.setString(7, password);
            pst.setString(8, status);
            pst.setString(9, type);

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
            return false;
        }
    }


    // ================= ADMIN UPDATE USER =================
    public boolean updateUser(String email,
                              String firstName,
                              String lastName,
                              String phone,
                              String birthdate,
                              String gender,
                              String status,
                              String type) {

        String sql = "UPDATE tbl_accounts SET U_firstname=?, U_lastname=?, U_phone=?, U_birthdate=?, U_gender=?, U_status=?, U_type=? WHERE U_email=?";

        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, phone);
            pst.setString(4, birthdate);
            pst.setString(5, gender);
            pst.setString(6, status);
            pst.setString(7, type);
            pst.setString(8, email);

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
            return false;
        }
    }


    // ================= ADMIN DELETE USER =================
    public boolean deleteUser(String email) {

        String sql = "DELETE FROM tbl_accounts WHERE U_email=?";

        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, email);
            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
            return false;
        }
    }


    // ================= GET ALL USERS (FOR JTABLE) =================
    public void getAllUsers(javax.swing.JTable table) {

        String sql = "SELECT U_firstname AS 'First Name', " +
                     "U_lastname AS 'Last Name', " +
                     "U_email AS 'Email', " +
                     "U_phone AS 'Phone', " +
                     "U_birthdate AS 'Birthdate', " +
                     "U_gender AS 'Gender', " +
                     "U_status AS 'Status', " +
                     "U_type AS 'Type' " +
                     "FROM tbl_accounts";

        displayData(sql, table);
    }

    // ===== UPDATE TYPE + STATUS ONLY =====
public boolean updateUserByEmail(String email, String type, String status) {

    String sql = "UPDATE tbl_accounts SET U_type=?, U_status=? WHERE U_email=?";

    try (Connection conn = connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, type);
        pst.setString(2, status);
        pst.setString(3, email);

        pst.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Error updating user: " + e.getMessage());
        return false;
    }
}

    }
