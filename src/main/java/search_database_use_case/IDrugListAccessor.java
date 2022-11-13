package search_database_use_case;

import entities.DrugInfo;
import entities.DrugList;

import java.util.List;

public interface IDrugListAccessor {
    /**
     * If necessary, deserializes drug info and updates {@link DrugList} with the resulting list of {@link DrugInfo}
     * objects.
     * @return The deserialized {@link List<DrugInfo>}.
     */
    List<DrugInfo> getDrugList();
}
