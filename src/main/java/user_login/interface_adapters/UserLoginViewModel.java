package user_login.interface_adapters;

public class UserLoginViewModel {
    String username;
    String creationTime;

    public UserLoginViewModel(String username, String creationTime) {
        this.username = username;
        this.creationTime = creationTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
