package entities.common_user_registration;

import ports.use_case_and_entities.UserRegistration;
import ports.use_case_and_entities.UserRegistrationGenerator;

public class CommonUserRegistrationFactory implements UserRegistrationGenerator {
    @Override
    public UserRegistration createUser(String firstName, String lastName, String username, String password) {
        return new CommonUserRegistration(firstName, lastName, username, password);
    }
}
