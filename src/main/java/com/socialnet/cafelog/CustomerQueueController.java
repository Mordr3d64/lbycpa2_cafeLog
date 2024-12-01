package com.socialnet.cafelog;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CustomerQueueController {

    @FXML
    private TextField userInQueue;
    @FXML
    private TextArea activityLabel;
    @FXML
    private TextArea waitingTimeLabel;

    CustomerServiceQueue customerServiceQueue = new CustomerServiceQueue();

    public void handleEnqueueUser() {
        activityLabel.setText(customerServiceQueue.enqueue(userInQueue.getText().trim()));
    }

    public void handleDequeueUser() {
        activityLabel.setText(customerServiceQueue.dequeue());
        waitingTimeLabel.setText(customerServiceQueue.averageWaitTime());
    }

    // Add list customers in queue

    public void handleBackToMenuClick() throws IOException {
        MainApplication cafeLog = new MainApplication();
        cafeLog.changeScene("main-view.fxml");
    }
}
