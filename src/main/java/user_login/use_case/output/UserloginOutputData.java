package user_login.use_case.output;

public class UserloginOutputData {
    String username;
    String creationTime;
    String role;
    String locationName;

    public UserloginOutputData(String username, String creationTime, String role, String locationName) {
        this.username = username;
        this.creationTime = creationTime;
        this.role = role;
        this.locationName = locationName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
