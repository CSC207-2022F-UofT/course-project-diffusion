package drug_fulfill.drug_fulfill_use_case;

import java.util.Map;

/**
 * Data access interface between Drug fulfill interactor and site database data access.
 */
public interface SiteDrugFulfillDsGateway {
    void fulfillOrderToSite(SiteDrugFulfillDsRequestModel fulfillModel);
    Map<String, SiteDrugFulfillDsRequestModel> getMadeOrders();
}
