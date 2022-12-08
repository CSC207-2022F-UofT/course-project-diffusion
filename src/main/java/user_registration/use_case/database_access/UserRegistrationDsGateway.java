package user_registration.use_case.database_access;

/**
 * Interface to access the database.
 */
public interface UserRegistrationDsGateway {
    boolean usernameExists(String identifier);
    void saveUserRegistration(UserRegistrationDsInputData registrationDsInputData);
}
