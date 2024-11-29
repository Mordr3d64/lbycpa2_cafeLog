package com.socialnet.cafelog;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CustomerLoginController {

    @FXML
    private TextField userToLogin;
    @FXML
    private TextField userToLogout;
    @FXML
    private TextArea activityLabel;

    LoginLogoutSystem loginSystem = new LoginLogoutSystem();


    public void handleLoginUser() {
        if (!userToLogin.getText().trim().isEmpty()) {
            activityLabel.setText(loginSystem.login(userToLogin.getText()));
        }
    }

    public void handleLogoutUser() {
        if (!userToLogout.getText().trim().isEmpty()) {
            activityLabel.setText(loginSystem.logout(userToLogout.getText()));
        }
    }

    // Add list for active users

    public void handleBackToMenuClick() throws IOException {
        MainApplication cafeLog = new MainApplication();
        cafeLog.changeScene("main-view.fxml");
    }
}