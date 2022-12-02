package user_registration.interface_adapters;

import user_registration.usecase_engine.output.UserRegistrationOutputBoundary;
import user_registration.usecase_engine.output.UserRegistrationOutputData;

public interface UserPresenterOutputBoundary {
    UserRegistrationOutputData presenterOutput(UserRegistrationOutputData userRegistrationOutputBoundary);
//    void setView()

}