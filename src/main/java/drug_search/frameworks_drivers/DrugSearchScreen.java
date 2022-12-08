package drug_search.frameworks_drivers;

import drug_search.interface_adapters.DrugSearchController;
import drug_search.interface_adapters.DrugSearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class DrugSearchScreen extends JPanel {
    public DrugSearchScreen(DrugSearchController controller, DrugSearchViewModel viewModel) {
        initComponents();

        drugSearchController = controller;
        drugSearchViewModel = viewModel;
    }

    public JPanel getSearchButtonPanel() {
        return searchButtonPanel;
    }

    private void initComponents() {
        // Initialize grid layout
        int i = 8;
        int j = 5;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j));

        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                add(panelHolder[m][n]);
            }
        }

        searchButtonPanel = panelHolder[7][2];

        // Initialize text field labels
        JLabel drugRequestIDLabel = new JLabel("Drug Request ID");
        JLabel siteIDLabel = new JLabel("Site ID");
        JLabel accountIDLabel = new JLabel("Account ID");
        JLabel drugNameLabel = new JLabel("Drug Name");
        JLabel quantityRequestedLabel = new JLabel("Quantity Requested");

        // Initialize text fields
        drugRequestIDTextField = new JTextField(20);
        siteIDTextField = new JTextField(20);
        accountIDTextField = new JTextField(20);
        drugNameTextField = new JTextField(20);
        quantityRequestedTextField = new JTextField(20);

        // Initialize date search related components
        isDateSearch = new JCheckBox("Date Search");
        relativityComboBox = new JComboBox<>(relativity);
        monthComboBox = new JComboBox<>(months);
        dayComboBox = new JComboBox<>(generateDays());
        yearComboBox = new JComboBox<>(generateYears());

        // Initialize search button
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> sendSearchRequest());

        // Add separators to layout
        panelHolder[0][2].add(new JSeparator());
        panelHolder[4][2].add(new JSeparator());
        panelHolder[6][2].add(new JSeparator());

        // Add text field labels to layout
        panelHolder[1][0].add(drugRequestIDLabel);
        panelHolder[2][0].add(siteIDLabel);
        panelHolder[3][0].add(accountIDLabel);
        panelHolder[1][3].add(drugNameLabel);
        panelHolder[2][3].add(quantityRequestedLabel);

        // Add text fields to layout
        panelHolder[1][1].add(drugRequestIDTextField);
        panelHolder[2][1].add(siteIDTextField);
        panelHolder[3][1].add(accountIDTextField);
        panelHolder[1][4].add(drugNameTextField);
        panelHolder[2][4].add(quantityRequestedTextField);

        // Add date search related components to layout
        panelHolder[5][0].add(isDateSearch);
        panelHolder[5][1].add(relativityComboBox);
        panelHolder[5][2].add(monthComboBox);
        panelHolder[5][3].add(dayComboBox);
        panelHolder[5][4].add(yearComboBox);

        // Add search button
        panelHolder[7][2].add(searchButton);
    }

    private void sendSearchRequest() {
        // Text-based search parameters
        String accountId = accountIDTextField.getText();
        String requestId = drugRequestIDTextField.getText();
        String siteId = siteIDTextField.getText();
        String drugName = drugNameTextField.getText();
        int quantity = -1;

        // Try parse quantity requested
        if (quantityRequestedTextField.getText() != null && !quantityRequestedTextField.getText().isBlank()) {
            try {
                quantity = Integer.parseInt(quantityRequestedTextField.getText());
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Quantity requested must be an integer, please try again.");
                return;
            }
        }

        // Date-based search parameters
        boolean dateSearch = isDateSearch.isSelected();
        int relativity = relativityComboBox.getSelectedIndex() - 1;
        int year = yearComboBox.getSelectedIndex() + 2000;
        int month = monthComboBox.getSelectedIndex() + 1;
        int day = dayComboBox.getSelectedIndex() + 1;
        LocalDateTime date;

        // Ensure selected date is valid
        try {
            date = LocalDateTime.of(year, month, day, 0, 0);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Impossible date selection, please try again!");
            return;
        }

        // Send search request
        drugSearchController.sendSearchRequest(accountId, requestId, siteId, drugName, quantity, dateSearch, date,
                relativity);

        // Display relevant info from view model
        if (drugSearchViewModel.getMessage() == null)
            new DrugSearchResultFrame(drugSearchViewModel.getEntryList());
        else
            JOptionPane.showMessageDialog(this, drugSearchViewModel.getMessage());
    }

    private String[] generateDays() {
        String[] days = new String[31];

        for (int i = 1; i <= 31; i++)
            days[i - 1] = String.valueOf(i);

        return days;
    }

    private String[] generateYears() {
        String[] years = new String[30];

        int currentYear = LocalDateTime.now().getYear();

        for (int i = 0; i < 30; i++) {
            years[i] = String.valueOf(currentYear - i);
        }

        return years;
    }

    private final DrugSearchController drugSearchController;
    private final DrugSearchViewModel drugSearchViewModel;

    private final String[] relativity = {
            "Before",
            "On",
            "After"
    };
    private final String[] months = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    private JPanel searchButtonPanel;

    private JTextField drugRequestIDTextField;
    private JTextField siteIDTextField;
    private JTextField accountIDTextField;
    private JTextField drugNameTextField;
    private JTextField quantityRequestedTextField;

    private JCheckBox isDateSearch;
    private JComboBox<String> relativityComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> yearComboBox;
}
