package receive_request.receive_request_use_case;

public class ReceiveRequestOutputModel{
    boolean nameExist;
    boolean suffientQauntity;
    /**
     * The default output is false
     */
    public ReceiveRequestOutputModel() {
        this.nameExist = false;
        this.suffientQauntity = false;
    }

    public boolean getNameExist() {
        return nameExist;
    }

    public boolean getSuffientQauntity() {
        return suffientQauntity;
    }

    public void setNameExistTrue() {
        this.nameExist = true;
    }

    public void setSuffientQauntityTrue() {
        this.suffientQauntity = true;
    }
}
