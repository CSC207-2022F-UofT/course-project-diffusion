package drug_request_entity;

public interface DrugRequest {
    boolean drugNameIsEmpty();
    boolean drugBottleIsEmpty();
    boolean drugBottleIsValid();
    boolean drugBottleIsNumeric();
    boolean drugNameIsValid();
    String getDrugName();
    String getDrugBottle();
}
