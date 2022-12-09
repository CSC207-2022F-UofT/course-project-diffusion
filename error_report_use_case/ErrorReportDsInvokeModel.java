package error_report_use_case;

public class ErrorReportDsInvokeModel {
    private boolean wrongOrder;
    private int amount;

    public ErrorReportDsInvokeModel(boolean wrongOrder, int amount) {
        this.wrongOrder = wrongOrder;
        this.amount = amount;
    }

    public boolean getWrongOrder(){ return wrongOrder; }

    public int getAmount(){ return amount; }

    public void setAmount(boolean wrongOrder){ this.wrongOrder = wrongOrder; }

    public void setAmount(int amount){ this.amount = amount; }
}
