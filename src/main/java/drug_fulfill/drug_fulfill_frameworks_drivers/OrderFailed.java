package drug_fulfill.drug_fulfill_frameworks_drivers;

public class OrderFailed extends RuntimeException {
    public OrderFailed(String error) {
        super(error);
    }
}
