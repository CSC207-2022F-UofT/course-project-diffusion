package error_report.error_reporting_entity;

public interface Error {
    boolean wrongOrder();
    boolean expired();
    boolean wrongAmount();
    int amountWrong();
    int amountExpired();
    int amountMoreThat();
    String drugReceived();
}