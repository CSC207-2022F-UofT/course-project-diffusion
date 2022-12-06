package user_registration.use_case.database_access;

public interface UserRegistrationDsGateway {
    boolean firstNameExists(String identifier);
    boolean lastNameExists(String identifier);
    boolean usernameExists(String identifier);
    void saveUserRegistration(UserRegistrationDsInputData registrationDsInputData);
}
