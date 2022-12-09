package drug_fulfill.drug_fulfill_interface_adapters;

// Use case layer

import drug_fulfill.drug_fulfill_use_case.DrugFulfillResponseModel;

/**
 * Presenter used to output successes or failures for Drug fulfill.
 */
public interface DrugFulfillPresenter {
    DrugFulfillResponseModel prepareSuccessView(DrugFulfillResponseModel emergencyOrder);

    DrugFulfillResponseModel prepareFailView(String error);
}