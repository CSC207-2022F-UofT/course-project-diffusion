package user_registration.use_case.input;

/**
 * Packages the input data as a plain old java object, does not know about the other classes therefore is not bound.
 */
public class UserRegistrationInputData {
    private final String firstName;
    private final String lastName;
    private String username;
    private String password;
    private final Object locationName;
    private String role;

    /**
     *
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param username the username of the user
     * @param password the password of the user
     * @param locationName the name of the location the user is assigned to
     * @param role the role the user has
     */

    public UserRegistrationInputData(String firstName, String lastName, String username, String password,
                                     Object locationName, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.locationName = locationName;
        this.role = role;
    }

    public Object getLocationName() {
        return locationName;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserame() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
