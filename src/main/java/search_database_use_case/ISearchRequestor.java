package search_database_use_case;

public interface ISearchRequestor {
    /**
     * Searches the application database for {@link entities.DrugInfo} matching the criteria in the search request.
     *
     * @param request The data to search for.
     */
    void searchFor(SearchRequest request);
}
