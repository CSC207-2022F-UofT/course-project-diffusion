package error_report.error_report_use_case;

public class ErrorReportInvokeModel {

    private int amount;
    private String drugName;

    public ErrorReportInvokeModel(String drugName, int amount) {
        this.amount = amount;
        this.drugName = drugName;
    }

    public int getAmount(){ return amount; }

    public String getDrugName() {
        return drugName;
    }

    public void setAmount(int amount){ this.amount = amount; }

    public void setDrugName(String drugName) { this.drugName = drugName; }
}
