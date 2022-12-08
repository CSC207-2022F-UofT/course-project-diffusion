package user_registration.entity;
import user_registration.ports.UserRegistration;


public class CommonUserRegistration implements UserRegistration {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;

    /**
     *
     * @param firstname of person registering
     * @param lastname of person registering
     * @param username of person registering
     * @param password a secret password of the person registering
     */

    CommonUserRegistration(String firstname, String lastname, String username, String password){
        this.firstName = firstname;
        this.lastName = lastname;
        this.username = username;
        this.password = password;
    }

    /**
     *Checks if the first name is only alphabetic characters.
     * @return boolean answer
     */
    @Override
    public boolean firstNameIsValid() {
        return firstName.matches("[a-zA-Z]+");
    }

    /**
     *checks if the last name is only alphabetic characters
     * @return boolean answer
     */
    @Override
    public boolean lastNameIsValid() {
        return lastName.matches("[a-zA-Z]+");
    }

    /**
     * Checks if the username is only alphabetic characters
     * @return boolean answer
     */
    @Override
    public boolean userNameIsValid() {
        return username.matches("[a-zA-Z]+");
    }

    /**
     * Check if the password meets the length requirements
     * @return boolean answer
     */
    @Override
    public boolean passwordIsValid() {
        return password != null && password.length() > 5;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }


    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}