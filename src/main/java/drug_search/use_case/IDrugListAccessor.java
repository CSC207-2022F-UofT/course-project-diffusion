package drug_search.use_case;

import java.io.FileNotFoundException;
import java.util.List;

public interface IDrugListAccessor {
    /**
     * Reads the drug request database and returns a list of the drug requests contained therein.
     * @return The deserialized {@link List<DrugRequestDBEntry>}.
     */
    List<DrugRequestDBEntry> getDrugRequestList(String pathname) throws FileNotFoundException;
}
