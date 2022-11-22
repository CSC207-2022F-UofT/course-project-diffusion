package frameworks_and_drivers.view.database_access;

import usecases.user_registration.database_access.UserRegistrationDsGateway;
import usecases.user_registration.database_access.UserRegistrationDsInputData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;

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
        headers.put("User Registration Date and Time", 5);

        //Check to see if file already exists, if it does not then add a header and the first drug request,
        // if it does then simply append the latest drug request to the bottom.
//        if (csvFile.length() == 0){
//            generateHeader();
//
////            appendUserRegistrationRequest();
//        }
//        else{
//            appendUserRegistrationRequest();
//        }

        generateDrugRequestHelper();

//        if (csvFile.length() == 0) {
//            generateDrugRequest();
//            System.out.println(csvFile.length());
//        } else{
//            BufferedWriter appendWriter;
//            try {
//                appendWriter = new BufferedWriter(new FileWriter(csvFile, true));
//                for (DrugRequestDsInvokeModel userDrugRequest : drugRequests.values()){
//                    String line = String.format("%s, %s, %s, %s, %s, %s",  10001, 20001, 30001, userDrugRequest.getDrugName(),
//                            userDrugRequest.getDrugBottle(), userDrugRequest.getDrugRequestCreationTime() );
////                    appendWriter.newLine();
//                    appendWriter.write(line);
//                    appendWriter.newLine();
//                }
//
//                appendWriter.close();
//            } catch (IOException e){
//                throw new RuntimeException(e);
//            }
//        }

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
    public boolean userameExists(String identifier) {
        return userRegistrationRequest.containsKey(identifier);
    }

    @Override
    public void saveUserRegistration(UserRegistrationDsInputData registrationDsInputData) {
        userRegistrationRequest.put(registrationDsInputData.getUsername(),registrationDsInputData);
        this.generateDrugRequestHelper();
    }
//    @Override
//    public boolean drugNameExists(String identifier) {
//        return drugRequests.containsKey(identifier);
//    }
//
//    @Override
//    public void generateDrugRequest(DrugRequestDsInvokeModel drugRequestDsInvokeModel) {
//        drugRequests.put(drugRequestDsInvokeModel.getDrugName(), drugRequestDsInvokeModel);
//        this.generateDrugRequestHelper();
//    }

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



//        generateHeader();
//        appendDrugRequest();
//        BufferedWriter drugRequestWriter;
//        try {
//            drugRequestWriter = new BufferedWriter(new FileWriter(csvFile, true));
//            drugRequestWriter.write(String.join(",", headers.keySet()));
//            drugRequestWriter.newLine();
//
//            for (DrugRequestDsInvokeModel userDrugRequest : drugRequests.values()) {
//                String line = String.format("%s, %s, %s, %s, %s, %s", 10001, 20001, 30001, userDrugRequest.getDrugName(),
//                        userDrugRequest.getDrugBottle(), userDrugRequest.getDrugRequestCreationTime());
//                drugRequestWriter.write(line);
//                drugRequestWriter.newLine();
//            }
//
//            drugRequestWriter.close();
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    private void appendUserRegistrationRequest(){
        BufferedWriter userRegistrationWriter;
        try {
            userRegistrationWriter = new BufferedWriter(new FileWriter(csvFile, true));
//            userRegistrationWriter.write(String.join(",", headers.keySet()));
//            userRegistrationWriter.newLine();
//
            for (UserRegistrationDsInputData userRegistrationInput : userRegistrationRequest.values()) {
                String line = String.format("%s, %s, %s, %s, %s, %s", 10001, userRegistrationInput.getFirstname(),
                        userRegistrationInput.getLastname(), userRegistrationInput.getUsername(), userRegistrationInput.getPassword(),
                        userRegistrationInput.getUserRegistrationTime());
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