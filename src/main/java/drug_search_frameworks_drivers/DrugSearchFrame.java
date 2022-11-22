package drug_search_frameworks_drivers;

import javax.swing.*;

public class DrugSearchFrame extends JFrame {
    public DrugSearchFrame() {
        super("Drug Receipt Search");

        setContentPane(new DrugSearchScreen().getPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
