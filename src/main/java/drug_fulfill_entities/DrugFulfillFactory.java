package drug_fulfill_entities;

public interface DrugFulfillFactory {
    DrugFulfill create(String drugName, int drugBottle, Boolean isEmergency);
}
