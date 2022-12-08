package receive_request.receive_request_use_case;

public class ReceiveRequestInputModel implements ReceiveRequestInputBoundary{
    private String drugName;
    private String drugBottle;

    public ReceiveRequestInputModel(String drugName, String drugBottle) {
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    @Override
    public String getName() {
        return drugName;
    }

    @Override
    public String getBottle() {
        return drugBottle;
    }

    @Override
    public void setName(String drugName) {
        this.drugName = drugName;
    }

    @Override
    public void setBottle(String drugBottle) {
        this.drugBottle = drugBottle;
    }
}