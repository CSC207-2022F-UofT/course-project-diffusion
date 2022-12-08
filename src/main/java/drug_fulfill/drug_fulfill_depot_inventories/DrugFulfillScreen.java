package drug_fulfill.drug_fulfill_depot_inventories;

import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

public class DrugFulfillScreen extends JPanel implements ActionListener {
    /**
     * The drugName chosen by the user
     */
    JTextField drugName = new JTextField(15);

    JTextField bottle = new JTextField(15);


    JTextField depot = new JTextField(15);
    JComboBox<String> selectDepot;
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
    public DrugFulfillScreen(DrugFulfillController controller) {

        this.userRegisterController = controller;


        JLabel title = new JLabel("Order Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //String[] sites = {"Site1", "Site2", "Site3"};
        String[] depots = {"Depot1", "Depot2", "Depot3"};
        String[] drugs = {"DrugA", "DrugB", "DrugC"};

        LabelTextPanel drugNameInfo = new LabelTextPanel(
                new JLabel("Choose drugName (DrugA, DrugB, DrugC)"), drugName);
        selectDrug = new JComboBox<>(drugs);

//        JPanel drugpanel = new JPanel();
//        drugpanel.add(selectDrug);
        LabelComboBox chooseDrug = new LabelComboBox(new JLabel("Choose drugName"), selectDrug);






        LabelTextPanel bottleInfo = new LabelTextPanel(
                new JLabel("Choose amount/bottle"), bottle);

        LabelTextPanel depotInfo = new LabelTextPanel(
                new JLabel("Choose depot to order from (Depot1, Depot2, Depot3)"), depot);
        selectDepot = new JComboBox<>(depots);

//        JPanel depotpanel = new JPanel();
//        depotpanel.add(selectDepot);
        LabelComboBox chooseDepot = new LabelComboBox(new JLabel("Choose depot"), selectDepot);


        isEmergency=new JCheckBox("Toggle if Emergency");
        isEmergency.setBounds(100,100,150,20);

        JButton signUp = new JButton("Make Order");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(cancel);

        cancel.setActionCommand("Canel");

        signUp.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        //this.add(drugNameInfo);
        this.add(chooseDrug);
        this.add(chooseDepot);
        this.add(bottleInfo);
        //this.add(depotInfo);

        this.add(isEmergency);
        this.add(buttons);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {

        String print = (String) selectDrug.getSelectedItem();
        System.out.println(print);

        System.out.println("Click " + evt.getActionCommand());
        Boolean ie = Boolean.FALSE;
        if(isEmergency.isSelected()){
            ie = Boolean.TRUE;
        } else if (evt.getActionCommand().equals("Cancel")){
            System.exit(0);
        };
        try {
            userRegisterController.create((String) selectDrug.getSelectedItem(),
                    Integer.parseInt(bottle.getText()), //just some number for now
                    //String.valueOf(password.getPassword()),
                    //String.valueOf(repeatPassword.getPassword()),
                    ie, (String) selectDepot.getSelectedItem());



            //JOptionPane.showMessageDialog(this,  String.format("%1$s ", bottle.getText()) + String.format(drugName.getText()) + "is emergency " + isEmergency.isSelected());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "please put in a number for amount");
        }

    }
}