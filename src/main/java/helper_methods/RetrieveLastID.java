package helper_methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 */

public class RetrieveLastID {
    /**
     *
     * @param receivedID
     * @param csvPath
     * @return
     * @throws IOException
     */
        public int LastIDRetriever(int receivedID, File csvPath) throws IOException {
            String delimiter = ",";
            String currentLine;
            int returnID = receivedID;

            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvPath));
            currentLine = bufferedReader.readLine();

            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] data = currentLine.split(delimiter);
                System.out.println(data[0]);
                returnID =  Integer.parseInt(data[0]) + 1;
            }
            bufferedReader.close();
            System.out.println(returnID);
            return returnID;
        }
}
