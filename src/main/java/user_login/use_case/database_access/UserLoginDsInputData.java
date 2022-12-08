package user_login.use_case.database_access;

import java.time.LocalDateTime;

public class UserLoginDsInputData {
    private String username;
    private String password;
    private final LocalDateTime userloginTime;

    public UserLoginDsInputData(String username, String password, LocalDateTime userloginTime) {
        this.username = username;
        this.password = password;
        this.userloginTime = userloginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getUserloginTime() {
        return userloginTime;
    }
}
