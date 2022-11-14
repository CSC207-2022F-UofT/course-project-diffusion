package drug_fulfill_use_case;

public interface DrugFulfillDsGateway {
    boolean isEmergency(Boolean isEmergencyToggle);
    boolean isInt(String DrugAmount);
    void fulfillOrder(DrugFulfillDsRequestModel fulfillModel);
}
