package user_login.frameworks_and_drivers.screens;

import helper_methods.PanelCreator;
import user_login.interface_adapters.UserLoginController;
import user_login.interface_adapters.UserLoginPresenterOutputBoundary;
import user_login.interface_adapters.UserLoginViewModel;
import user_login.use_case.output.UserloginOutputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginScreen extends JPanel implements ActionListener, UserLoginPresenterOutputBoundary {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JTextField requestResponse = new JTextField(50);

    UserLoginController userLoginController;
    JButton submitUserLogin;
    JButton cancelUserLogin;
    Boolean submitLoginStatus = false;

    String userRole;
    String locationName;
    String accountID;

    public UserLoginScreen(UserLoginController userLoginController) {
        this.userLoginController = userLoginController;

        JLabel title = new JLabel("User Login Screen");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        requestResponse.setEditable(false);

        PanelCreator usernamePanel = new PanelCreator(new JLabel("Enter username"), username);
        PanelCreator passwordPanel = new PanelCreator(new JLabel("Enter password"), password);
        PanelCreator responsePanel = new PanelCreator(new JLabel("Login Status"), requestResponse);

        submitUserLogin = new JButton("Check User Login");
        cancelUserLogin = new JButton("Cancel User Login");

        JPanel userLoginButtons = new JPanel();

        userLoginButtons.add(submitUserLogin);
        userLoginButtons.add(cancelUserLogin);

        submitUserLogin.addActionListener(this);
        cancelUserLogin.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernamePanel);
        this.add(passwordPanel);
        this.add(userLoginButtons);
        this.add(responsePanel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(submitUserLogin)) {
            System.out.println("Clicked " + actionEvent.getActionCommand());
            try {
                userLoginController.createInputObject(username.getText(), password.getText());
                JOptionPane.showMessageDialog(this, String.format("Login request recorded for %s", username.getText()));
                setSubmitLoginStatus(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else if (actionEvent.getSource().equals(cancelUserLogin)){
            System.exit(0);
        }
    }

    @Override
    public UserloginOutputData presenterOutput(UserloginOutputData userloginOutputData) {
        UserLoginViewModel userLoginViewModel = new UserLoginViewModel(userloginOutputData.getUsername(),
                userloginOutputData.getCreationTime(), userloginOutputData.getRole(),
                userloginOutputData.getLocationName(), userloginOutputData.getAccountID());
        setUserRole(userLoginViewModel.getRole());
        setAccountID(userLoginViewModel.getAccountID());
        setLocationName(userLoginViewModel.getLocationName());
        requestResponse.setText(String.format("Approved! %s has successful login status at %s as a %s at %s",
                userLoginViewModel.getUsername(), userLoginViewModel.getLocationName(), userLoginViewModel.getRole(),
                userLoginViewModel.getCreationTime()));
        return userloginOutputData;
    }

    public Boolean getSubmitLoginStatus() {
        return submitLoginStatus;
    }

    public void setSubmitLoginStatus(Boolean submitLoginStatus) {
        this.submitLoginStatus = submitLoginStatus;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
