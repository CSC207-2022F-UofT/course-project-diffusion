package user_registration.frameworks_and_drivers.database_generator;

import user_registration.use_case.database_access.UserRegistrationDsGateway;
import user_registration.use_case.database_access.UserRegistrationDsInputData;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements UserRegistrationDsGateway, allows for storing data in memory, useful for the tests.
 */

public class UserRegistrationInMemory implements UserRegistrationDsGateway {
    final private Map<String, UserRegistrationDsInputData> users = new HashMap<>();

    /**
     *
     * @param username the user's username
     * @return whether the user exists.
     */
    @Override
    public boolean usernameExists(String username) {
        return users.containsKey(username);
    }

    /**
     * Allows us to save the data in memory, useful for the testing.
     * @param registrationDsInputData the data we will save
     */
    @Override
    public void saveUserRegistration(UserRegistrationDsInputData registrationDsInputData) {
        users.put(registrationDsInputData.getUsername(), registrationDsInputData);

    }
}
