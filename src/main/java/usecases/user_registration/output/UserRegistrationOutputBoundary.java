package usecases.user_registration.output;

import interface_adapters.user_registration.UserPresenterOutputBoundary;

public interface UserRegistrationOutputBoundary {
    UserRegistrationOutputData successView(UserRegistrationOutputData userData);
    UserRegistrationOutputData failureView(String error);
//    void setView (UserRegistrationOutputBoundary userPresenterOutBoundary);
}
