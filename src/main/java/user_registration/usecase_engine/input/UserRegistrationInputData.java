package user_registration.usecase_engine.input;

public class UserRegistrationInputData {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public UserRegistrationInputData(String firstName, String lastName, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserame() {
        return username;
    }

    public void setUserame(String userame) {
        this.username = userame;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
