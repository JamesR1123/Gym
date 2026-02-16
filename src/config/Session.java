
package config;

public class Session {
    // Single instance
    private static Session instance;

    // User information stored in session
    private String firstName;
    private String lastName;
    private String email;
    private String type; // Admin or User

    // Private constructor
    private Session() {}

    // Get the singleton instance
    public static synchronized Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    // Convenience: Full name
    public String getFullName() {
    String f = firstName != null ? firstName : "";
    String l = lastName != null ? lastName : "";
    return (f + " " + l).trim();
}

    // Clear session on logout
    public void clearSession() {
        firstName = null;
        lastName = null;
        email = null;
        type = null;
    }
    
    public boolean isLoggedIn() {
    return email != null;
}

}
