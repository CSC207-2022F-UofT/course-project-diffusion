package drug_fulfill.drug_fulfill_use_case;

/**
 * InputBoundary between controller and drug fullfill interactor.
 */
public interface DrugFulfillInputBoundary {
    DrugFulfillResponseModel create(DrugFulfillRequestModel requestModel);
}
