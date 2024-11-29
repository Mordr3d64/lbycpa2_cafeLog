package com.socialnet.cafelog;

import javafx.application.Platform;

import java.io.IOException;

public class MainController {
    // Switch between scenes
    public void onComputerLoginClick() throws IOException {
        MainApplication cafeLog = new MainApplication();
        cafeLog.changeScene("customerLogin-view.fxml");
    }

    public void onServiceQueueClick() throws IOException {
        MainApplication cafeLog = new MainApplication();
        cafeLog.changeScene("customerQueue-view.fxml");
    }

    public void onAvailableDevicesClick() throws IOException {
        MainApplication cafeLog = new MainApplication();
        cafeLog.changeScene("deviceGraph-view.fxml");
    }

    public void onExitClick() {
        Platform.exit();
    }
}
