package drug_search.interface_adapters;

import drug_search.use_case.ISearchRequestor;
import drug_search.use_case.SearchRequest;

import javax.swing.*;
import java.time.LocalDateTime;

public class DrugSearchController {
    public DrugSearchController(ISearchRequestor searchRequestor) {
        this.searchRequestor = searchRequestor;
    }

    /**
     * Sends a search request to the use case interactor containing the specified search parameters.
     */
    public void sendSearchRequest(String accountId, String requestId, String siteId, String drugName,
                                     String quantity, boolean dateSearch, int relativity, int year,
                                     int month, int day) {
        int parsedQuantity = 0;
        String message = null;

        // Try parse quantity requested
        if (quantity != null && !quantity.isBlank()) {
            try {
                parsedQuantity = Integer.parseInt(quantity);
            }
            catch (Exception e) {
                message = "Quantity requested must be an integer, please try again.";
            }
        }

        LocalDateTime date = LocalDateTime.now();

        // Ensure selected date is valid
        if (dateSearch) {
            try {
                date = LocalDateTime.of(year, month, day, 0, 0);
            }
            catch (Exception e) {
                message = "Impossible date selection, please try again!";
            }
        }

        // Send search request
        SearchRequest request = new SearchRequest(message, accountId, requestId, siteId, drugName, parsedQuantity,
                dateSearch, date, relativity);

        searchRequestor.searchFor(request);
    }

    private final ISearchRequestor searchRequestor;
}
