package user_registration.usecase_engine.database_access;

import user_registration.usecase_engine.input.UserRegistrationInputData;

public interface UserRegistrationDsGateway {
    boolean firstNameExists(String identifier);
    boolean lastNameExists(String identifier);
    boolean userameExists(String identifier);
    void saveUserRegistration(UserRegistrationDsInputData registrationDsInputData);
}
