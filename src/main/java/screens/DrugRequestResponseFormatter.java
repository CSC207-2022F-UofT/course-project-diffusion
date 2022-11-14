package screens;

import drug_fulfill_use_case.DrugRequestPresenter;
import drug_fulfill_use_case.EmergencyOrderResponseModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class DrugRequestResponseFormatter implements DrugRequestPresenter {

    @Override
    public EmergencyOrderResponseModel prepareSuccessView(EmergencyOrderResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public EmergencyOrderResponseModel prepareFailView(String error) {
        throw new OrderFailed(error);
    }
}
