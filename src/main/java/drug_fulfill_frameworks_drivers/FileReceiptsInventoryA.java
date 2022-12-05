//package screens;
//
//import drug_fulfill_use_case.DrugFulfillDsGateway;
//import drug_fulfill_use_case.DrugFulfillDsRequestModel;
//
//import java.io.*;
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class FileReceiptsInventoryA implements DrugFulfillDsGateway {
//
//    private final File csvFile;
//
//    private final Map<String, Integer> headers = new LinkedHashMap<>();
//
//    private final Map<String, DrugFulfillDsRequestModel> madeOrders = new HashMap<>();
//
//    private final String[] drugList = {"DrugA", "DrugB", "DrugC"};
//
//    public FileReceiptsInventoryA(String csvPath) throws IOException {
//        csvFile = new File(csvPath);
//
//        headers.put("drugName", 0);
//        headers.put("drugAmount", 1);
//        headers.put("creation_time", 2);
//        headers.put("batch Number", 3);
//        headers.put("id Number", 4);
//        headers.put("emergency", 5);
//
//        if (csvFile.length() == 0) {
//            fulfillOrder();
//        } else {
//
//            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
//            reader.readLine(); // skip header
//
//            String row;
//            while ((row = reader.readLine()) != null) {
//                String[] col = row.split(",");
//                String drugName = String.valueOf(col[headers.get("drugName")]);
//                int drugAmount = Integer.parseInt((col[headers.get("drugAmount")]));
//                String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
//                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
//                Boolean er = Boolean.valueOf(col[headers.get("emergency")]);
//                DrugFulfillDsRequestModel saveReceipt = new DrugFulfillDsRequestModel(drugName, drugAmount, ldt, er /*, OrderID*/);
//                madeOrders.put(String.valueOf(ldt)/*orderID*/, saveReceipt);
//            }
//
//            reader.close();
//        }
//    }
//
//    @Override
//    public boolean isEmergency(Boolean isEmergencyToggle) {
//        return isEmergencyToggle; //isnt this redundant??
//    }
//
//    @Override
//    public boolean isInt(String DrugAmount) {
//        try{
//            int a = Integer.parseInt(DrugAmount);
//            System.out.println(a);
//        } catch (Exception e) {
//            return false;
//        }
//
//        return true;
//    }
//
//    /**
//     * Add requestModel to storage.
//     * @param requestModel the user information to save.
//     */
//    @Override
//    public void fulfillOrder(DrugFulfillDsRequestModel requestModel) {
//        madeOrders.put(String.valueOf(requestModel.getCreationTime()), requestModel);
//        this.fulfillOrder(); //see .put for changing the amount of drugs we have
//    }
//
//    private void fulfillOrder() {
//        BufferedWriter writer;
//        try {
//            writer = new BufferedWriter(new FileWriter(csvFile));
//            writer.write(String.join(",", headers.keySet()));
//            writer.newLine();
//
//            for (DrugFulfillDsRequestModel order : madeOrders.values()) {
//                String line = "%s,%s,%s,%s,%s,%s".formatted(
//                        order.getName(), order.getBottle(), order.getCreationTime(), order.getBatchNumber(), order.getIDNumber(), order.getIsEmergency());
//                writer.write(line);
//                writer.newLine();
//            }
//
//            writer.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void createDepot() {
//        BufferedWriter writer;
//        try {
//            writer = new BufferedWriter(new FileWriter(csvFile));
//            writer.write(String.join(",", headers.keySet()));
//            writer.newLine();
//
//            for (String DrugName : drugList) {
//                String line = "%s,%s,%s,%s,%s".formatted(
//                        DrugName, 10, 0, "000b", "000");
//                writer.write(line);
//                writer.newLine();
//            }
//
//            writer.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    /**
//     * Return whether a user exists with username identifier.
//     * @param identifier the username to check.
//     * @return whether a user exists with username identifier
//     */
//    /*
//    @Override
//    public boolean existsByName(String identifier) {
//        return accounts.containsKey(identifier);
//    }
//
//     */
//}
