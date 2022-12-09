package error_report.error_report_use_case;

public interface ErrorReportInputBoundary {
    ErrorReportResponseModel create(ErrorReportInvokeModel errorReportInvokeModel);
}
