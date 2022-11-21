package ports.use_case_and_entities;

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
