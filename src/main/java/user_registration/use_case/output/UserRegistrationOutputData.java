package user_registration.use_case.output;

/**
 *
 */
public class UserRegistrationOutputData {
     private final String firstName;
    private final String lastname;
    private final String username;
    private  String creationTime;

    /**
     *
     * @param firstName users firstname
     * @param lastname users lastname
     * @param username users username
     * @param creationTime users creationtime
     */
    public UserRegistrationOutputData(String firstName, String lastname, String username, String creationTime){
        this.firstName = firstName;
        this.lastname = lastname;
        this.username = username;
        this.creationTime = creationTime;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
