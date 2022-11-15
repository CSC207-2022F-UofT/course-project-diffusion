package receive_request_entity;

public class CommonValidRequest implements ValidRequest{
    final private String drugName;
    final private String drugBottle;

    public CommonValidRequest(String drugName, String drugBottle) {
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    @Override
    public boolean nameValid() {
        return true;
    }

    @Override
    public boolean bottleValid() {
        return true;
    }

    @Override
    public boolean checkInventory() {
        // to be fixed when inventory system implemented
        return this.nameValid() && this.bottleValid();
    }

    @Override
    public String getName() { return drugName; }

    @Override
    public String getBottle() {
        return drugBottle;
    }
}
