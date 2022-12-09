package drug_fulfill.drug_fulfill_interface_adapters;

import drug_fulfill.drug_fulfill_frameworks_drivers.OrderFailed;
import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillPresenter;
import drug_fulfill.drug_fulfill_use_case.DrugFulfillResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

/**
 * Formats output for success and failures.
 */
public class DrugFulfillResponseFormatter implements DrugFulfillPresenter {

    @Override
    public DrugFulfillResponseModel prepareSuccessView(DrugFulfillResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public DrugFulfillResponseModel prepareFailView(String error) {
        throw new OrderFailed(error);
    }
}
