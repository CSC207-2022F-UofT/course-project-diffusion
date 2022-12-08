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

    @Override
    public boolean usernameExists(String identifier) {
        return Reader(identifier, 3);
    }

    @Override
    public void saveUserRegistration(UserRegistrationDsInputData registrationDsInputData) {
        userRegistrationRequest.put(registrationDsInputData.getUsername(),registrationDsInputData);
        this.appendUserRegistrationRequest(registrationDsInputData.getUsername());
//        this.generateUserRegistrationHelper(registrationDsInputData.getUsername());
    }

    /**
     *
     * @param username key to access the hashmap and retrieve the UserRegistrationDsInputData.
     */
    private void appendUserRegistrationRequest(String username){
        BufferedWriter userRegistrationWriter;
        try {
            userRegistrationWriter = new BufferedWriter(new FileWriter(csvFile, true));
                UserRegistrationDsInputData latestEntry = userRegistrationRequest.get(username);

                int lastRegistrationRequestID = LastIDRetriever(0, 2000);
                int series = lastNumber(latestEntry.getRole());
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
     *
     * @param column the column of the userRegistration csv file to check
     * @param series the number series associated with that column
     * @return the targetID + the lastID
     * @throws IOException
     */
    private int LastIDRetriever(int column, int series) throws IOException {
        String delimiter = ",";
        String currentLine;
        int targetID = series;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
         currentLine = bufferedReader.readLine();

        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] data = currentLine.split(delimiter);
            System.out.println(data[0]);
            //consider changing below to value of
            targetID =  Integer.parseInt(data[column]) + 1;
        }
        bufferedReader.close();
        System.out.println(targetID);
        return targetID;
    }

    private int lastNumber(String role) {
        int locationID = 0;
        if (role.equals("Site User")) {
            locationID = 3000;
        } else if (role.equals("Depot User")) {
            locationID = 4000;
        }return locationID;
    }

    /**
     *
     * @param role
     * @return
     * @throws IOException
     */
    private int UserlocationDetailsReader(String role) throws IOException {
        String delimiter = ",";
        String currentLine;
        int locationID = 0;
        String[] data;

        if (role.equals("Site User")){
             locationID = 3000;
        } else if (role.equals("Depot User")){
            locationID = 4000;
        }
//        System.out.println(locationID);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
        currentLine = bufferedReader.readLine();
//        System.out.println(locationID);

        while ((currentLine = bufferedReader.readLine()) != null) {

            data = currentLine.split(delimiter);
            if (Objects.equals(data[5].trim(), role)) {
                locationID = Integer.valueOf(data[7].trim()) + 1;
            }
        }
        bufferedReader.close();
        return locationID;
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
    private boolean Reader(String reference, int column){
        String delimiter = ",";
        BufferedReader bufferedReader;
        String currentline;
        String[] data;
//        ArrayList<String> collectedData = new ArrayList<String>();
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));

            while  ((currentline = bufferedReader.readLine())!= null){
                data = currentline.split(delimiter);
                System.out.println(data[column]);
                System.out.println(reference);
//                System.out.println(Arrays.toString(new String[]{data[column]}));
                if (Objects.equals(data[column].trim(), reference)){
                    return true;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return false;

    }



}
