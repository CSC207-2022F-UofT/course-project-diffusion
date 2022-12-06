package site_drug_request.drug_request_frameworks_drivers;

import site_drug_request.drug_request_use_case.DrugRequestDsGateway;
import site_drug_request.drug_request_use_case.DrugRequestDsInvokeModel;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DrugRequestRecorder implements DrugRequestDsGateway {

    //Below allows for the File to be created
    private final File csvFile;

    //below allows us to map Header names using integers
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    //Confirm what below does, but fairly sure it allows mapping of the actual drug request contents with a key.
    private final Map<String, DrugRequestDsInvokeModel> drugRequests = new HashMap<>();

    public DrugRequestRecorder(String csvPath) throws IOException{
        csvFile = new File(csvPath);
        headers.put("Drug Request ID", 0);
        headers.put("Site ID", 1);
        headers.put("Account ID", 2);
        headers.put("Requested Drug Name", 3);
        headers.put("Requested Bottle Quantity", 4);
        headers.put("Drug Request Date and Time", 5);

        //Check to see if file already exists, if it does not then add a header and the first drug request,
        // if it does then simply append the latest drug request to the bottom.

    }

    @Override
    public boolean drugNameExists(String identifier) {
        return drugRequests.containsKey(identifier);
    }

    @Override
    public void generateDrugRequest(DrugRequestDsInvokeModel drugRequestDsInvokeModel) {
        drugRequests.put(drugRequestDsInvokeModel.getDrugName(), drugRequestDsInvokeModel);
        this.generateDrugRequestHelper(drugRequestDsInvokeModel.getDrugName());
    }

    private void generateDrugRequestHelper(String drugNameRequested) {
        //Check to see if file already exists, if it does not then add a header and the first drug request,
        // if it does then simply append the latest drug request to the bottom.
        if (csvFile.length() == 0) {
            generateHeader();
            appendDrugRequest(drugNameRequested);
        } else {
            appendDrugRequest(drugNameRequested);
        }
    }


    private void appendDrugRequest(String drugNameRequested){
        BufferedWriter drugRequestWriter;
        try {
            drugRequestWriter = new BufferedWriter(new FileWriter(csvFile, true));
//            drugRequestWriter.write(String.join(",", headers.keySet()));
//            drugRequestWriter.newLine();
///
//            for (DrugRequestDsInvokeModel userDrugRequest : drugRequests.values()) {
                DrugRequestDsInvokeModel newEntry = drugRequests.get(drugNameRequested);
                int lastSiteID = Integer.parseInt(Reader(0)) + 1000;
                String line = String.format("%s, %s, %s, %s, %s, %s", lastSiteID, 20001, 30001, newEntry.getDrugName(),
                        newEntry.getDrugBottle(), newEntry.getDrugRequestCreationTime());
                drugRequestWriter.write(line);
                drugRequestWriter.newLine();
//            }

            drugRequestWriter.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void generateHeader(){
        BufferedWriter drugRequestWriter;
        try{
            drugRequestWriter = new BufferedWriter(new FileWriter(csvFile));
            drugRequestWriter.write(String.join(",", headers.keySet()));
            drugRequestWriter.newLine();
            drugRequestWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private String Reader(int column) throws IOException {
        String delimiter = ",";
        BufferedReader bufferedReader;
        String currentline;
        String[] data = new String[0];
//        ArrayList<String> collectedData = new ArrayList<String>();
//        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));

            while  ((currentline = bufferedReader.readLine())!= null) {
                data = currentline.split(delimiter);
                System.out.println(data[column]);
            }
            bufferedReader.close();
            return data[column];
    }

    }
