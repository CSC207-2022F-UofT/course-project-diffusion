package drug_search_frameworks_drivers;

import drug_search_entities.DrugRequestDBEntry;

import javax.swing.*;
import java.util.List;

public class DrugSearchResultFrame extends JFrame {
    public DrugSearchResultFrame(List<DrugRequestDBEntry> entries) {
        super("Search Results");

        // Initialize and set up GUI
        setContentPane(new DrugSearchResultScreen(entries).getPanel());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
