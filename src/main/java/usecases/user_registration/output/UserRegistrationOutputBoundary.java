package usecases.user_registration.output;

public interface UserRegistrationOutputBoundary {
    UserRegistrationOutputData successView(UserRegistrationOutputData userData);
    UserRegistrationOutputData failureView(String error);
}
