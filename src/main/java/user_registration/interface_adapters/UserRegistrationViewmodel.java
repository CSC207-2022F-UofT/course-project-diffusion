package user_registration.interface_adapters;

public class UserRegistrationViewmodel {
    String firstName;
    String lastName;
    String username;
    String creationTime;
    public UserRegistrationViewmodel(String firstName, String lastname, String username, String creationTime){
        this.firstName = firstName;
        this.lastName = lastname;
        this.username = username;
        this.creationTime = creationTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
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
