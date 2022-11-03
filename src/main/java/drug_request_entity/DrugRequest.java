package drug_request_entity;

public interface DrugRequest {
    boolean drugBottleIsValid();
    boolean drugNameIsValid();
    String getDrugName();
    int getDrugBottle();
}
