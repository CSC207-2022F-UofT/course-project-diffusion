package site_drug_request.drug_request_use_case;

public class DrugRequestInvokeModel {
    private String drugName;
    private String drugBottle;

    public DrugRequestInvokeModel(String drugName, String drugBottle){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
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
}
