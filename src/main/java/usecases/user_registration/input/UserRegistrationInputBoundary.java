package usecases.user_registration.input;

import usecases.user_registration.output.UserRegistrationOutputData;

public interface UserRegistrationInputBoundary {
    UserRegistrationOutputData createInputObject(UserRegistrationInputData userRegistrationInputData);
}
