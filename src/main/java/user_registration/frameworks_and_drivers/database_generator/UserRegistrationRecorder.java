package user_registration.frameworks_and_drivers.database_generator;

import user_registration.use_case.database_access.UserRegistrationDsGateway;
import user_registration.use_case.database_access.UserRegistrationDsInputData;

import java.io.*;
import java.util.*;

/**
 * Handles all User Registration CSV database populating and reading.
 */
public class UserRegistrationRecorder implements UserRegistrationDsGateway {

    /**
     * The csvFile to be created
     */
    private final File csvFile;

     /**
      * map Header names using integers
     */
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    /**
     * Maps the drug request contents with a key.
     */
    private final Map<String, UserRegistrationDsInputData> userRegistrationRequest = new HashMap<>();

    /**
     *
     * @param csvPath the UserRegistration file path.
     * @throws IOException if there is an handling error
     */

    public UserRegistrationRecorder(String csvPath) throws IOException {
        csvFile = new File(csvPath);
        headers.put("User Registration Request ID", 0);
        headers.put("First Name", 1);
        headers.put("Last Name", 2);
        headers.put("Username", 3);
        headers.put("Password", 4);
        headers.put("User Role", 5);
        headers.put("Location Name", 6);
        headers.put("Site / Depot ID (sites 3000's depots are 4000's", 7);
        headers.put("User Registration Date and Time", 8);

        //Check to see if file already exists, if it does not then add a header and the first drug request,
        // if it does then simply append the latest drug request to the bottom.
        if (csvFile.length() == 0){
            System.out.println("generate header");
            generateHeader();
        }
    }

//    @Override
//    public boolean firstNameExists(String identifier) {
//        return userRegistrationRequest.containsKey(identifier);
//    }

//    @Override
//    public boolean lastNameExists(String identifier) {
//        return userRegistrationRequest.containsKey(identifier);
//    }

    /**
     * Checks if the username exists
     * @param identifier the username
     * @return boolean expression
     */
    @Override
    public boolean usernameExists(String identifier) {
        return Reader(identifier);
    }

    /**
     * Saves the user registration request into the CSV file.
     * @param registrationDsInputData the input object from the interactor to be saved.
     */
    @Override
    public void saveUserRegistration(UserRegistrationDsInputData registrationDsInputData) {
        userRegistrationRequest.put(registrationDsInputData.getUsername(),registrationDsInputData);
        this.appendUserRegistrationRequest(registrationDsInputData.getUsername());
    }

    /**
     *Adds the UserRegistration request to the end of the CSV file.
     * @param username key to access the hashmap and retrieve the UserRegistrationDsInputData.
     */
    private void appendUserRegistrationRequest(String username){
        BufferedWriter userRegistrationWriter;
        try {
            userRegistrationWriter = new BufferedWriter(new FileWriter(csvFile, true));
            UserRegistrationDsInputData latestEntry = userRegistrationRequest.get(username);

            int lastRegistrationRequestID = LastIDRetriever();
//            int series = lastNumber(latestEntry.getRole());
            int siteOrDepotID = UserlocationDetailsReader(latestEntry.getRole());

            System.out.println(latestEntry.getRole());
            String line = String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s", lastRegistrationRequestID, latestEntry.getFirstname(),
                        latestEntry.getLastname(), latestEntry.getUsername(),
                        latestEntry.getPassword(), latestEntry.getRole(),
                        latestEntry.getLocationName(), siteOrDepotID,  latestEntry.getUserRegistrationTime());
                userRegistrationWriter.write(line);
                userRegistrationWriter.newLine();
            userRegistrationWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the targetID + the lastID
     * @throws IOException if there is an input output exception.
     */
    private int LastIDRetriever() throws IOException {
        String delimiter = ",";
        String currentLine;
        int targetID = 2000;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
         currentLine = bufferedReader.readLine();

        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] data = currentLine.split(delimiter);
            System.out.println(data[0]);
            targetID =  Integer.parseInt(data[0]) + 1;
        }
        bufferedReader.close();
        System.out.println(targetID);
        return targetID;
    }

    /**
     * Checks to see what the ID number of the last user registered was. Generate the new location ID based on
     * the specified role and last user ID registered.
     * @param role the role the user selected.
     * @return the ID number of the location
     * @throws IOException if there is an input output exception.
     */
    private int UserlocationDetailsReader(String role) throws IOException {
        String delimiter = ",";
        String currentLine;
        int locationID = 0;
        String[] data;

        /*
        check the role and set the locationID accordings.
         */

        if (role.equals("Site User")){
             locationID = 3000;
        } else if (role.equals("Depot User")){
            locationID = 4000;
        }

        /*
        Read the lines and update location ID to the latest ID of the relevant role.
         */
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
        while ((currentLine = bufferedReader.readLine()) != null) {
            data = currentLine.split(delimiter);
            if (Objects.equals(data[5].trim(), role)) {
                locationID = Integer.parseInt(data[7].trim()) + 1;
            }
        }
        bufferedReader.close();
        return locationID;
    }

    /**
     * Generate the header of the CSV File
     */
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

    /**
     * @param reference the user role
     * @return boolean expression
     */
    private boolean Reader(String reference){
        String delimiter = ",";
        BufferedReader bufferedReader;
        String currentline;
        String[] data;
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));

            while  ((currentline = bufferedReader.readLine())!= null){
                data = currentline.split(delimiter);
                System.out.println(data[3]);
                System.out.println(reference);
                if (Objects.equals(data[3].trim(), reference)){
                    return true;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return false;

    }

}
