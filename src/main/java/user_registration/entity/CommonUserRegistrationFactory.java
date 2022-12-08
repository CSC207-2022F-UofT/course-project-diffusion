package user_registration.entity;

import user_registration.ports.UserRegistration;
import user_registration.ports.UserRegistrationGenerator;

/**
 * Implements creatUser method to generate the user
 */

public class CommonUserRegistrationFactory implements UserRegistrationGenerator {
    /**
     *
     * @param firstName the first name
     * @param lastName the last name
     * @param username the username
     * @param password teh password
     * @return a object of type CommonUserRegistration
     */
    @Override
    public UserRegistration createUser(String firstName, String lastName, String username, String password) {
        return new CommonUserRegistration(firstName, lastName, username, password);
    }
}
