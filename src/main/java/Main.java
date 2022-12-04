import main_frame.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Purpose of the below is to handle cases where it does not run, as well as cleaning up
        //the main method by outsourcing the JFrame construction to frameworks_and_drivers.view.frames.drug_request.DrugRequestFrame.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });

    }
}