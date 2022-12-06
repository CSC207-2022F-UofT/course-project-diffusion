package drug_search.frameworks_drivers;

import drug_search.interface_adapters.DrugSearchController;
import drug_search.interface_adapters.DrugSearchPresenter;
import drug_search.interface_adapters.DrugSearchViewModel;
import drug_search.use_case.SearchUseCase;

public class DrugSearchHelper {
    public DrugSearchScreen generateDrugSearchScreen() {
        // Initialize interface adapters and requisite use case classes
        DrugSearchViewModel drugSearchViewModel = new DrugSearchViewModel();
        DrugSearchPresenter drugSearchPresenter = new DrugSearchPresenter(drugSearchViewModel);
        DatabaseAccessor databaseAccessor = new DatabaseAccessor();
        SearchUseCase searchUseCase = new SearchUseCase(drugSearchPresenter, databaseAccessor);
        DrugSearchController drugSearchController = new DrugSearchController(searchUseCase);

        return new DrugSearchScreen(drugSearchController, drugSearchViewModel);
    }
}
