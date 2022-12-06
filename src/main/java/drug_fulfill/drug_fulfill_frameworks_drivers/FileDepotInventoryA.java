//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package drug_fulfill.drug_fulfill_frameworks_drivers;

import drug_fulfill.drug_fulfill_use_case.DrugFulfillDsGateway;
import drug_fulfill.drug_fulfill_use_case.DrugFulfillDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class FileDepotInventoryA implements DrugFulfillDsGateway {
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, DrugFulfillDsRequestModel> CurrentInventory = new HashMap<>();
    private final Map<String, DrugFulfillDsRequestModel> MadeOrders = new HashMap<>();
    private final String[] drugList = new String[]{"DrugA", "DrugB", "DrugC"};
    private final String[] depotList = new String[]{"Depot1", "Depot2", "Depot3"};


    public FileDepotInventoryA(String csvPath) throws IOException {
        this.csvFile = new File(csvPath);
        this.headers.put("drugName", 0);
        this.headers.put("drugAmount", 1);
        this.headers.put("creation_time", 2);
        this.headers.put("batch Number", 3);
        this.headers.put("id Number", 4);
        this.headers.put("Depot Name", 5);

        if (this.csvFile.length() == 0L) {
            System.out.println("wtf empty csv inventory");
            createDepot();
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
                String depotName = String.valueOf(col[this.headers.get("Depot Name")]);
                DrugFulfillDsRequestModel saveReceipt = new DrugFulfillDsRequestModel(drugName, drugAmount, ldt, Boolean.FALSE, depotName);
                this.CurrentInventory.put(String.valueOf(ldt), saveReceipt);
            }

            reader.close();
        }

    }

    public boolean isEmergency(Boolean isEmergencyToggle) {
        return isEmergencyToggle;
    }

    public boolean isInt(String DrugAmount) {
        try {
            int a = Integer.parseInt(DrugAmount);
            System.out.println(a);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public void fulfillOrder(DrugFulfillDsRequestModel requestModel) {
        String fake_id = String.valueOf(requestModel.getCreationTime());
        this.MadeOrders.put(fake_id, requestModel);
        this.adjustInventory(fake_id);
    }

    private void adjustInventory(String fake_id) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.csvFile));
            writer.write(String.join(",", this.headers.keySet()));
//            writer.newLine();
            DrugFulfillDsRequestModel plsfulfill = this.MadeOrders.get(fake_id);

            for (DrugFulfillDsRequestModel drugBin : this.CurrentInventory.values()) {
                if (Objects.equals(drugBin.getName(), plsfulfill.getName())) {
                    drugBin.setBottle(drugBin.getBottle() - plsfulfill.getBottle());
//                    String line1 = String.format("%1$s,%2$s,%3$s", drugBin.getName(), drugBin.getBottle(), drugBin.getCreationTime());
//                    writer.write(line1);
                }

                writer.newLine();
                String line1 = String.format("%4$s, %1$s,%2$s,%3$s", drugBin.getName(), drugBin.getBottle(), drugBin.getCreationTime(), drugBin.getDepotName());
                writer.write(line1);

            }

            writer.close();
        } catch (IOException var10) {
            throw new RuntimeException(var10);
        }
    }

    private void createDepot() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.csvFile));
            writer.write(String.join(",", this.headers.keySet()));
            writer.newLine();

            for (String DepotName : this.depotList) {
                for (String DrugName : this.drugList) {
                    LocalDateTime ldt_now = LocalDateTime.now();
                    String line = String.format("%4$s, %1$s,%2$s,%3$s", DrugName, "20", ldt_now, DepotName);
                    //                String line = String.format("%1$s, %2$s, %3$s, %4$s, %5$s", DrugName, 20, ldt_now, "whatever", "IDtobeouted");

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
                String depotName = String.valueOf(col[this.headers.get("Depot Name")]);
                DrugFulfillDsRequestModel saveReceipt = new DrugFulfillDsRequestModel(drugName, drugAmount, ldt, Boolean.FALSE, depotName);
                this.CurrentInventory.put(String.valueOf(ldt), saveReceipt);
            }

            reader.close();

        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }
    }
}
