package drug_fulfill.drug_fulfill_use_case;

import drug_fulfill.drug_fulfill_entities.DrugFulfill;
import drug_fulfill.drug_fulfill_entities.DrugFulfillFactory;
import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillPresenter;

import java.time.LocalDateTime;

public class DrugFulfillInteractor implements DrugFulfillInputBoundary {
    final DrugFulfillDsGateway fulfillDsGateway;
    final DrugFulfillPresenter orderPresenter;
    final DrugFulfillFactory fulfillFactory;
    final SiteDrugFulfillDsGateway sitefulfillDsGateway;


    /**
     * @param fulfillDsGateway Interface Depot Inventory CSV database methods.
     * @param drugPresenter Interface for presenting views for screen.
     * @param fulfillFactory Interface user input to fulfill orders.
     */
    public DrugFulfillInteractor(DrugFulfillDsGateway fulfillDsGateway, DrugFulfillPresenter drugPresenter,
                                 DrugFulfillFactory fulfillFactory, SiteDrugFulfillDsGateway sitefulfillDsGateway) {
        this.fulfillDsGateway = fulfillDsGateway;
        this.orderPresenter = drugPresenter;
        this.fulfillFactory = fulfillFactory;
        this.sitefulfillDsGateway = sitefulfillDsGateway;
    }

    @Override
    public DrugFulfillResponseModel create(DrugFulfillRequestModel requestModel) {

        DrugFulfill order = fulfillFactory.create(requestModel.getDrugName(), requestModel.getDrugBottle(),
                requestModel.getIsEmergency(), requestModel.getDepot(), requestModel.getSite());



        LocalDateTime now = LocalDateTime.now();
        DrugFulfillDsRequestModel OrderDsModel = new DrugFulfillDsRequestModel(order.getDrugName(),
                order.getDrugBottle(), now, order.getIsEmergency(), order.getDepotName());
        SiteDrugFulfillDsRequestModel OrderDsModelSite = new SiteDrugFulfillDsRequestModel(order.getDrugName(),
                order.getDrugBottle(), now, order.getIsEmergency(), order.getSiteName());
        /**
         * Check if depot the order is going to have sufficient inventory.
         * If yes, execute method fulfillOrder to adjust hashmap and CSV database for both Site and Depot.
         * Else, will notify depot user of insufficient drug amount.
         */
        if (!fulfillDsGateway.depotIsInsufficient(order.getDrugBottle(), order.getDrugName(), order.getDepotName())){
            fulfillDsGateway.fulfillOrder(OrderDsModel);
            sitefulfillDsGateway.fulfillOrderToSite(OrderDsModelSite);
        } else {
            System.out.println("Insufficient depot amount");
            return orderPresenter.prepareFailView("Insufficient depot amount");

        }

        DrugFulfillResponseModel orderResponseModel = new DrugFulfillResponseModel(order.getDrugName(), now.toString(), order.getIsEmergency(), 1, order.getDepotName(), order.getSiteName()); //arbitrary placeholders
        return orderPresenter.prepareSuccessView(orderResponseModel);

    }
}
