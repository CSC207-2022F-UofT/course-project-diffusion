package entities.common_user_registration;

import ports.use_case_and_entities.UserRegistration;

public class CommonUserRegistration implements UserRegistration {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;

    CommonUserRegistration(String firstname, String lastname, String username, String password){
        this.firstName = firstname;
        this.lastName = lastname;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean firstNameIsValid() {
        return firstName.matches("[a-zA-Z]+");
    }

    @Override
    public boolean lastNameIsValid() {
        return lastName.matches("[a-zA-Z]+");
    }

    @Override
    public boolean userNameisValid() {
        return username.matches("[a-zA-Z]+");
    }

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
        return firstName;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
