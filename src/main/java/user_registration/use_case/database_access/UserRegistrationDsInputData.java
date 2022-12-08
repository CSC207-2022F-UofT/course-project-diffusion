package user_registration.use_case.database_access;

import java.time.LocalDateTime;

/**
 * Generates Input Data Object.
 */
public class UserRegistrationDsInputData {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private Object locationName;
    private String role;
    private final LocalDateTime userRegistrationTime;

    /**
     *
     * @param firstname the first name
     * @param lastname the last name
     * @param username the username
     * @param password the password
     * @param locationName the name of the location assigned
     * @param role the users role
     * @param userRegistrationTime the times at which the user registered
     */
    public UserRegistrationDsInputData(String firstname, String lastname, String username, String password,
                                       Object locationName, String role, LocalDateTime userRegistrationTime) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.locationName = locationName;
        this.role = role;
        this.userRegistrationTime = userRegistrationTime;
    }

    public String getLocationName() {
        return locationName.toString();
    }

    public void setLocationName(Object locationName) {
        this.locationName = locationName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getUserRegistrationTime() {
        return userRegistrationTime;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
