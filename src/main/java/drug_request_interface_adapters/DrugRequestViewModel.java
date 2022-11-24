package drug_request_interface_adapters;


public class DrugRequestViewModel {

//    DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary;
//    DrugRequestResponseModel drugRequestResponseModel;
    String drugName;
    String drugBottle;
    String creationTime;
    public DrugRequestViewModel(String drugName, String drugBottle, String creationTime){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
        this.creationTime = creationTime;
    }

//    public DrugRequestPresenterOutputBoundary getDrugRequestPresenterOutputBoundary() {
//        return drugRequestPresenterOutputBoundary;
//    }
//
//    public void setDrugRequestPresenterOutputBoundary(DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary) {
//        this.drugRequestPresenterOutputBoundary = drugRequestPresenterOutputBoundary;
//    }
//
//    public DrugRequestResponseModel getDrugRequestResponseModel() {
//        return drugRequestResponseModel;
//    }
//
//    public void setDrugRequestResponseModel(DrugRequestResponseModel drugRequestResponseModel) {
//        this.drugRequestResponseModel = drugRequestResponseModel;
//    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugBottle() {
        return drugBottle;
    }

    public void setDrugBottle(String drugBottle) {
        this.drugBottle = drugBottle;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
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
