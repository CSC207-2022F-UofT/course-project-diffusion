package user_login.user_login_entities;

import user_login.ports.UserLogin;
import user_login.ports.UserLoginFactory;

public class CommonUserloginFactory implements UserLoginFactory {
    @Override
    public UserLogin createUser(String username, String password) {
        return new CommonUserLogin(username, password);
    }
}
