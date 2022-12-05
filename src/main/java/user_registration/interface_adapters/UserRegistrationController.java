package user_registration.interface_adapters;

import user_registration.usecase_engine.input.UserRegistrationInputBoundary;
import user_registration.usecase_engine.input.UserRegistrationInputData;
import user_registration.usecase_engine.output.UserRegistrationOutputData;

public class UserRegistrationController {

    UserRegistrationInputBoundary registrationInputBoundary;

    public UserRegistrationController(UserRegistrationInputBoundary registrationInputData) {
        this.registrationInputBoundary = registrationInputData;
    }

    public UserRegistrationOutputData createInputObject(String firstName, String lastName, String username,
                                                        String password, Object locationName, String role){
        UserRegistrationInputData inputData = new UserRegistrationInputData(firstName, lastName, username, password,
                locationName, role);
        return registrationInputBoundary.createInputObject(inputData);
    }
}
