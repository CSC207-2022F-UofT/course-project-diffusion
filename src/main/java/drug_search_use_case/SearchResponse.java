package drug_search_use_case;

import drug_search_entities.DrugRequestDBEntry;

import java.util.*;

/**
 * Represents a search response, carrying lists of {@link DrugRequestDBEntry} objects based on a {@link SearchRequest}.
 */
public class SearchResponse {
    public SearchResponse(List<DrugRequestDBEntry> results, String message) {
        this.results = results;
        this.message = message;
    }

    /**
     * Gets a list of database entries matching the associated search request.
     */
    public List<DrugRequestDBEntry> getResults() {
        return results;
    }

    /**
     * Gets the message accompanying the search result, if any.
     */
    public String getMessage() {
        return message;
    }

    private final List<DrugRequestDBEntry> results;
    private final String message;
}
