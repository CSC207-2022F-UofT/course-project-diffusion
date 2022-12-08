package user_login.frameworks_and_drivers.screens;

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
    JTextField password = new JTextField(15);
    JTextField requestResponse = new JTextField(50);

    UserLoginController userLoginController;
    JButton submitUserLogin;
    JButton cancelUserLogin;
    Boolean submitLoginStatus = false;

    String loginStatusType;

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
                userloginOutputData.getCreationTime(), userloginOutputData.getRole());
        setLoginStatusType(userLoginViewModel.getRole());
        requestResponse.setText(String.format("Approved! %s successfully logged in at %s as a %s",
                userLoginViewModel.getUsername(), userLoginViewModel.getCreationTime(), userLoginViewModel.getRole()));
        return userloginOutputData;
    }

    public Boolean getSubmitLoginStatus() {
        return submitLoginStatus;
    }

    public void setSubmitLoginStatus(Boolean submitLoginStatus) {
        this.submitLoginStatus = submitLoginStatus;
    }

    public String getLoginStatusType() {
        return loginStatusType;
    }

    public void setLoginStatusType(String loginStatusType) {
        this.loginStatusType = loginStatusType;
    }
}
