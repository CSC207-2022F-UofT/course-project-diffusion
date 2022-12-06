package user_registration.interface_adapters;

import user_registration.use_case.output.UserRegistrationOutputData;

public interface UserPresenterOutputBoundary {
    UserRegistrationOutputData presenterOutput(UserRegistrationOutputData userRegistrationOutputBoundary);
//    void setView()

}