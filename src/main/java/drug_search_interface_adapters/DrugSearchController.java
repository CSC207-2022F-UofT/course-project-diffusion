package drug_search_interface_adapters;

import drug_search_use_case.ISearchRequestor;
import drug_search_use_case.SearchRequest;

import java.time.LocalDateTime;

public class DrugSearchController {
    public DrugSearchController(ISearchRequestor searchRequestor) {
        this.searchRequestor = searchRequestor;
    }

    /**
     * Sends a search request to the use case interactor containing the specified search parameters.
     */
    public void sendSearchRequest(String accountId, String requestId, String siteId, String drugName, String quantity,
                                  boolean dateSearch, LocalDateTime date, int relativity) {
        SearchRequest request = new SearchRequest(accountId, requestId, siteId, drugName, quantity,
                dateSearch, date, relativity);

        searchRequestor.searchFor(request);
    }

    private final ISearchRequestor searchRequestor;
}
