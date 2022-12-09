package error_report_use_case;

import drug_fulfill_entities.DrugFulfill;
import drug_fulfill_entities.DrugFulfillFactory;
import drug_fulfill_interface_adapters.DrugFulfillPresenter;
import drug_fulfill_use_case.DrugFulfillResponseModel;
import error_reporting_entity.ErrorReportGenerator;
import drug_fulfill_frameworks_drivers.FileDepotInventoryA;
import drug_fulfill_use_case.DrugFulfillDsRequestModel;
import drug_fulfill_use_case.DrugFulfillDsGateway;
import error_reporting_entity.ErrorReport;

import java.time.LocalDateTime;

public class ErrorReportInteractor implements ErrorReportInputBoundary {
    final ErrorReportDsGateway errorReportDsGateway;
    final ErrorReportOutputBoundary errorReportOutputBoundary;
    final ErrorReportGenerator errorReportGenerator;
    final DrugFulfillDsGateway fulfillDsGateway;
    //final some_presenter presenter;
    final DrugFulfillPresenter orderPresenter;
    final DrugFulfillFactory fulfillFactory;


    public ErrorReportInteractor(ErrorReportDsGateway errorReportDsGateway,
                                 ErrorReportOutputBoundary errorReportOutputBoundary,
                                 ErrorReportGenerator errorReportGenerator, DrugFulfillDsGateway fulfillDsGateway,
                                 DrugFulfillPresenter orderPresenter, DrugFulfillFactory fulfillFactory) {
        this.errorReportDsGateway = errorReportDsGateway;
        this.errorReportOutputBoundary = errorReportOutputBoundary;
        this.errorReportGenerator = errorReportGenerator;
        this.fulfillDsGateway = fulfillDsGateway;
        this.orderPresenter = orderPresenter;
        this.fulfillFactory = fulfillFactory;
    }

    @Override
    public ErrorReportResponseModel create(ErrorReportInvokeModel errorReportInvokeModel) {
        DrugFulfill order = fulfillFactory.create(errorReportInvokeModel.getDrugName(),
                errorReportInvokeModel.getAmount(), Boolean.FALSE);
        LocalDateTime now = LocalDateTime.now();
        int x = -errorReportInvokeModel.getAmount();
        DrugFulfillDsRequestModel OrderDsModel = new DrugFulfillDsRequestModel(errorReportInvokeModel.getDrugName(),
                x, now, Boolean.FALSE);
        fulfillDsGateway.fulfillOrder(OrderDsModel);
        return null;
    }
}
