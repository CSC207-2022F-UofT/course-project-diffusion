package error_report.error_report_use_case;

public class ErrorReportResponseModel {
    String drugName;
    int number;

    public ErrorReportResponseModel(String drugName, int number) {

        this.drugName = drugName;
        this.number = number;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getNumber() {return number;}

    public void setNumber(int number) {this.number = number;}
}
