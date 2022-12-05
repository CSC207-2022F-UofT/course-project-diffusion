package drug_search_use_case;

public interface ISearchRequestor {
    /**
     * Searches the application database for {@link DrugRequestDBEntry} matching the criteria in the search request.
     *
     * @param request The data to search for.
     */
    void searchFor(SearchRequest request);
}
