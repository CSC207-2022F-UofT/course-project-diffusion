package drug_search_frameworks_drivers;

import drug_search_interface_adapters.DrugSearchController;
import drug_search_interface_adapters.DrugSearchViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class DrugSearchScreen {

    public DrugSearchScreen(DrugSearchController drugSearchController, DrugSearchViewModel drugSearchViewModel) {
        this.drugSearchController = drugSearchController;
        this.drugSearchViewModel = drugSearchViewModel;

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendSearchRequest();
            }
        });
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
    private JButton searchButton;
    private JComboBox monthComboBox;
    private JComboBox dayComboBox;
    private JComboBox yearComboBox;
    private JComboBox relativityComboBox;
    private JPanel receiptSearch;
    private JCheckBox dateSearchCheckBox;
    private JTextField accountIDTextField;
    private JTextField drugRequestIDTextField;
    private JTextField siteIDTextField;
    private JTextField drugNameTextField;
    private JTextField quantityRequestedTextField;
}
