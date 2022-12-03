package drug_search_entities;

import java.util.ArrayList;
import java.util.List;

/**
 * A list containing information about all available drugs.
 */
public class DrugList {
    /**
     * @return A list containing information about all available drugs.
     */
    public static List<DrugRequestDBEntry> getDrugList() {
        return drugList;
    }

    private static ArrayList<DrugRequestDBEntry> drugList;
}
