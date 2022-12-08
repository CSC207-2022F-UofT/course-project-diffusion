package helper_methods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class TableHeader {
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
