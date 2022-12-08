package user_registration.ports;

public interface UserRegistration {
    boolean firstNameIsValid();
    boolean lastNameIsValid();
    boolean userNameIsValid();
    boolean passwordIsValid();
    String getFirstName();
    String getLastName();
    String getUsername();
    String getPassword();

}
