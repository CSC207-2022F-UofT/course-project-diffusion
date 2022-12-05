package user_login.ports;

public interface UserLogin {
    boolean usernameIsValid();
    boolean passwordIsValid();
    String getUsername();
    String getPassword();
}
