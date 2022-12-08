package user_registration.frameworks_and_drivers.screens;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JPanel{

    private ActionListener actionListener;
    /**
     * A Home screen with a title and buttons to switch to log In or registration screen.
     */

    public HomeScreen() {
        /*
          Create a JLabel title and centre it.
         */
        JLabel title = new JLabel("Select Registration if you are a new user.");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        /*
        Create login and Registration buttons. These don't have functionality atm since MainFrame is adding in
        the buttons.
         */
        JButton logIn = new JButton("LogIn");
        JButton Registration = new JButton("User Registration");

        /*
        Create a JPanel buttons to store the buttons in. The buttons panel is not used atm since MainFrame is
        responsible for adding in the buttons.
         */
        JPanel buttons = new JPanel();

        /*
        Add the buttons Login and Registration to the buttons JPanel buttons.
         */
//        buttons.add(logIn);
//        buttons.add(Registration);

        /*
        Create JPanel homeScreenPanel to store components for the homewhich will have a Boxlayout and
         */
        JPanel homeScreenPanel = new JPanel();
        homeScreenPanel.setLayout(new BoxLayout(homeScreenPanel, BoxLayout.Y_AXIS));

        homeScreenPanel.add(title);
//        homeScreenPanel.add(buttons);

//        logIn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setSize(600, 500);

        this.add(title);
        this.add(homeScreenPanel);

//        init();
//    }
//
//    private void init(){
//        JButton clickButton = new JButton("Click Me");
//        JButton dontClickButton = new JButton("Dont Click me");
//
//        actionListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource() == clickButton){
//                    JOptionPane.showMessageDialog(null, "Hello Right button");
//                }
//                else if (e.getSource() == dontClickButton){
//                    JOptionPane.showMessageDialog(null, "Wrong button");
//                }
//            }
//        };
//        clickButton.addActionListener(actionListener);
//        dontClickButton.addActionListener(actionListener);
//
//        add(clickButton);
//        add(dontClickButton);
//    }
//}

//        ButtonListener buttonListener = new ButtonListener();
//        logIn.addActionListener(buttonListener);
//        Registration.addActionListener(new ButtonListener());


//        logIn.addActionListener(this);
//        Registration.addActionListener(this);

//        logIn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cardLayout = (CardLayout) content;
//            }
//        });


//    @Override
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Clicked " + e.getActionCommand());
//    }
    }
}
