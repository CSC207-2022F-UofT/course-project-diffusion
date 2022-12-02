package user_registration.ports;

public interface UserRegistration {
    boolean firstNameIsValid();
    boolean lastNameIsValid();
    boolean userNameisValid();
    boolean passwordIsValid();
    String getFirstName();
    String getLastName();
    String getUsername();
    String getPassword();

}
