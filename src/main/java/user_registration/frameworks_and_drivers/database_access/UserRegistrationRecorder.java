package user_registration.frameworks_and_drivers.database_access;

import user_registration.usecase_engine.database_access.UserRegistrationDsGateway;
import user_registration.usecase_engine.database_access.UserRegistrationDsInputData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserRegistrationRecorder implements UserRegistrationDsGateway {

    //Below allows for the File to be created
    private final File csvFile;

    //below allows us to map Header names using integers
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    //Confirm what below does, but fairly sure it allows mapping of the actual drug request contents with a key.
    private final Map<String, UserRegistrationDsInputData> userRegistrationRequest = new HashMap<>();

    public UserRegistrationRecorder(String csvPath) throws IOException {
        csvFile = new File(csvPath);
        headers.put("User Registration Request ID", 0);
        headers.put("First Name", 1);
        headers.put("Last Name", 2);
        headers.put("Username", 3);
        headers.put("Password", 4);
        headers.put("User Role", 5);
        headers.put("Location Name", 6);
        headers.put("User Registration Date and Time", 7);

        //Check to see if file already exists, if it does not then add a header and the first drug request,
        // if it does then simply append the latest drug request to the bottom.
        generateDrugRequestHelper();


    }
    @Override
    public boolean firstNameExists(String identifier) {
        return userRegistrationRequest.containsKey(identifier);
    }

    @Override
    public boolean lastNameExists(String identifier) {
        return userRegistrationRequest.containsKey(identifier);
    }

    @Override
    public boolean usernameExists(String identifier) {
        return userRegistrationRequest.containsKey(identifier);
    }

    @Override
    public void saveUserRegistration(UserRegistrationDsInputData registrationDsInputData) {
        userRegistrationRequest.put(registrationDsInputData.getUsername(),registrationDsInputData);
        this.generateDrugRequestHelper();
    }


    private void generateDrugRequestHelper() {

        //Check to see if file already exists, if it does not then add a header and the first drug request,
        // if it does then simply append the latest drug request to the bottom.
        if (csvFile.length() == 0){
            generateHeader();
            appendUserRegistrationRequest();
        }
        else{
            appendUserRegistrationRequest();
        }
    }

    private void appendUserRegistrationRequest(){
        BufferedWriter userRegistrationWriter;
        try {
            userRegistrationWriter = new BufferedWriter(new FileWriter(csvFile, true));

//
            for (UserRegistrationDsInputData userRegistrationInput : userRegistrationRequest.values()) {
//                userRegistrationInput.setRole();
                String line = String.format("%s, %s, %s, %s, %s, %s, %s, %s", 10001, userRegistrationInput.getFirstname(),
                        userRegistrationInput.getLastname(), userRegistrationInput.getUsername(),
                        userRegistrationInput.getPassword(), userRegistrationInput.getRole(),
                        userRegistrationInput.getLocationName(), userRegistrationInput.getUserRegistrationTime());
                userRegistrationWriter.write(line);
                userRegistrationWriter.newLine();
            }

            userRegistrationWriter.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateHeader(){
        BufferedWriter userRegistrationWriter;
        try{
            userRegistrationWriter = new BufferedWriter(new FileWriter(csvFile));
            userRegistrationWriter.write(String.join(",", headers.keySet()));
            userRegistrationWriter.newLine();
            userRegistrationWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}