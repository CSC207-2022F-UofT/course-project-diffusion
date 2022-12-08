package user_login.user_login_entities;

import user_login.ports.UserLogin;

public class CommonUserLogin implements UserLogin {
    private final String username;
    private final String password;

    public CommonUserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean usernameIsValid() {
        return username.matches("[a-zA-Z]+");
    }

    @Override
    public boolean passwordIsValid() {
        return password != null && password.length()> 5;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
