package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * A list containing information about all available drugs.
 */
public class DrugList {
    /**
     * @return A list containing information about all available drugs.
     */
    public static List<DrugInfo> getDrugList() {
        return drugList;
    }

    private static ArrayList<DrugInfo> drugList;
}
