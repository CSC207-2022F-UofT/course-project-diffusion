package user_login.frameworks_and_drivers.database_access;

import user_login.use_case.database_access.UserLoginDsGateway;
import user_login.use_case.database_access.UserLoginDsInputData;

import java.io.*;
import java.util.*;

public class UserLoginRecorder implements UserLoginDsGateway {
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, UserLoginDsInputData> userLoginRequest = new HashMap<>();

    public UserLoginRecorder(String csvPath) throws IOException {
        csvFile = new File(csvPath);
        headers.put("User Login Request ID", 0);
        headers.put("Username", 1);
        headers.put("Password", 2);
        headers.put("Login Successful (YES, NO)", 3);
        headers.put("Time of Login Request", 4);

        generateUserLoginRequestHelper();
    }

    @Override
    public boolean usernameExists(String identifier) {
        return Reader(identifier, 3);
//        return userLoginRequest.containsKey(identifier);
    }

    @Override
    public boolean passwordExists(String identifier) {
        return Reader(identifier, 4);
    }

    @Override
    public void saveUserLogin(UserLoginDsInputData userLoginDsInputData) {
        userLoginRequest.put(userLoginDsInputData.getUsername(), userLoginDsInputData);
        this.generateUserLoginRequestHelper();
    }
    private void generateUserLoginRequestHelper(){
        if (csvFile.length() == 0){
            generateHeader();
            appendUserloginRequest();

        }else{
            appendUserloginRequest();

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
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return false;

    }

    private void appendUserloginRequest(){
        BufferedWriter userLoginWriter;
        try{
            userLoginWriter = new BufferedWriter(new FileWriter(csvFile, true));
            for (UserLoginDsInputData userLoginDsInputData : userLoginRequest.values()){
                String line = String.format("%s, %s, %s, %s, %s", 1001, userLoginDsInputData.getUsername(), userLoginDsInputData.getPassword(),
                        "YES", userLoginDsInputData.getUserloginTime());
                userLoginWriter.write(line);
                userLoginWriter.newLine();
            }
            userLoginWriter.close();

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