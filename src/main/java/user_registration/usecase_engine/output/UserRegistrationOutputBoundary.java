package user_registration.usecase_engine.output;

public interface UserRegistrationOutputBoundary {
    UserRegistrationOutputData successView(UserRegistrationOutputData userData);
    UserRegistrationOutputData failureView(String error);
//    void setView (UserRegistrationOutputBoundary userPresenterOutBoundary);
}
