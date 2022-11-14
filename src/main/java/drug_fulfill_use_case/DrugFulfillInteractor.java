package drug_fulfill_use_case;

import drug_fulfill_entities.DrugFulfill;
import drug_fulfill_entities.DrugFulfillFactory;

import java.time.LocalDateTime;

public class DrugFulfillInteractor implements DrugFulfillInputBoundary {
    final DrugFulfillDsGateway fulfillDsGateway;
    //final some_presenter presenter;
    final DrugRequestPresenter orderPresenter;
    final DrugFulfillFactory fulfillFactory;



    public DrugFulfillInteractor(DrugFulfillDsGateway fulfillDsGateway, DrugRequestPresenter drugPresenter, DrugFulfillFactory fulfillFactory) {
        this.fulfillDsGateway = fulfillDsGateway;
        this.orderPresenter = drugPresenter;
        this.fulfillFactory = fulfillFactory;
    }

    @Override
    public EmergencyOrderResponseModel create(DrugFulfillRequestModel requestModel) {
        //figure out from which depot we want based on position of site / site list?
        int depot_num = 5; //example
        if (!fulfillDsGateway.isInt(Integer.toString(requestModel.getDrugBottle()))){
            return orderPresenter.prepareFailView("Put in a number");
        }

        DrugFulfill order = fulfillFactory.create(requestModel.getDrugName(), requestModel.getDrugBottle(), requestModel.getIsEmergency());

        if (!order.drugNameIsValid(requestModel.getDrugName())) {
            return orderPresenter.prepareFailView("WTF IS GOING ONNNN XD");
        }

        LocalDateTime now = LocalDateTime.now();
        DrugFulfillDsRequestModel OrderDsModel = new DrugFulfillDsRequestModel(order.getDrugName(), order.getDrugBottle(), now, order.getIsEmergency());
        fulfillDsGateway.fulfillOrder(OrderDsModel);

        //return presenter change to ordered from depot #

        EmergencyOrderResponseModel orderResponseModel = new EmergencyOrderResponseModel(order.getDrugName(), now.toString(), order.getIsEmergency());
        return orderPresenter.prepareSuccessView(orderResponseModel);
    }
}
