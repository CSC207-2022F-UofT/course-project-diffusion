package user_login.use_case.database_access;

public interface UserLoginDsGateway {
    boolean usernameExists(String identifier);
    boolean passwordExists(String identifier);
    void saveUserLogin(UserLoginDsInputData userLoginDsInputData);
    String userRole(String Identifier);
}
