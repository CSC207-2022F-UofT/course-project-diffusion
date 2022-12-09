package drug_search.interface_adapters;

import drug_search.frameworks_drivers.DatabaseAccessor;
import drug_search.use_case.SearchRequest;
import drug_search.use_case.SearchUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrugSearchControllerTest {

    @Test
    void sendSearchRequest() {
        DatabaseAccessor databaseAccessor = new DatabaseAccessor();
        DrugSearchViewModel viewModel = new DrugSearchViewModel();
        DrugSearchPresenter presenter = new DrugSearchPresenter(viewModel);

        SearchUseCase useCase = new SearchUseCase(presenter, databaseAccessor) {
            @Override
            public void searchFor(SearchRequest request) {
                assertEquals("Quantity requested must be an integer, please try again.", request.getMessage());
            }
        };

        DrugSearchController controller = new DrugSearchController(useCase);

        controller.sendSearchRequest("b", "l", "a", "s", "t", false,
                1, 9, 8, 4);
    }
}