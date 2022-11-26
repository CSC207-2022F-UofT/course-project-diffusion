package drug_search_use_case;

import drug_search_entities.DrugInfo;

import java.util.*;

/**
 * Represents a search response, carrying lists of {@link DrugInfo} objects based on a {@link SearchRequest}.
 */
public class SearchResponse {
    public SearchResponse(List<DrugRequestDatabaseEntry> results, String message) {
        this.results = results;
        this.message = message;
    }

    /**
     * Gets a list of database entries matching the associated search request.
     */
    public List<DrugRequestDatabaseEntry> getResults() {
        return results;
    }

    /**
     * Gets the message accompanying the search result, if any.
     */
    public String getMessage() {
        return message;
    }

    private final List<DrugRequestDatabaseEntry> results;
    private final String message;

    public class DrugRequestDatabaseEntry {
        public DrugRequestDatabaseEntry(String accountId, String requestId, String siteId, String drugName,
                                        String quantity, Date date) {
            this.accountId = accountId;
            this.requestId = requestId;
            this.siteId = siteId;
            this.drugName = drugName;
            this.quantity = quantity;
            this.date = date;
        }

        /**
         * Gets the account ID of the drug request database entry.
         */
        public String getAccountId() { return accountId; }
        /**
         * Gets the request ID of the drug request database entry.
         */
        public String getRequestId() { return requestId; }
        /**
         * Gets the site ID of the drug request database entry.
         */
        public String getSiteId() { return siteId; }
        /**
         * Gets the drug name of the drug request database entry.
         */
        public String getDrugName() { return drugName; }
        /**
         * Gets the quantity of the drug request database entry.
         */
        public String getQuantity() { return quantity; }
        /**
         * Gets the date on which the drug request database entry was created.
         */
        public Date getDate() { return date; }

        private final String accountId;
        private final String requestId;
        private final String siteId;
        private final String drugName;
        private final String quantity;
        private final Date date;
    }
}
