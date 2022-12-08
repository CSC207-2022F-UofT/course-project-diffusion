//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package drug_fulfill.drug_fulfill_frameworks_drivers;

import drug_fulfill.drug_fulfill_use_case.SiteDrugFulfillDsGateway;
import drug_fulfill.drug_fulfill_use_case.SiteDrugFulfillDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class FileSiteInventory implements SiteDrugFulfillDsGateway {
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, SiteDrugFulfillDsRequestModel> CurrentInventory = new HashMap<>();
    private final Map<String, SiteDrugFulfillDsRequestModel> MadeOrders = new HashMap<>();
    private final String[] drugList = new String[]{"DrugA", "DrugB", "DrugC"};
    private final String[] siteList = new String[]{"Site1", "Site2", "Site3"};

    /**
     * Allows for storing data in memory, and writing corresponding CSV files.
     */

    public FileSiteInventory(String csvPath) throws IOException {
        this.csvFile = new File(csvPath);
        this.headers.put("Site Name", 0);
        this.headers.put("drugName", 1);
        this.headers.put("drugAmount", 2);
        this.headers.put("creation_time", 3);
        this.headers.put("batch Number", 4);
        this.headers.put("id Number", 5);

        if (this.csvFile.length() == 0L) {
            System.out.println("No Corresponding CSV file. Creating default site Inventory.");
            createSite();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(this.csvFile));
            reader.readLine();

            String row;
            while((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String drugName = String.valueOf(col[this.headers.get("drugName")]);
                int drugAmount = Integer.parseInt(col[this.headers.get("drugAmount")]);
                String creationTimeText = String.valueOf(col[this.headers.get("creation_time")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                String siteName = String.valueOf(col[this.headers.get("Site Name")]);
                SiteDrugFulfillDsRequestModel saveReceipt = new SiteDrugFulfillDsRequestModel(drugName, drugAmount, ldt, Boolean.FALSE, siteName);
                this.CurrentInventory.put(String.valueOf(ldt), saveReceipt);
            }

            reader.close();
        }

    }

    /**
     * Allows for an order to be checked against the depot inventory. Returns True if there is not enough drugs to
     * fulfill the order.
     * @param orderAmount The amount ordered by a user.
     * @param depotName The depot ordered from by a user.
     * @param drugName The name of drug ordered by a user.
     */
//    @Override
//    public boolean depotIsInsufficient(int orderAmount, String drugName, String depotName) {
//        System.out.println(CurrentInventory.values());
//        for (DrugFulfillDsRequestModel drugBin1 : this.CurrentInventory.values()) {
//            System.out.println(drugBin1.getName());
//            if (Objects.equals(drugBin1.getName(), drugName) && Objects.equals(drugBin1.getDepotName(),depotName) ) {
//                return ((drugBin1.getBottle() - orderAmount) < 0);
//            }
//        }
//        return false;
//    }

    /**
     * Allows for an order made by a user to be saved in our Hashmap database of fulfilled orders.
     * @param requestModel The order made by a user.
     */
    public void fulfillOrderToSite(SiteDrugFulfillDsRequestModel requestModel) {
        String fake_id = String.valueOf(requestModel.getCreationTime());
        this.MadeOrders.put(fake_id, requestModel);
        this.adjustInventory(fake_id);
    }
    /**
     * Allows for depot database to adjust based on an order made.
     * @param fake_id ID value used as key in our Hashmap. Used to pull a specific order made.
     */

    private void adjustInventory(String fake_id) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.csvFile));
            writer.write(String.join(",", this.headers.keySet()));
            SiteDrugFulfillDsRequestModel plsfulfill = this.MadeOrders.get(fake_id);

            for (SiteDrugFulfillDsRequestModel drugBin : this.CurrentInventory.values()) {

                if (Objects.equals(drugBin.getSiteName(),plsfulfill.getSiteName())){
                    if (Objects.equals(drugBin.getName(), plsfulfill.getName())) {
                        drugBin.setBottle(drugBin.getBottle() + plsfulfill.getBottle());
                    }
                }

                writer.newLine();
                String line1 = String.format("%4$s,%1$s,%2$s,%3$s", drugBin.getName(), drugBin.getBottle(), drugBin.getCreationTime(), drugBin.getSiteName());
                writer.write(line1);

            }

            writer.close();
        } catch (IOException var10) {
            throw new RuntimeException(var10);
        }
    }
    /**
     * Allows a simple Depot database to be created with 20 of each drug in each depot.
     */
    private void createSite() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.csvFile));
            writer.write(String.join(",", this.headers.keySet()));
            writer.newLine();

            for (String SiteName : this.siteList) {
                for (String DrugName : this.drugList) {
                    LocalDateTime ldt_now = LocalDateTime.now();
                    String line = String.format("%4$s,%1$s,%2$s,%3$s", DrugName, "20", ldt_now, SiteName);

                    writer.write(line);
                    writer.newLine();
                }
            }
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader(this.csvFile));
            reader.readLine();

            String row;
            while((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String drugName = String.valueOf(col[(Integer)this.headers.get("drugName")]);
                int drugAmount = Integer.parseInt(col[(Integer)this.headers.get("drugAmount")]);
                String creationTimeText = String.valueOf(col[(Integer)this.headers.get("creation_time")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                String siteName = String.valueOf(col[this.headers.get("Site Name")]);
                SiteDrugFulfillDsRequestModel saveReceipt = new SiteDrugFulfillDsRequestModel(drugName, drugAmount, ldt, Boolean.FALSE, siteName);
                this.CurrentInventory.put(String.valueOf(ldt), saveReceipt);
            }

            reader.close();

        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }
    }
}
