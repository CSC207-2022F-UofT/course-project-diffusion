package search_database_use_case;

/**
 * Represents a user-generated search request.
 */
public class SearchRequest {
    public SearchRequest(String term, boolean generic, boolean brand, boolean alternatives) {
        searchTerm = term;
        includeGeneric = generic;
        includeBrand = brand;
        includeAlternatives = alternatives;
    }

    /**
     * @return The specified search term.
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * @return Whether to include generic items in the search response.
     */
    public boolean getIncludeGeneric() {
        return includeGeneric;
    }

    /**
     * @return Whether to include branded items in the search response.
     */
    public boolean getIncludeBrand() {
        return includeBrand;
    }

    /**
     * @return Whether to include alternative items in the search response.
     */
    public boolean getIncludeAlternatives() {
        return includeAlternatives;
    }

    private final String searchTerm;
    private final boolean includeGeneric;
    private final boolean includeBrand;
    private final boolean includeAlternatives;

    // Add more fields if necessary
}
