package user_registration.usecase_engine.input;

import user_registration.usecase_engine.output.UserRegistrationOutputData;

public interface UserRegistrationInputBoundary {
    UserRegistrationOutputData createInputObject(UserRegistrationInputData userRegistrationInputData);
}
