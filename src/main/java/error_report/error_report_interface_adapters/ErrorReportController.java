package error_report.error_report_interface_adapters;

import error_report.error_report_use_case.ErrorReportInputBoundary;
import error_report.error_report_use_case.ErrorReportInvokeModel;
import error_report.error_report_use_case.ErrorReportResponseModel;

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
