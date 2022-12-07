package drug_fulfill.drug_fulfill_entities;

public interface DrugFulfillFactory {
    DrugFulfill create(String drugName, int drugBottle, Boolean isEmergency, String depotName);
}
