package drug_fulfill_use_case;

public interface DrugFulfillInputBoundary {
    DrugFulfillResponseModel create(DrugFulfillRequestModel requestModel);
}
