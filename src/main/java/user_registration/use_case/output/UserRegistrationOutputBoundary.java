package user_registration.use_case.output;

public interface UserRegistrationOutputBoundary {
    UserRegistrationOutputData successView(UserRegistrationOutputData userData);
    UserRegistrationOutputData failureView(String error);
//    void setView (UserRegistrationOutputBoundary userPresenterOutBoundary);
}
