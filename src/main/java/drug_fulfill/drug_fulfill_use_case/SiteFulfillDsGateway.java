package drug_fulfill.drug_fulfill_use_case;

public interface SiteFulfillDsGateway {
    boolean isEmergency(Boolean isEmergencyToggle);
    boolean isInt(String DrugAmount);

    boolean SiteIsInsufficient(int orderAmount, String drugName, String depotName);

    void fulfillOrder(DrugFulfillDsRequestModel fulfillModel);
}
