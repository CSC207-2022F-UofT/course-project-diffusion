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
//        if (csvFile.length() == 0){
//            generateHeader();
////            appendDrugRequest();
//        }
//        else{
//            appendDrugRequest(d);
//        }

//        generateDrugRequestHelper();

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
        if (csvFile.length() == 0){
            generateHeader();
//            appendDrugRequest();
        }
        else{
            appendDrugRequest(drugNameRequested);
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

    private void appendDrugRequest(String drugNameRequested){
        BufferedWriter drugRequestWriter;
        try {
            drugRequestWriter = new BufferedWriter(new FileWriter(csvFile, true));
//            drugRequestWriter.write(String.join(",", headers.keySet()));
//            drugRequestWriter.newLine();
///
//            for (DrugRequestDsInvokeModel userDrugRequest : drugRequests.values()) {
                DrugRequestDsInvokeModel newentry = drugRequests.get(drugNameRequested);
                String line = String.format("%s, %s, %s, %s, %s, %s", 10001, 20001, 30001, newentry.getDrugName(),
                        newentry.getDrugBottle(), newentry.getDrugRequestCreationTime());
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


}
