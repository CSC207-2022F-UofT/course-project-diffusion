package user_registration.use_case.input;

public class UserRegistrationInputData {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Object locationName;
    private String role;

    public UserRegistrationInputData(String firstName, String lastName, String username, String password,
                                     Object locationName, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.locationName = locationName;
        this.role = role;
    }

    public Object getLocationName() {
        return locationName;
    }

    public void setLocationName(Object locationName) {
        this.locationName = locationName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(int role) {
        if (role == 1){
            this.role = "Site";
        } else if (role == 2){
            this.role = "Depot";
        }
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

    public void setuserame(String userame) {
        this.username = userame;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
