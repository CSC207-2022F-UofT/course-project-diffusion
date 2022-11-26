package drug_search_use_case;

import java.util.ArrayList;

/**
 * Takes user-generated search request data and displays a list of drug items matching the given criteria.
 */
public class SearchUseCase implements ISearchRequestor {
    public SearchUseCase(ISearchResponder searchResponder) {
        this.searchResponder = searchResponder;
    }

    /**
     * Searches the application database for {@link drug_search_entities.DrugInfo} matching the criteria in the search request.
     *
     * @param request The data to search for.
     */
    public void searchFor(SearchRequest request) {
        // todo implement this

        // Placeholder code
        SearchResponse response = new SearchResponse(new ArrayList<>(), "Placeholder message");

        searchResponder.searchRespond(response);
    }

    private final ISearchResponder searchResponder;
}
