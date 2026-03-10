package config;

public class Session {
    private static Session instance;

    private int userId;
    private String userType;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private Session() {}

    public static synchronized Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    // Getters & Setters for personal info (keep using getFirstName(), etc.)
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // Convenience method
    public String getFullName() {
        String f = firstName != null ? firstName : "";
        String l = lastName != null ? lastName : "";
        return (f + " " + l).trim();
    }

    // Is logged in?
    public boolean isLoggedIn() {
        return userId != 0; // relies on actual ID
    }

    // Set all session info at once (after login)
    public void setUser(int id, String type, String firstName, String lastName, String email) {
        this.userId = id;
        this.userType = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Clear session
    public void clearSession() {
        userId = 0;
        userType = null;
        firstName = null;
        lastName = null;
        email = null;
        phoneNumber = null;
    }
}
