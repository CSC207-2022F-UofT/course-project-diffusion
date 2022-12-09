package drug_search.use_case;

import java.time.LocalDateTime;

/**
 * Represents a user-generated search request.
 */
public class SearchRequest {
    public SearchRequest(String message, String accountId, String requestId, String siteId, String drugName, int quantity,
                         boolean dateSearch, LocalDateTime date, int relativity) {
        this.message = message;
        this.accountId = accountId;
        this.requestId = requestId;
        this.siteId = siteId;
        this.drugName = drugName;
        this.quantity = quantity;
        this.dateSearch = dateSearch;
        this.date = date;
        this.relativity = relativity;
    }

    /**
     * Gets the message associated with the search request.
     */
    public String getMessage() { return message; }
    /**
     * Gets the account ID to search for, if any.
     */
    public String getAccountId() { return accountId; }
    /**
     * Gets the request ID to search for, if any.
     */
    public String getRequestId() { return requestId; }
    /**
     * Gets the site ID to search for, if any.
     */
    public String getSiteId() { return siteId; }
    /**
     * Gets the drug name to search for, if any.
     */
    public String getDrugName() { return drugName; }
    /**
     * Gets the quantity requested to search for, if any.
     */
    public int getQuantity() { return quantity; }
    /**
     * Gets whether the search request includes date information.
     */
    public boolean isDateSearch() { return dateSearch; }
    /**
     * Gets the date to search for, if any.
     */
    public LocalDateTime getDate() { return date; }
    /**
     * Gets an integer representing how the date search functions: 1 to search for requests after the given date, -1
     * to search for requests before it, and 0 to search for requests on it.
     */
    public int getRelativity() { return relativity; }

    private final String message;
    private final String accountId;
    private final String requestId;
    private final String siteId;
    private final String drugName;
    private final int quantity;
    private final boolean dateSearch;
    private final LocalDateTime date;
    private final int relativity;
}
