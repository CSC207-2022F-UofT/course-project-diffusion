package interface_adapters.user_registration;

import usecases.user_registration.input.UserRegistrationInputBoundary;
import usecases.user_registration.input.UserRegistrationInputData;
import usecases.user_registration.output.UserRegistrationOutputData;

public class UserRegistrationController {

    UserRegistrationInputBoundary registrationInputBoundary;

    public UserRegistrationController(UserRegistrationInputBoundary registrationInputData) {
        this.registrationInputBoundary = registrationInputData;
    }

    public UserRegistrationOutputData createInputObject(String firstName, String lastName, String username, String password){
        UserRegistrationInputData inputData = new UserRegistrationInputData(firstName, lastName, username, password);
        return registrationInputBoundary.createInputObject(inputData);
    }
}
