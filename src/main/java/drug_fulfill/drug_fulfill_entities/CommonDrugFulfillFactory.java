package drug_fulfill.drug_fulfill_entities;

public class CommonDrugFulfillFactory implements DrugFulfillFactory{
    @Override
    public DrugFulfill create(String drugName, int drugBottle, Boolean isEmergency) {
        return new CommonDrugFulfill(drugName, drugBottle, isEmergency);
    }
}
