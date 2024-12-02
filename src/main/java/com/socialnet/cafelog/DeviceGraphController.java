package com.socialnet.cafelog;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class DeviceGraphController {

    private DeviceGraph deviceGraph = new DeviceGraph();

    @FXML
    private TextField deviceNameField;

    @FXML
    private TextField connectDevice1Field;

    @FXML
    private TextField connectDevice2Field;

    @FXML
    private TextArea outputArea;

    public void handleBackToMenuClick() throws IOException {
        MainApplication cafeLog = new MainApplication();
        cafeLog.changeScene("main-view.fxml");
    }

    @FXML
    private void handleAddDeviceClick() {
        String deviceName = deviceNameField.getText();
        if (!deviceName.isEmpty()) {
            deviceGraph.addDevice(deviceName);
            outputArea.appendText(deviceName + " added to the network.\n");
        } else {
            outputArea.appendText("Device name cannot be empty.\n");
        }
    }

    @FXML
    private void handleConnectDevicesClick() {
        String device1 = connectDevice1Field.getText();
        String device2 = connectDevice2Field.getText();

        if (!device1.isEmpty() && !device2.isEmpty()) {
            deviceGraph.connectDevices(device1, device2);
            outputArea.appendText(device1 + " connected to " + device2 + ".\n");
        } else {
            outputArea.appendText("Both device names are required to connect devices.\n");
        }
    }

    @FXML
    private void handleDisplayNetworkClick() {
        String networkDetails = deviceGraph.displayNetwork();
        outputArea.setText(networkDetails);
    }

    @FXML
    private void handleFindAvailableDevicesClick() {
        String availableDevices = deviceGraph.findAvailableDevices();
        outputArea.setText(availableDevices);
    }

}
