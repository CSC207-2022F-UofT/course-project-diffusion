//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package screens;

import drug_fulfill_use_case.DrugFulfillDsGateway;
import drug_fulfill_use_case.DrugFulfillDsRequestModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class FileDepotInventoryA implements DrugFulfillDsGateway {
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap();
    private final Map<String, DrugFulfillDsRequestModel> CurrentInventory = new HashMap();
    private final Map<String, DrugFulfillDsRequestModel> MadeOrders = new HashMap();
    private final String[] drugList = new String[]{"DrugA", "DrugB", "DrugC"};

    public FileDepotInventoryA(String csvPath) throws IOException {
        this.csvFile = new File(csvPath);
        this.headers.put("drugName", 0);
        this.headers.put("drugAmount", 1);
        this.headers.put("creation_time", 2);
        this.headers.put("batch Number", 3);
        this.headers.put("id Number", 4);
        if (this.csvFile.length() == 0L) {
            System.out.println("wtf empty csv inventory");
            createDepot();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(this.csvFile));
            reader.readLine();

            String row;
            while((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String drugName = String.valueOf(col[(Integer)this.headers.get("drugName")]);
                int drugAmount = Integer.parseInt(col[(Integer)this.headers.get("drugAmount")]);
                String creationTimeText = String.valueOf(col[(Integer)this.headers.get("creation_time")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                DrugFulfillDsRequestModel saveReceipt = new DrugFulfillDsRequestModel(drugName, drugAmount, ldt, Boolean.FALSE);
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
            writer.newLine();
            DrugFulfillDsRequestModel plsfulfill = this.MadeOrders.get(fake_id);

            for (DrugFulfillDsRequestModel drugBin : this.CurrentInventory.values()) {
                if (Objects.equals(drugBin.getName(), plsfulfill.getName())) {
                    drugBin.setBottle(drugBin.getBottle() - plsfulfill.getBottle());
                }

                String line1 = "%s,%s,%s,%s,%s".formatted(drugBin.getName(), drugBin.getBottle(), drugBin.getCreationTime(), drugBin.getBatchNumber(), drugBin.getIDNumber());
                writer.write(line1);
                writer.newLine();
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


            for (String DrugName : this.drugList) {
                LocalDateTime ldt_now = LocalDateTime.now();
                String line = "%s,%s,%s,%s,%s".formatted(DrugName, 20, ldt_now, "whatever", "IDtobeouted");
                writer.write(line);
                writer.newLine();
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
                DrugFulfillDsRequestModel saveReceipt = new DrugFulfillDsRequestModel(drugName, drugAmount, ldt, Boolean.FALSE);
                this.CurrentInventory.put(String.valueOf(ldt), saveReceipt);
            }

            reader.close();

        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }
    }
}
