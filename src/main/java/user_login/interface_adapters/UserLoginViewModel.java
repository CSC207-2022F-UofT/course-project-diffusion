package user_login.interface_adapters;

public class UserLoginViewModel {
    String username;
    String creationTime;
    String role;
    public UserLoginViewModel(String username, String creationTime, String role) {
        this.username = username;
        this.creationTime = creationTime;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
