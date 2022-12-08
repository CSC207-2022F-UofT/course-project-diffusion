package drug_fulfill.drug_fulfill_entities;

public interface DrugFulfill {
    String getDrugName();
    int getDrugBottle();

    boolean getIsEmergency();
    String getDepotName();
    String getSiteName();

}
