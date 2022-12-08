package user_registration.use_case.input;

import user_registration.use_case.output.UserRegistrationOutputData;

public interface UserRegistrationInputBoundary {
    UserRegistrationOutputData createInputObject(UserRegistrationInputData userRegistrationInputData);
}
