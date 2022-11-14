package drug_fulfill_use_case;

public interface DrugFulfillInputBoundary {
    EmergencyOrderResponseModel create(DrugFulfillRequestModel requestModel);
}
