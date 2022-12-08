package drug_search.use_case;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Represents a drug request database entry.
 */
public class DrugRequestDBEntry {
    public DrugRequestDBEntry(String requestId, String siteId, String accountId, String drugName,
                              int quantity, LocalDateTime date) {
        this.requestId = requestId;
        this.siteId = siteId;
        this.accountId = accountId;
        this.drugName = drugName;
        this.quantity = quantity;
        this.date = date;
    }

    /**
     * Gets the ID of the drug request.
     */
    public String getRequestId() {
        return requestId;
    }
    /**
     * Gets the site ID of the drug request.
     */
    public String getSiteId() {
        return siteId;
    }
    /**
     * Gets the account ID of the drug request.
     */
    public String getAccountId() {
        return accountId;
    }
    /**
     * Gets the name of the requested drug.
     */
    public String getDrugName() {
        return drugName;
    }
    /**
     * Gets the quantity of the drugs requested.
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Gets the date and time at which the request was made.
     */
    public LocalDateTime getDate() {
        return date;
    }

    private final String requestId;
    private final String siteId;
    private final String accountId;
    private final String drugName;
    private final int quantity;
    private final LocalDateTime date;
}
