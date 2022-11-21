package usecases.user_registration.database_access;

import java.time.LocalDateTime;

public class UserRegistrationInputData {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private final LocalDateTime userRegistrationTime;

    public UserRegistrationInputData(String firstname, String lastname, String username, String password,
                                     LocalDateTime userRegistrationTime) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.userRegistrationTime = userRegistrationTime;
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
