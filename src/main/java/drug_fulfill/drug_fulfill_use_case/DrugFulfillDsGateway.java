package drug_fulfill.drug_fulfill_use_case;

public interface DrugFulfillDsGateway {

    boolean depotIsInsufficient(int orderAmount, String drugName, String depotName);

    void fulfillOrder(DrugFulfillDsRequestModel fulfillModel);
}
