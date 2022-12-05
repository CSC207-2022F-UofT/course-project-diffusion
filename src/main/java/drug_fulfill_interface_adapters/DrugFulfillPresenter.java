package drug_fulfill_interface_adapters;

// Use case layer

import drug_fulfill_use_case.DrugFulfillResponseModel;

public interface DrugFulfillPresenter {
    DrugFulfillResponseModel prepareSuccessView(DrugFulfillResponseModel emergencyOrder);

    DrugFulfillResponseModel prepareFailView(String error);
}