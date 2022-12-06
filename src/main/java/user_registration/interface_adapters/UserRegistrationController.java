package user_registration.interface_adapters;

import user_registration.use_case.input.UserRegistrationInputBoundary;
import user_registration.use_case.input.UserRegistrationInputData;
import user_registration.use_case.output.UserRegistrationOutputData;

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
