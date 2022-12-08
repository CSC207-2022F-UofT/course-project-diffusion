package site_drug_request.drug_request_frameworks_drivers;

import helper_methods.HelperMethods;
import site_drug_request.drug_request_use_case.DrugRequestDsGateway;
import site_drug_request.drug_request_use_case.DrugRequestDsInvokeModel;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Records the Input Data from the interactor in a csv File.
 */
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
        if (csvPath.length() == 0){
            generateHeader();
        }
    }

    @Override
    public boolean drugNameExists(String identifier) {
        return drugRequests.containsKey(identifier);
    }

    @Override
    public void generateDrugRequest(DrugRequestDsInvokeModel drugRequestDsInvokeModel) {
        drugRequests.put(drugRequestDsInvokeModel.getAccountID(), drugRequestDsInvokeModel);
        this.generateDrugRequestHelper(drugRequestDsInvokeModel.getAccountID());
    }

    private void generateDrugRequestHelper(String accountID) {
        //Check to see if file already exists, if it does not then add a header and the first drug request,
        // if it does then simply append the latest drug request to the bottom.
        if (csvFile.length() == 0) {
            generateHeader();
            appendDrugRequest(accountID);
        } else {
            appendDrugRequest(accountID);
        }
    }


    private void appendDrugRequest(String accountID){
        BufferedWriter drugRequestWriter;
        try {
            drugRequestWriter = new BufferedWriter(new FileWriter(csvFile, true));
                DrugRequestDsInvokeModel drugRequest = drugRequests.get(accountID);
                int drugRequestID = new HelperMethods().LastIDRetriever(1000, csvFile);
                String line = String.format("%s, %s, %s, %s, %s, %s", drugRequestID, drugRequest.getSiteName(),
                        drugRequest.getAccountID(), drugRequest.getDrugName(), drugRequest.getDrugBottle(),
                        drugRequest.getDrugRequestCreationTime());
                drugRequestWriter.write(line);
                drugRequestWriter.newLine();
            drugRequestWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void generateHeader(){
        TableGeneratorHelper(csvFile, headers);
    }

    public static void TableGeneratorHelper(File csvFile, Map<String, Integer> headers) {
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
}


