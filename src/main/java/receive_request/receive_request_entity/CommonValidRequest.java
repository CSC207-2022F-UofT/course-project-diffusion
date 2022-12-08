package receive_request.receive_request_entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CommonValidRequest implements ValidRequest{
    final private String drugName;
    final private String drugBottle;

    public CommonValidRequest(String drugName, String drugBottle) {
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    @Override
    public boolean checkInventory() throws FileNotFoundException {
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
            if (line[2].equals(drugName)) {
                if (Integer.parseInt(line[3]) > Integer.parseInt(drugBottle)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String getName() { return drugName; }

    @Override
    public String getBottle() { return drugBottle; }
}