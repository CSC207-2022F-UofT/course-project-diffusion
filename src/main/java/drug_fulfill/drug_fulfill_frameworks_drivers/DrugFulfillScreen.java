package drug_fulfill.drug_fulfill_frameworks_drivers;

import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillController;
import helper_methods.DrugListGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

public class DrugFulfillScreen extends JPanel implements ActionListener {
    /**
     * The drugName chosen by the user
     */

    JTextField bottle = new JTextField(15);

    JComboBox<String> selectSite;
    JComboBox<String> selectDrug;


    /**
     * The emergency toggle
     */
    JCheckBox isEmergency;

    /**
     * The controller
     */
    DrugFulfillController userRegisterController;

    /**
     * A window with a title and a JButton.
     */
    String locationID;
    public DrugFulfillScreen(DrugFulfillController controller) {

        this.userRegisterController = controller;


        JLabel title = new JLabel("Order Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] sites = {"Site1", "Site2", "Site3"};
        String[] drugs = new DrugListGenerator().GenerateDrugList();

        selectDrug = new JComboBox<>(drugs);
        LabelComboBox chooseDrug = new LabelComboBox(new JLabel("Select Drug"), selectDrug);

        LabelTextPanel bottleInfo = new LabelTextPanel(
                new JLabel("Enter number of Bottles"), bottle);

        selectSite = new JComboBox<>(sites);
        LabelComboBox chooseSite = new LabelComboBox(new JLabel("Select Recipient Site"), selectSite);


        isEmergency=new JCheckBox("Select Box Once Complete");
        isEmergency.setBounds(100,100,150,20);

        JButton signUp = new JButton("Send Order");
        JButton Exit = new JButton("Exit");

        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(Exit);

        Exit.setActionCommand("Exit");

        signUp.addActionListener(this);
        Exit.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(chooseDrug);
        this.add(chooseSite);
        this.add(bottleInfo);
        this.add(buttons);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {

        if (evt.getActionCommand().equals("Exit")){
            System.exit(0);
        }
        try {
            userRegisterController.create((String) selectDrug.getSelectedItem(),
                    Integer.parseInt(bottle.getText()),
                    false, getLocationID(), (String) selectSite.getSelectedItem());
            JOptionPane.showMessageDialog(this, "Order made");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Insufficient Inventory");
        }

    }
    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }
}