package drug_fulfill.drug_fulfill_use_case;

import java.util.Map;

public interface SiteDrugFulfillDsGateway {
    void fulfillOrderToSite(SiteDrugFulfillDsRequestModel fulfillModel);
    Map<String, SiteDrugFulfillDsRequestModel> getCurrentInventory();
    Map<String, SiteDrugFulfillDsRequestModel> getMadeOrders();
}
