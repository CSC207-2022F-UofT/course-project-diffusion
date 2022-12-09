package drug_fulfill.drug_fulfill_frameworks_drivers;

/**
 * Construct Order failed for when order fails.
 */
public class OrderFailed extends RuntimeException {
    public OrderFailed(String error) {
        super(error);
    }
}
