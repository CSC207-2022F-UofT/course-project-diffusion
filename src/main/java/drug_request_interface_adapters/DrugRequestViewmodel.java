package drug_request_interface_adapters;

import drug_request_use_case.DrugRequestResponseModel;


public class DrugRequestViewmodel {

    DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary;
    DrugRequestResponseModel drugRequestResponseModel;
    String drugName;
    String drugBottle;
    String creationTime;
    public DrugRequestViewmodel(){
        drugRequestResponseModel = new DrugRequestResponseModel();
    }



//            (String drugName, String creationTime, String drugBottle){
//        this.drugName = drugName;
//        this.drugBottle = drugBottle;
//        this.creationTime = creationTime;
//    }
//
//    public void setDrugName(String drugName) {
//        this.drugName = drugName;
//    }
//
//    public String getDrugBottle() {
//        return drugBottle;
//    }
//
//    public void setDrugBottle(String drugBottle) {
//        this.drugBottle = drugBottle;
//    }
//
//    public String getCreationTime() {
//        return creationTime;
//    }
//
//    public void setCreationTime(String creationTime) {
//        this.creationTime = creationTime;
//    }
//
//    public String getDrugName() {
//        return drugName;
//    }
//    public drugRequestResponseModel() = new DrugRequestResponseModel()
//
//    }

}
