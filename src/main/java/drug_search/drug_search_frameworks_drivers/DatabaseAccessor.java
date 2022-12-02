//package drug_search.drug_search_frameworks_drivers;
//
//import drug_search.DrugInfo;
//import drug_search.drug_search_entities.DrugList;
//import drug_search.drug_search_use_case.IDrugListAccessor;
//
//import java.util.List;
//
///**
// * Handles all database de/serialization.
// */
//public class DatabaseAccessor implements IDrugListAccessor {
//    /**
//     * If necessary, deserializes drug info and updates {@link DrugList} with the resulting list of {@link DrugInfo}
//     * objects.
//     * @return The deserialized {@link List<DrugInfo>}.
//     */
//    public List<DrugInfo> getDrugList() {
//        List<DrugInfo> list = DrugList.getDrugList();
//
//        if (list == null || list.isEmpty()) {
//            // todo deserialize drug info here
//        }
//
//        return list;
//    }
//}
