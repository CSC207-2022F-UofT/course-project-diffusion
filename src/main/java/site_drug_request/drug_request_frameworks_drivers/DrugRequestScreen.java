package site_drug_request.drug_request_frameworks_drivers;


import site_drug_request.drug_request_interface_adapters.DrugRequestController;
import site_drug_request.drug_request_interface_adapters.DrugRequestPresenter;
import site_drug_request.drug_request_interface_adapters.DrugRequestPresenterOutputBoundary;
import site_drug_request.drug_request_interface_adapters.DrugRequestViewModel;
import site_drug_request.drug_request_use_case.DrugRequestResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrugRequestScreen extends JPanel implements ActionListener, DrugRequestPresenterOutputBoundary {
    JButton drugRequestButton, cancelRequestbutton;

    private DrugRequestPresenter drugRequestPresenter;
//public class DrugRequestScreen extends JFrame implements ActionListener{
    /**
     * The drugName requested by the site
     */
    JTextField drugName = new JTextField(15);

    /**
     * number of drugBottles requested by the site
     */
    JTextField drugBottle = new JTextField(15);
//    JComboBox drugName = new JComboBox();

    JTextField requestResponse = new JTextField(40);

    /**
     * the controller
     */
    DrugRequestController drugRequestController;

    //    public DrugRequestScreen(){
    public DrugRequestScreen(DrugRequestController drugRequestController) {
        this.drugRequestController = drugRequestController;

        /*
          the title of the window below
         */
        JLabel title = new JLabel("Drug Request Screen");

        /*
          centers the title on the window horizontally
         */
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        /*
        Made the requestResponse panel read only, so it can't be edited by the user
        instead it will be used to display the response to the user.
         */
        requestResponse.setEditable(false);

        /*
          Packages multiple components as a single component using panel Generator.
         */
        PanelGenerator drugNamePanel = new PanelGenerator(new JLabel("Enter Drug Name"), drugName);
        PanelGenerator drugBottlePanel = new PanelGenerator(new JLabel("Enter Number of Drug Bottles"), drugBottle);
        PanelGenerator requestResponsePanel = new PanelGenerator(new JLabel("Action Performed"), requestResponse);


        /*
          create new buttons submitDrugRequest and cancelDrugRequest
         */
        drugRequestButton = new JButton(" Submit Drug Request");
        cancelRequestbutton = new JButton("Cancel");

        /*

         */

        /*
          create drugRequestButtons panel to add buttons to
         */
        JPanel drugRequestPanel = new JPanel();

//        public JPanel buttonGenerator()

        drugRequestPanel.add(drugRequestButton);
        drugRequestPanel.add(cancelRequestbutton);

        drugRequestButton.addActionListener(this);
        cancelRequestbutton.addActionListener(this);
        /*
          setLayout invalidates componenet hierarchy and creates a layout manager, BoxLayout, which vertically
          lays out vcomponents.
          Uncomment the line below and see how we lose vertical component hierarchy.
         */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /*
          Purpose of the below is to add the components to the end of the container in the order they are listed below
         */


        this.add(title);
        this.add(drugNamePanel);
        this.add(drugBottlePanel);
        this.add(drugRequestPanel);
//        this.add(setUpButtonListeners(drugRequestButtons));
        this.add(requestResponsePanel);


    }

    /*
    Two possible actions, one is for submit button which causes the sue case, and the second is for the cancel button
    which terminates the program.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == drugRequestButton) {
            try {

                //Is it ok to call this???
                drugRequestController.create(drugName.getText(), drugBottle.getText());
                System.out.println("SCREEN PASSED");
                JOptionPane.showMessageDialog(drugRequestButton, String.format("Drug Order Request sent for %s bottles of %s.", drugBottle.getText(), drugName.getText()));
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(cancelRequestbutton, ee.getMessage());
            }

        } else if ( e.getSource() == cancelRequestbutton){
            System.exit(0);
        }
    }



    /*
    Updates the action performed field with the output of the usecase interactor.
    Generates a string output from a drugRequestViewModel data structure.
     */
    @Override
    public DrugRequestResponseModel viewPresenter(DrugRequestResponseModel requestResponseModel) {
        DrugRequestViewModel drugRequestViewModel = new DrugRequestViewModel(requestResponseModel.getDrugName(),
                requestResponseModel.getDrugBottle(), requestResponseModel.getCreationTime());
        requestResponse.setText(String.format("Order successfully received for %s bottles of %s at %s.", drugRequestViewModel.getDrugBottle(),
                drugRequestViewModel.getDrugName(), drugRequestViewModel.getCreationTime()));
        return null;
    }


}
