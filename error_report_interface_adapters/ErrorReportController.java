package error_report_interface_adapters;

import drug_fulfill.drug_fulfill_use_case.DrugFulfillRequestModel;
import drug_fulfill.drug_fulfill_use_case.DrugFulfillResponseModel;
import error_report_use_case.ErrorReportInputBoundary;
import error_report_use_case.ErrorReportInvokeModel;
import error_report_use_case.ErrorReportResponseModel;

public class ErrorReportController {
    ErrorReportInputBoundary errorReportInputBoundary;

    public ErrorReportController(ErrorReportInputBoundary errorReportGateway) {
        this.errorReportInputBoundary = errorReportGateway;
    }

    public ErrorReportResponseModel create(String drug, int bottle) {
        ErrorReportInvokeModel errorReportInvokeModel = new ErrorReportInvokeModel(drug, bottle);

        return errorReportInputBoundary.create(errorReportInvokeModel);
    }
}
