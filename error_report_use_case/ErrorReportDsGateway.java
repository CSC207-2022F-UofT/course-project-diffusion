package error_report_use_case;

public interface ErrorReportDsGateway {
    boolean isValidNumber(String number);
    boolean fulfillOrder(ErrorReportDsInvokeModel errorReportDsInvokeModel);
}
