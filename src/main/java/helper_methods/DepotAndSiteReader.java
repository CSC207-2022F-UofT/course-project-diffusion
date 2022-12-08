package helper_methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class DepotAndSiteReader {
    /**
     * @param locationName the user role
     * @return boolean expression
     */
    public int InventoryReader(String locationName, String drugName, File csvFile){
        String delimiter = ",";
        BufferedReader bufferedReader;
        String currentline;
        String[] data;
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));

            while  ((currentline = bufferedReader.readLine())!= null){
                data = currentline.split(delimiter);
                if (Objects.equals(data[0].trim(), locationName) && Objects.equals(data[1].trim(), drugName)){
                    return Integer.parseInt(data[2]);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return -10;

    }
}
