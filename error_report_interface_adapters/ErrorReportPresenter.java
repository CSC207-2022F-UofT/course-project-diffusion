package error_report_interface_adapters;

import error_report_use_case.ErrorReportResponseModel;

public interface ErrorReportPresenter {
    ErrorReportResponseModel prepareSuccessView(ErrorReportResponseModel error);
    ErrorReportResponseModel prepareFailView(String error);
}
