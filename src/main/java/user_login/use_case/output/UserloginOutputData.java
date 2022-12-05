package user_login.use_case.output;

public class UserloginOutputData {
    String username;
    String creationTime;

    public UserloginOutputData(String username, String creationTime) {
        this.username = username;
        this.creationTime = creationTime;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
