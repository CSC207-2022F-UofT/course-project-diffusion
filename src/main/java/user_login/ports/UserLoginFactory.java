package user_login.ports;

import user_login.ports.UserLogin;

public interface UserLoginFactory {
    UserLogin createUser(String username, String password);
}
