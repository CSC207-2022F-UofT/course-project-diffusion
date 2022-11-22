package drug_search_use_case;

import drug_search_entities.DrugInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a search response, carrying lists of {@link DrugInfo} objects based on a {@link SearchRequest}.
 */
public class SearchResponse {
    public SearchResponse(ArrayList<DrugInfo> all, ArrayList<DrugInfo> alternative, ArrayList<DrugInfo> recommended) {
        allMatches = all;
        alternativeMatches = alternative;
        recommendations = recommended;
    }

    /**
     * @return A list of all {@link DrugInfo} objects matching the associated {@link SearchRequest}.
     */
    public List<DrugInfo> getAllMatches() {
        return allMatches;
    }

    /**
     * @return A list of all alternative {@link DrugInfo} objects based on the associated {@link SearchRequest}.
     */
    public List<DrugInfo> getAlternativeMatches() {
        return alternativeMatches;
    }

    /**
     * @return A list of all recommended {@link DrugInfo} objects based on the associated {@link SearchRequest}.
     */
    public List<DrugInfo> getRecommendations() {
        return recommendations;
    }

    private final ArrayList<DrugInfo> allMatches;
    private final ArrayList<DrugInfo> alternativeMatches;
    private final ArrayList<DrugInfo> recommendations;

    // &c., add more if necessary
}
