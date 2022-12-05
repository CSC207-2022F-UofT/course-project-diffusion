package drug_search_frameworks_drivers;

import drug_search_use_case.DrugRequestDBEntry;
import drug_search_use_case.IDrugListAccessor;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Handles all database de/serialization.
 */
public class DatabaseAccessor implements IDrugListAccessor {
    /**
     * Reads the drug request database and returns a list of the drug requests contained therein.
     * @return The deserialized {@link List<DrugRequestDBEntry>}.
     */
    public List<DrugRequestDBEntry> getDrugRequestList() throws FileNotFoundException {
        ArrayList<DrugRequestDBEntry> list = new ArrayList<>();

        Scanner scanner = new Scanner(new File("./Test16.csv"));

        // Skip header
        scanner.nextLine();

        // Read database csv line-by-line & construct list
        while (scanner.hasNextLine()) {
            // TODO remove debug console output

            String[] entries = scanner.nextLine().split(",");

            // Trim trailing whitespace
            int i = 0;
            for (String entry : entries) {
                entries[i] = entry.trim();
                i++;
            }

            // Skip entry if it doesn't match database format
            if (entries.length != 6) continue;

            System.out.println("Found valid database entry");

            /* Try to parse date data, assumes drug request was created at the beginning of the neoproterozoic era
            (ca. 1 Ga) if unsuccessful */
            LocalDateTime date;

            try {
                date = LocalDateTime.parse(entries[5]);
            }
            catch (Exception e) {
                date = LocalDateTime.MIN;
            }

            // Create new entity based on database entry and add to list
            list.add(new DrugRequestDBEntry(entries[0], entries[1], entries[2], entries[3],
                    Integer.parseInt(entries[4]), date));

            System.out.println("Added entry to list");
        }

        scanner.close();

        return list;
    }
}
