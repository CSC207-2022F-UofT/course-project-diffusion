package drug_request_interface_adapters;

import drug_request_frameworks_drivers.DrugRequestFailed;
import drug_request_use_case.DrugRequestOutputBoundary;
import drug_request_use_case.DrugRequestResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DrugRequestPresenter implements DrugRequestOutputBoundary {
    @Override
    public DrugRequestResponseModel prepareSuccessView(DrugRequestResponseModel responseModel) {
        LocalDateTime responseDate = LocalDateTime.parse(responseModel.getCreationTime());
        responseModel.setCreationTime(responseDate.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return responseModel;
    }

    @Override
    public DrugRequestResponseModel prepareFailView(String error) {
        throw new DrugRequestFailed(error);
    }
}
