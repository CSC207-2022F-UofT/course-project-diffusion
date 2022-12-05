package drug_request_frameworks_drivers;


import drug_request_interface_adapters.DrugRequestController;
import junit.framework.JUnit4TestAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrugRequestScreen extends JPanel implements ActionListener {
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

    JTextField requestResponse = new JTextField(15);

    /**
     * the controller
     */
    DrugRequestController drugRequestController;
//    public DrugRequestScreen(){
    public DrugRequestScreen(DrugRequestController drugRequestController){
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
        JButton submitDrugRequest = new JButton(" Submit Drug Request");
        JButton cancelDrugRequest = new JButton("Cancel");

        /*

         */

        /*
          create drugRequestButtons panel to add buttons to
         */
        JPanel drugRequestButtons = new JPanel();

        drugRequestButtons.add(submitDrugRequest);
        drugRequestButtons.add(cancelDrugRequest);

        submitDrugRequest.addActionListener(this);
        cancelDrugRequest.addActionListener(this);
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
        this.add(drugRequestButtons);
        this.add(requestResponsePanel);


    }


    //@Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Clicked " + actionEvent.getActionCommand());
        try{
            drugRequestController.create(drugName.getText(), drugBottle.getText());
            JOptionPane.showMessageDialog(this, String.format("Drug Order Request recorded for %s bottles of %s", drugBottle.getText(), drugName.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
