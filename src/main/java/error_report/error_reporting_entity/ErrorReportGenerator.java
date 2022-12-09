package error_report.error_reporting_entity;

public class ErrorReportGenerator implements ErrorGenerator {
    public Error create(boolean wrongOrder, boolean expired, boolean wrongAmount, int amountWrong, int amountExpired, int amountMoreThan, String drugReceived) {
        return new ErrorReport(wrongOrder, expired, wrongAmount, amountWrong, amountExpired, amountMoreThan, drugReceived);
    }
}
