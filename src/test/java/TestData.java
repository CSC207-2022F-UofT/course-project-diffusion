import user_registration.ports.UserRegistration;
import user_registration.use_case.input.UserRegistrationInputData;
import user_registration.use_case.output.UserRegistrationOutputData;

public class TestData {
    public UserRegistrationInputData TestData() {

        UserRegistrationInputData inputData = new UserRegistrationInputData("Fyodor", "Dostoevsky",
                "Karamazov", "abcdefg", "Depot1", "Depot User");

        return inputData;
    }

    public UserRegistrationOutputData createInputObject ()
    UserRegistration userRequest = userRegistrationGenerator.createUser(userPOJO.getFirstName(),
            userPOJO.getLastName(), userPOJO.getUserame(), userPOJO.getPassword());
}
