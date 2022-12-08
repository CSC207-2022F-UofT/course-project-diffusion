package user_login.frameworks_and_drivers.database_generator;

import user_login.use_case.database_access.UserLoginDsGateway;
import user_login.use_case.database_access.UserLoginDsInputData;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements UserLoginDsGateway, allows for storing data in memory, useful for the tests.
 */
public class UserLoginInMemory implements UserLoginDsGateway {
    final private Map<String, UserLoginDsInputData> users = new HashMap<>();
    /**
     *
     * @param username the user's username
     * @return whether the user exists.
     */
    @Override
    public boolean usernameExists(String username) {
        return users.containsKey(username);
    }

    @Override
    public boolean passwordExists(String password) {
        return users.containsKey(password);
    }

    @Override
    public void saveUserLogin(UserLoginDsInputData userLoginDsInputData) {

    }

    @Override
    public String userRole(String role) {
        return role;
    }

    @Override
    public String locationName(String locationName) {
        return locationName;
    }

    @Override
    public String accountID(String accountID) {
        return accountID;
    }
}
