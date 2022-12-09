package error_report.error_reporting_entity;

public interface ErrorGenerator {
    Error create(boolean wrongOrder, boolean expired, boolean wrongAmount, int amountWrong, int amountExpired, int amountMoreThan, String drugReceived);
}
