package drug_search.frameworks_drivers;

import drug_search.interface_adapters.DrugSearchController;
import drug_search.interface_adapters.DrugSearchViewModel;

import javax.swing.*;
import java.time.LocalDateTime;

public class DrugSearchScreenNew {

    public DrugSearchScreenNew(DrugSearchController drugSearchController, DrugSearchViewModel drugSearchViewModel) {
        this.drugSearchController = drugSearchController;
        this.drugSearchViewModel = drugSearchViewModel;

//        searchButton.addActionListener(e -> sendSearchRequest());
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
                JOptionPane.showMessageDialog(receiptSearch,
                        "Quantity requested must be an integer, please try again.");
                return;
            }
        }

        // Date-based search parameters
        boolean dateSearch = dateSearchCheckBox.isSelected();
        int relativity = relativityComboBox.getSelectedIndex() - 1;
        int year = yearComboBox.getSelectedIndex() + 2000;
        int month = monthComboBox.getSelectedIndex() + 1;
        int day = dayComboBox.getSelectedIndex() + 1;
        LocalDateTime date = LocalDateTime.now();

        // Ensure selected date is valid
        try {
            date = LocalDateTime.of(year, month, day, 0, 0);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(receiptSearch, "Impossible date selection, please try again!");
            return;
        }

        // Send search request
        drugSearchController.sendSearchRequest(accountId, requestId, siteId, drugName, quantity, dateSearch, date,
                relativity);

        // Display relevant info from view model
        if (drugSearchViewModel.getMessage() == null)
            new DrugSearchResultFrame(drugSearchViewModel.getEntryList());
        else
            JOptionPane.showMessageDialog(receiptSearch, drugSearchViewModel.getMessage());

        // Temporary debug stuff
        // String message = "Sent search request with parameters \n"
        //         + "Account ID: " + accountId + "\n"
        //         + "Request ID: " + requestId + "\n"
        //         + "Site ID: " + siteId + "\n"
        //         + "Drug Name: " + drugName + "\n"
        //         + "Quantity: " + quantity + "\n"
        //         + "Date Search: " + dateSearch + "\n"
        //         + "Date: " + day + "/" + month + "/" + year + "\n"
        //         + "Relativity: " + relativity;
        // JOptionPane.showMessageDialog(receiptSearch, message);
    }

    public JPanel getPanel() {
        return receiptSearch;
    }

    private DrugSearchController drugSearchController;
    private DrugSearchViewModel drugSearchViewModel;
    private JTextField textField1;
    private JPanel receiptSearch;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JCheckBox dateSearchCheckBox;
    private JComboBox relativityComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JComboBox dayComboBox;
    private JTextField textField5;
    private JButton searchButton;
    private JLabel drugRequestIDTextField;
    private JLabel siteIDTextField;
    private JLabel accountIDTextField;
    private JLabel drugNameTextField;
    private JLabel quantityRequestedTextField;
}
