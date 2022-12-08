package drug_fulfill.drug_fulfill_use_case;

import drug_fulfill.drug_fulfill_entities.DrugFulfill;
import drug_fulfill.drug_fulfill_entities.DrugFulfillFactory;
import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillPresenter;

import java.time.LocalDateTime;

public class DrugFulfillInteractor implements DrugFulfillInputBoundary {
    final DrugFulfillDsGateway fulfillDsGateway;
    //final some_presenter presenter;
    final DrugFulfillPresenter orderPresenter;
    final DrugFulfillFactory fulfillFactory;



    public DrugFulfillInteractor(DrugFulfillDsGateway fulfillDsGateway, DrugFulfillPresenter drugPresenter, DrugFulfillFactory fulfillFactory) {
        this.fulfillDsGateway = fulfillDsGateway;
        this.orderPresenter = drugPresenter;
        this.fulfillFactory = fulfillFactory;
    }

    @Override
    public DrugFulfillResponseModel create(DrugFulfillRequestModel requestModel) {
        //figure out from which depot we want based on position of site / site list?
        int depot_num = 5; //example
        if (!fulfillDsGateway.isInt(Integer.toString(requestModel.getDrugBottle()))){
            return orderPresenter.prepareFailView("Put in a number");
        }

        DrugFulfill order = fulfillFactory.create(requestModel.getDrugName(), requestModel.getDrugBottle(), requestModel.getIsEmergency(), requestModel.getDepot());

        if (!order.drugNameIsValid(requestModel.getDrugName())) {
            return orderPresenter.prepareFailView("WTF IS GOING ONNNN XD");
        }

        LocalDateTime now = LocalDateTime.now();
        DrugFulfillDsRequestModel OrderDsModel = new DrugFulfillDsRequestModel(order.getDrugName(), order.getDrugBottle(), now, order.getIsEmergency(), order.getDepotName());

        if (!fulfillDsGateway.depotIsInsufficient(order.getDrugBottle(), order.getDrugName(), order.getDepotName())){
            fulfillDsGateway.fulfillOrder(OrderDsModel);
        } else {
            System.out.println("Insufficient depot amount");
        }


        //return presenter change to ordered from depot #

        DrugFulfillResponseModel orderResponseModel = new DrugFulfillResponseModel(order.getDrugName(), now.toString(), order.getIsEmergency());
        return orderPresenter.prepareSuccessView(orderResponseModel);
    }
}
