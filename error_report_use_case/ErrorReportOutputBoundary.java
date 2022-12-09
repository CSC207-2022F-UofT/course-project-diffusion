package error_report_use_case;

public interface ErrorReportOutputBoundary {
    ErrorReportResponseModel prepareSuccessView (ErrorReportResponseModel used);
    ErrorReportResponseModel prepareFailView (String error);
}