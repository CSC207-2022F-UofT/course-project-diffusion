package user_registration.ports;

public interface UserRegistrationGenerator {
    UserRegistration createUser(String firstName, String lastName, String username, String password);
}
