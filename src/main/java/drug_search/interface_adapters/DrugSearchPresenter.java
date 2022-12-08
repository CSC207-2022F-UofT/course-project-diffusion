package drug_search.interface_adapters;

import drug_search.use_case.ISearchResponder;
import drug_search.use_case.SearchResponse;

public class DrugSearchPresenter implements ISearchResponder {
    public DrugSearchPresenter(DrugSearchViewModel drugSearchViewModel) {
        this.drugSearchViewModel = drugSearchViewModel;
    }

    /**
     * Displays search response data to the user.
     *
     * @param response The data to display.
     */
    public void searchRespond(SearchResponse response) {
        drugSearchViewModel.setEntryList(response.getResults());
        drugSearchViewModel.setMessage(response.getMessage());
    }

    private final DrugSearchViewModel drugSearchViewModel;
}
