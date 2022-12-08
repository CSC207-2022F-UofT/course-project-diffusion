package drug_search.use_case;

public interface ISearchResponder {
    /**
     * Displays search response data to the user.
     *
     * @param response The data to display.
     */
    void searchRespond(SearchResponse response);
}
