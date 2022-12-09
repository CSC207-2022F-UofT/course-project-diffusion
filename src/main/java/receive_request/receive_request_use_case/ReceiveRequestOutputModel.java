package receive_request.receive_request_use_case;

public class ReceiveRequestOutputModel{
    boolean nameExist;
    boolean sufficientQuantity;
    /**
     * The default output is false
     */
    public ReceiveRequestOutputModel() {
        this.nameExist = false;
        this.sufficientQuantity = false;
    }

    public boolean getNameExist() {
        return nameExist;
    }

    public boolean getSufficientQuantity() {
        return sufficientQuantity;
    }

    public void setNameExistTrue
            () {
        this.nameExist = true;
    }

    public void setSufficientQuantityTrue() {
        this.sufficientQuantity = true;
    }
}
