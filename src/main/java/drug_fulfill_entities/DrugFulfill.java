package drug_fulfill_entities;

public interface DrugFulfill {
        boolean drugBottleIsValid();
        boolean drugNameIsValid(String drugName);
        String getDrugName();
        int getDrugBottle();

        boolean getIsEmergency();

}
