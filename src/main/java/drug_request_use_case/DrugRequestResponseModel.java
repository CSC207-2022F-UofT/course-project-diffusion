package drug_request_use_case;

public class DrugRequestResponseModel{

    String drugName;
    String drugBottle;
    String creationTime;

    public DrugRequestResponseModel(){
//        this.drugName = drugName;
//        this.creationTime = creationTime;
//        this.drugBottle = drugBottle;


    }

    public String getDrugName(){
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public void getDrugBottle(String drugBottle){
        this.drugBottle = drugBottle;
    }

    public void setDrugBottle(String drugBottle) {
        this.drugBottle = drugBottle;
    }

    public String getCreationTime(){
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
