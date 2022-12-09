package error_reporting_entity;

public class ErrorReport implements Error{
    private boolean wrongOrder;
    private boolean expired;
    private boolean wrongAmount;
    private int amountWrong;
    private int amountExpired;
    private int amountMoreThan;
    private String drugReceived;

    ErrorReport(boolean wrongOrder, boolean expired, boolean wrongAmount, int amountWrong, int amountExpired, int amountMoreThan, String drugReceived) {
        this.wrongOrder = wrongOrder;
        this.expired = expired;
        this.wrongAmount = wrongAmount;
        this.amountWrong = amountWrong;
        this.amountExpired = amountExpired;
        this.amountMoreThan = amountMoreThan;
        this.drugReceived = drugReceived;
    }

    @Override
    public boolean wrongOrder() {
        return wrongOrder;
    }

    @Override
    public boolean expired() {
        return expired;
    }

    @Override
    public boolean wrongAmount() {
        return wrongAmount;
    }

    @Override
    public int amountWrong() {
        return amountWrong;
    }

    @Override
    public int amountExpired() {
        return amountExpired;
    }

    @Override
    public int amountMoreThat() {
        return amountMoreThan;
    }

    @Override
    public String drugReceived() {
        return drugReceived;
    }
}
