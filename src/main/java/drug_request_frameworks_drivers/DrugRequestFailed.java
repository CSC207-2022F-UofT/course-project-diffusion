package drug_request_frameworks_drivers;

public class DrugRequestFailed extends RuntimeException{
    public DrugRequestFailed(String error){
        super(error);
    }
}
