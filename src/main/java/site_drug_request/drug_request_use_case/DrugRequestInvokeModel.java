package site_drug_request.drug_request_use_case;

public class DrugRequestInvokeModel {
    private String drugName;
    private String drugBottle;
    private String siteName;
    private String accountID;

    public DrugRequestInvokeModel(String drugName, String drugBottle, String siteName, String accountID){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
        this.siteName = siteName;
        this.accountID = accountID;
    }

    String getDrugName(){
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    String getDrugBottle(){
        return drugBottle;
    }

    public void setDrugBottle(String drugBottle) {
        this.drugBottle = drugBottle;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
