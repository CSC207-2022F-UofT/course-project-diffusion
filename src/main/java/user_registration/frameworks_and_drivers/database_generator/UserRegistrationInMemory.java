package user_registration.frameworks_and_drivers.database_generator;

import user_registration.use_case.database_access.UserRegistrationDsGateway;
import user_registration.use_case.database_access.UserRegistrationDsInputData;

import java.util.HashMap;
import java.util.Map;

public class UserRegistrationInMemory implements UserRegistrationDsGateway {
    final private Map<String, UserRegistrationDsInputData> users = new HashMap<>();

    /**
     *
     * @param identifier the user's username
     * @return whether the user exists.
     */
    @Override
    public boolean usernameExists(String identifier) {
        return users.containsKey(identifier);
    }

    /**
     *
     * @param registrationDsInputData the data we will save
     */
    @Override
    public void saveUserRegistration(UserRegistrationDsInputData registrationDsInputData) {
        users.put(registrationDsInputData.getUsername(), registrationDsInputData);

    }
}
