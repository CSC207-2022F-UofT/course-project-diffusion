package interface_adapters.user_registration;

import usecases.user_registration.output.UserRegistrationOutputBoundary;
import usecases.user_registration.output.UserRegistrationOutputData;

public interface UserPresenterOutputBoundary {
    UserRegistrationOutputData presenterOutput(UserRegistrationOutputData userRegistrationOutputBoundary);
//    void setView()

}