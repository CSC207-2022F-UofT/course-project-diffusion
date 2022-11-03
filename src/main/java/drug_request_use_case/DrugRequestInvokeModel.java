package drug_request_use_case;

public class DrugRequestInvokeModel {
    private String drugName;
    private int drugBottle;

    public DrugRequestInvokeModel(String drugName, int drugBottle){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    String getDrugName(){
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    int getDrugBottle(){
        return drugBottle;
    }

    public void setDrugBottle(int drugBottle) {
        this.drugBottle = drugBottle;
    }
}
