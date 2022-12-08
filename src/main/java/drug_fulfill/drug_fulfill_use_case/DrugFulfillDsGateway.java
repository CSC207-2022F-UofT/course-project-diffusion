package drug_fulfill.drug_fulfill_use_case;

import java.util.Map;

public interface DrugFulfillDsGateway {

    boolean depotIsInsufficient(int orderAmount, String drugName, String depotName);

    void fulfillOrder(DrugFulfillDsRequestModel fulfillModel);
    Map<String, DrugFulfillDsRequestModel> getCurrentInventory();
    Map<String, DrugFulfillDsRequestModel> getMadeOrders();
}
