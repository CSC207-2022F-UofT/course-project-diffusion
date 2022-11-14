package drug_fulfill_use_case;

// Use case layer

public interface DrugRequestPresenter {
    EmergencyOrderResponseModel prepareSuccessView(EmergencyOrderResponseModel emergencyOrder);

    EmergencyOrderResponseModel prepareFailView(String error);
}