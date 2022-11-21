package ports.use_case_and_entities;

public interface UserRegistrationGenerator {
    UserRegistration createUser(String firstName, String lastName, String username, String password);
}
