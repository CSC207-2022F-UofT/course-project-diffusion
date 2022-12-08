//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package drug_fulfill.drug_fulfill_frameworks_drivers;

//import drug_fulfill.drug_fulfill_use_case.DrugFulfillDsGateway;
//import drug_fulfill.drug_fulfill_use_case.DrugFulfillDsRequestModel;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Objects;
//
//public class FileSiteInventory implements DrugFulfillDsGateway {
//    private final File csvFile;
//    private final Map<String, Integer> headers = new LinkedHashMap<>();
//    private final Map<String, String[]> initialInventory = new HashMap<>();
//    private final Map<String, DrugFulfillDsRequestModel> CurrentInventory = new HashMap<>();
//    private final Map<String, DrugFulfillDsRequestModel> MadeOrders = new HashMap<>();
//
//
////    private final Map<String, String[]>depot1DrugList = new HashMap<>();
////    private final Map<String, String[]>depot2DrugList = new HashMap<>();
////    private final Map<String, String[]>depot3DrugList = new HashMap<>();
//
//
//    private final Map<String, String[]> depot1DrugAmounts = new HashMap<>();
////    private final String[] Depot1DrugAmounts = new String[]{"40", "45", "50"};
//
//
//    private final String[] depotList = new String[]{"Depot1", "Depot2", "Depot3"};
//    private final String[] siteList = new String[]{"Site1", "Site2", "Site3"};
//
//    private final String[] depot1DrugList = new String[]{"DrugA", "DrugB", "DrugC"};
//    private final String[] depot2DrugList = new String[]{"DrugA", "DrugB", "DrugC"};
//    private final String[] depot3DrugList = new String[]{"DrugA", "DrugB", "DrugC"};
//
//    private final String[] Depot1DrugAmounts = new String[]{"40", "45", "50"};
//    private final String[] Depot2DrugAmounts = new String[]{"40", "45", "50"};
//    private final String[] Depot3DrugAmounts = new String[]{"40", "45", "50"};
//
//    private final String[] site1DrugList = new String[]{"DrugA", "DrugB", "DrugC"};
//    private final String[] site2DrugList = new String[]{"DrugA", "DrugB", "DrugC"};
//    private final String[] site3DrugList = new String[]{"DrugA", "DrugB", "DrugC"};
//
////    private final String[] Depot1DrugAmounts = new String[]{"40", "45", "50"};
////    private final String[] Depot2DrugAmounts = new String[]{"40", "45", "50"};
////    private final String[] Depot3DrugAmounts = new String[]{"40", "45", "50"};
//
//    private final String[] siteDrugAmounts = new String[]{"20", "35", "30"};
////    private final String[] siteList = new String[]{"Site1", "Site2", "Site3"};
//
//
//    public FileSiteInventory(String csvPath) throws IOException {
//
////        innerMap.put("InnerKey", "InnerValue");
////        outerMap.put("OuterKey", innerMap);
////
////
////        depotList.put("Depot1", depot1DrugList);
////        depotList.put("Depot2", depot2DrugList);
////        depotList.put("Depot3", depot3DrugList);
////
////        depot1DrugList.put("DrugA", )
//        this.csvFile = new File(csvPath);
//
//        this.headers.put("Depot Name", 0);
//        this.headers.put("Drug Name", 1);
//        this.headers.put("Depot Drug Amount", 2);
//        this.headers.put("Depot Creation Time", 3);
//        this.headers.put("Site Name", 4);
//        this.headers.put("Site Drug Amount", 5);
////        this.headers.put("drugName", 5);
////        this.headers.put("drugAmount", 6);
////        this.headers.put("batch Number", 7);
////        this.headers.put("id Number", 8);
////        generateHeader();
////        generateInventoryTracker();
//
//        if (this.csvFile.length() == 0L) {
//            generateInventoryTracker();
//        }
////            System.out.println("wtf empty csv inventory");
////            generateHeader();
////            generateInventoryTracker();
////            createDepot(depotList, depotDrugList);
////            createSitesInventory(siteList, siteDrugList);
////        } else {
////            BufferedReader reader = new BufferedReader(new FileReader(this.csvFile));
////            reader.readLine();
////
////            String row;
////            while ((row = reader.readLine()) != null) {
////                String[] col = row.split(",");
////                String drugName = String.valueOf(col[this.headers.get("Drug Name")]);
////                String depotName = String.valueOf(col[this.headers.get("Depot Name")]);
////                int drugAmount = Integer.parseInt(col[this.headers.get("Depot Drug Amount")]);
////                String creationTimeText = String.valueOf(col[this.headers.get("Depot Creation Time")]);
////                String siteName = String.valueOf(col[this.headers.get("Site Name")]);
////                int siteDrugAmount = Integer.parseInt(col[this.headers.get("Site Drug Amount")]);
////                String siteCreationTime = String.valueOf(col[this.headers.get("Site Creation Time")]);
////                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
////                LocalDateTime siteLdt = LocalDateTime.parse(siteCreationTime);
////
////                DrugFulfillDsRequestModel saveReceipt = new DrugFulfillDsRequestModel(drugName, drugAmount, ldt,
////                        Boolean.FALSE, depotName);
//////                DrugFulfillDsRequestModel saveReceipt = new DrugFulfillDsRequestModel(drugName, depotName, drugAmount,
//////                        ldt, Boolean.FALSE, siteName, siteDrugAmount, siteLdt);
////
////                this.CurrentInventory.put(String.valueOf(ldt), saveReceipt);
////            }
////
////            reader.close();
//    }
//
////    }
//
//    public boolean isEmergency(Boolean isEmergencyToggle) {
//        return isEmergencyToggle;
//    }
//
//    public boolean isInt(String DrugAmount) {
//        try {
//            int a = Integer.parseInt(DrugAmount);
//            System.out.println(a);
//            return true;
//        } catch (Exception var3) {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean depotIsInsufficient(int orderAmount, String drugName, String depotName) {
//        System.out.println(CurrentInventory.values());
//        for (DrugFulfillDsRequestModel drugBin1 : this.CurrentInventory.values()) {
//            System.out.println(drugBin1.getName());
//            if (Objects.equals(drugBin1.getName(), drugName) && Objects.equals(drugBin1.getDepotName(), depotName)) {
////                System.out.println("matched");
////                System.out.println((drugBin1.getBottle() - orderAmount) <= 0);
//                return ((drugBin1.getBottle() - orderAmount) < 0);
//            }
//        }
//        //int currentAmount = 10;
//        return false;
//    }
//
//    public void fulfillOrderFromDepot(DrugFulfillDsRequestModel requestModel) {
//        String fake_id = String.valueOf(requestModel.getCreationTime());
//        this.MadeOrders.put(fake_id, requestModel);
//        this.adjustInventory(fake_id);
//    }
//
//
////    private void adjustInventory(String fake_id) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(this.csvFile));
////            writer.write(String.join(",", this.headers.keySet()));
//////            writer.newLine();
////            DrugFulfillDsRequestModel plsfulfill = this.MadeOrders.get(fake_id);
////
////            for (DrugFulfillDsRequestModel drugBin : this.CurrentInventory.values()) {
////
////                if (Objects.equals(drugBin.getDepotName(),plsfulfill.getDepotName())){
////                    if (Objects.equals(drugBin.getName(), plsfulfill.getName())) {
////                        //if (Objects.equals(drugBin.get))
////                        drugBin.setBottle(drugBin.getBottle() - plsfulfill.getBottle());
////    //                    String line1 = String.format("%1$s,%2$s,%3$s", drugBin.getName(), drugBin.getBottle(), drugBin.getCreationTime());
////    //                    writer.write(line1);
////                    }
////                }
////
////                writer.newLine();
////                String line1 = String.format("%4$s,%1$s,%2$s,%3$s", drugBin.getName(), drugBin.getBottle(), drugBin.getCreationTime(), drugBin.getDepotName());
////                writer.write(line1);
////
////            }
////
////            writer.close();
////        } catch (IOException var10) {
////            throw new RuntimeException(var10);
////        }
////    }
//
//    //    private void createDepot(String[] locationTypes, String[] inventory) {
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(this.csvFile));
////            writer.write(String.join(",", this.headers.keySet()));
////            writer.newLine();
////
////            for (String DepotName : locationTypes) {
////                for (String DrugName : inventory) {
////                    LocalDateTime ldt_now = LocalDateTime.now();
////                    String line = String.format("%4$s,%1$s,%2$s,%3$s", DrugName, "20", ldt_now, DepotName);
////                    //                String line = String.format("%1$s, %2$s, %3$s, %4$s, %5$s", DrugName, 20, ldt_now, "whatever", "IDtobeouted");
////
////                    writer.write(line);
////                    writer.newLine();
////                }
////            }
////            writer.close();
////
////            BufferedReader reader = new BufferedReader(new FileReader(this.csvFile));
////            reader.readLine();
////
////            String row;
////            while((row = reader.readLine()) != null) {
////                String[] col = row.split(",");
////                String drugName = String.valueOf(col[(Integer)this.headers.get("drugName")]);
////                int drugAmount = Integer.parseInt(col[(Integer)this.headers.get("drugAmount")]);
////                String creationTimeText = String.valueOf(col[(Integer)this.headers.get("creation_time")]);
////                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
////                String depotName = String.valueOf(col[this.headers.get("Depot Name")]);
////                String siteName = String.valueOf(col[this.headers.get("Site Name")]);
////
////                DrugFulfillDsRequestModel saveReceipt = new DrugFulfillDsRequestModel(drugName, drugAmount, ldt,
////                        Boolean.FALSE, depotName, siteName,  );
////                this.CurrentInventory.put(String.valueOf(ldt), saveReceipt);
////            }
////
////            reader.close();
////
////        } catch (IOException var7) {
////            throw new RuntimeException(var7);
////        }
////    }
//    private void generateHeader() {
//        BufferedWriter userRegistrationWriter;
//        try {
//            userRegistrationWriter = new BufferedWriter(new FileWriter(csvFile));
//            userRegistrationWriter.write(String.join(",", headers.keySet()));
//            userRegistrationWriter.newLine();
//            generateInventoryTracker();
//            userRegistrationWriter.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void adjustInventory(String fake_id) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(this.csvFile));
//            writer.write(String.join(",", this.headers.keySet()));
////            writer.newLine();
//            DrugFulfillDsRequestModel plsfulfill = this.MadeOrders.get(fake_id);
//
//            for (DrugFulfillDsRequestModel drugBin : this.CurrentInventory.values()) {
//
//                if (Objects.equals(drugBin.getDepotName(), plsfulfill.getDepotName())) {
//                    if (Objects.equals(drugBin.getName(), plsfulfill.getName())) {
//                        //if (Objects.equals(drugBin.get))
//                        drugBin.setBottle(drugBin.getBottle() - plsfulfill.getBottle());
//                        String line1 = String.format("%1$s,%2$s,%3$s", drugBin.getName(), drugBin.getBottle(), drugBin.getCreationTime());
//                        writer.write(line1);
//                    }
//                }
//
//                writer.newLine();
//                String line1 = String.format("%4$s,%1$s,%2$s,%3$s", drugBin.getName(), drugBin.getBottle(), drugBin.getCreationTime(), drugBin.getDepotName());
//                writer.write(line1);
//
//            }
//
//            writer.close();
//        } catch (IOException var10) {
//            throw new RuntimeException(var10);
//        }
//    }
//
//    private void generateInventoryTracker() throws IOException {
//
//
//        BufferedWriter inventoryWriter;
//        inventoryWriter = new BufferedWriter(new FileWriter(csvFile, true));
//
//        int i = 0;
//        try {
//            inventoryWriter.write(String.join(",", headers.keySet()));
//            inventoryWriter.newLine();
//
//            while (i < depotList.length) {
//                int x = 0;
//                while (x < depot1DrugList.length) {
//                    int y = 0;
//                    while ( y < siteDrugAmounts.length) {
//                        String currentLine = String.format("%s, %s, %s, %s, %s, %s", depotList[i], depot1DrugList[x], Depot1DrugAmounts[y], "Creation Tim", siteList[i], siteDrugAmounts[y]);
//                        System.out.println( depotList[i]);
//                        System.out.println(depot1DrugList[x]);
//                        System.out.println(Depot1DrugAmounts[y]);
//                        inventoryWriter.write(currentLine);
//                        inventoryWriter.newLine();
//                        y++;
//                    }
//                    x++;
//                }
//                i++;
//            }
//            inventoryWriter.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
//
