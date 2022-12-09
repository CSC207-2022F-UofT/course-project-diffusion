package drug_fulfill.drug_fulfill_use_case;

import java.util.Map;

/**
 * Depot Data access interface. Used between the data access for depot and the Drug fulfill interactor.
 */
public interface DrugFulfillDsGateway {

    boolean depotIsInsufficient(int orderAmount, String drugName, String depotName);

    void fulfillOrder(DrugFulfillDsRequestModel fulfillModel);
    Map<String, DrugFulfillDsRequestModel> getMadeOrders();
}
