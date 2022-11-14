package drug_request_use_case;

public class DrugRequestResponseModel {

    String drugRequest;
    String creationTime;

    public DrugRequestResponseModel(String drugRequest, String creationTime){
        this.drugRequest = drugRequest;
        this.creationTime = creationTime;
    }

    public String getDrugRequest(){
        return drugRequest;
    }

    public void setDrugRequest(String drugRequest) {
        this.drugRequest = drugRequest;
    }

    public String getCreationTime(){
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
