package search_database_use_case;

public interface ISearchResponder {
    /**
     * Displays search response data to the user.
     *
     * @param response The data to display.
     */
    void searchRespond(SearchResponse response);
}
