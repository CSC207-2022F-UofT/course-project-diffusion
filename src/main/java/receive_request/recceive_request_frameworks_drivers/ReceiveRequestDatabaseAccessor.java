package receive_request.recceive_request_frameworks_drivers;

import drug_search.use_case.DrugRequestDBEntry;
import receive_request.receive_request_use_case.ReceiveRequestDatabaseAccessorInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReceiveRequestDatabaseAccessor implements ReceiveRequestDatabaseAccessorInterface {

    /**
     * {@inheritDoc}
     */
    public boolean checkInventory(String drugName, String drugBottle) throws FileNotFoundException {
        ArrayList<String[]> list = new ArrayList<>();

        Scanner scanner = new Scanner(new File("./depotAInventory.csv"));
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            int i = 0;
            for (String entry : line) {
                line[i] = entry.trim();
                i++;
            }
            list.add(line);
        }

        for (String[] line : list) {
            if (line[1].equals(drugName)) {
                if (Integer.parseInt(line[2]) >= Integer.parseInt(drugBottle)) {
                    return true;
                }
            }
        }

        return false;
    }
}