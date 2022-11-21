package usecases.user_registration.database_access;

public interface UserRegistrationDsGateway {
    boolean firstNameExists(String identifier);
    boolean lastNameExists(String identifier);
    boolean userameExists(String identifier);
    void saveUserRegistration(UserRegistrationInputData registrationDsInputData);
}
