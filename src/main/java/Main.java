import main_frame.MainFrame;

import javax.swing.*;

/**
 * Main for the program
 */

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });


    }
}