package user_registration.usecase_engine.output;

public class UserRegistrationOutputData {
    String firstName;
    String lastname;
    String username;
    //    String password;
    String creationTime;
    String locationName;

    public UserRegistrationOutputData(String firstName, String lastname, String username, String creationTime){
        this.firstName = firstName;
        this.lastname = lastname;
        this.username = username;
        this.creationTime = creationTime;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
