package drug_search_use_case;

import drug_search_entities.DrugRequestDBEntry;
import drug_search_entities.DrugList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IDrugListAccessor {
    /**
     * Reads the drug request database and returns a list of the drug requests contained therein.
     * @return The deserialized {@link List<DrugRequestDBEntry>}.
     */
    List<DrugRequestDBEntry> getDrugRequestList() throws FileNotFoundException;
}
