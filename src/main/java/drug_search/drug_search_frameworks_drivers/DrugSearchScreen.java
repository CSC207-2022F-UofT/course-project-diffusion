package drug_search.drug_search_frameworks_drivers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrugSearchScreen {

    public DrugSearchScreen() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(receiptSearch, "Not yet implemented");
            }
        });
    }

    public JPanel getPanel() {
        return receiptSearch;
    }

    private JButton searchButton;
    private JTextField enterKeywordsTextField;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JPanel receiptSearch;
}
