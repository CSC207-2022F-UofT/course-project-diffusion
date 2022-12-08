package user_registration.entity;

import user_registration.ports.UserRegistration;
import user_registration.ports.UserRegistrationGenerator;

public class CommonUserRegistrationFactory implements UserRegistrationGenerator {
    @Override
    public UserRegistration createUser(String firstName, String lastName, String username, String password) {
        return new CommonUserRegistration(firstName, lastName, username, password);
    }
}
