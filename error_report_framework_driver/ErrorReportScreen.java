package error_report_framework_driver;

import drug_fulfill.drug_fulfill_frameworks_drivers.LabelTextPanel;
import error_report_interface_adapters.ErrorReportController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorReportScreen extends JPanel implements ActionListener{
    //The drug that was received incorrectly
    JTextField wrongOrder = new JTextField(15);

    //The amount that was received incorrectly
    JTextField wrongAmount = new JTextField(15);


    ErrorReportController errorReportController;

    public ErrorReportScreen(ErrorReportController errorReportController){
        this.errorReportController = errorReportController;

        /*
          the title of the window below
         */
        JLabel title = new JLabel("Error Reporting with Order");

        /*
          centers the title on the window horizontally
         */
        title.setAlignmentX(Component.RIGHT_ALIGNMENT);

        LabelTextPanel bottleInfo = new LabelTextPanel(
                new JLabel("Enter drug name"), wrongOrder);

        LabelTextPanel enterAmount = new LabelTextPanel(
                new JLabel("Enter amount wrong"), wrongAmount);
        /*
          create new buttons submitErrorReport and cancelErrorReport
         */
        JButton submitErrorReport = new JButton(" Submit Error Report");
        JButton cancelErrorReport = new JButton("Cancel");

        /*

         */

        /*
          create ErrorReportButtons panel to add buttons to
         */
        JPanel errorReportButtons = new JPanel();

        errorReportButtons.add(submitErrorReport);
        errorReportButtons.add(cancelErrorReport);

        submitErrorReport.addActionListener(this);
        cancelErrorReport.addActionListener(this);
        /*
          setLayout invalidates componenet hierarchy and creates a layout manager, BoxLayout, which vertically
          lays out vcomponents.

         */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /*
          Purpose of the below is to add the components to the end of the container in the order they are listed below
         */
        this.add(title);
        this.add(errorReportButtons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Cancel"){
            System.exit(0);
        }
        try {

        } catch (Exception ee) {
            JOptionPane.showMessageDialog(this, "please put in a number for amount");
        }
    }
}
