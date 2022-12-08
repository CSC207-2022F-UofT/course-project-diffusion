package receive_request.receive_request_use_case;

public class ReceiveRequestInputModel {
    final private String drugName;
    final private String drugBottle;

    /**
     * Input of the form drugName and drugBottle is converted to Input Model
     */
    public ReceiveRequestInputModel(String drugName, String drugBottle) {
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    public String getName() {
        return drugName;
    }

    public String getBottle() {
        return drugBottle;
    }
}