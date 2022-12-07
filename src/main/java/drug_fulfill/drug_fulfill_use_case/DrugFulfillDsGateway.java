package drug_fulfill.drug_fulfill_use_case;

public interface DrugFulfillDsGateway {
    boolean isEmergency(Boolean isEmergencyToggle);
    boolean isInt(String DrugAmount);

    boolean depotIsInsufficient(int orderAmount, String drugName, String depotName);

    void fulfillOrder(DrugFulfillDsRequestModel fulfillModel);
}
