import main_frame.MainFrame;

import javax.swing.*;
import java.io.File;

/**
 * Main which runs the program by calling MainFrame.
 */

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(MainFrame::new);
    }
}