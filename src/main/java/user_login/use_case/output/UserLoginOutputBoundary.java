package user_login.use_case.output;

public interface UserLoginOutputBoundary {
    UserloginOutputData successView(UserloginOutputData userloginOutputData);
    UserloginOutputData failView(String error);
}
