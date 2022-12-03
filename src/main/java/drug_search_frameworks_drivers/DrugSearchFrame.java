package drug_search_frameworks_drivers;

import drug_search_interface_adapters.DrugSearchController;
import drug_search_interface_adapters.DrugSearchPresenter;
import drug_search_interface_adapters.DrugSearchViewModel;
import drug_search_use_case.SearchUseCase;

import javax.swing.*;

public class DrugSearchFrame extends JFrame {
    public DrugSearchFrame() {
        super("Drug Receipt Search");

        // Initialize interface adapters and requisite use case classes
        DrugSearchViewModel drugSearchViewModel = new DrugSearchViewModel();
        DrugSearchPresenter drugSearchPresenter = new DrugSearchPresenter(drugSearchViewModel);
        DatabaseAccessor databaseAccessor = new DatabaseAccessor();
        SearchUseCase searchUseCase = new SearchUseCase(drugSearchPresenter, databaseAccessor);
        DrugSearchController drugSearchController = new DrugSearchController(searchUseCase);

        // Initialize and set up GUI
        setContentPane(new DrugSearchScreen(drugSearchController, drugSearchViewModel).getPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}