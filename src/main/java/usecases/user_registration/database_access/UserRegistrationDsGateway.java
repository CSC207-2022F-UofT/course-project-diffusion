package usecases.user_registration.database_access;

import usecases.user_registration.input.UserRegistrationInputData;

public interface UserRegistrationDsGateway {
    boolean firstNameExists(String identifier);
    boolean lastNameExists(String identifier);
    boolean userameExists(String identifier);
    void saveUserRegistration(UserRegistrationDsInputData registrationDsInputData);
}
