package com.socialnet.cafelog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {

    private static Stage window;

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.isResizable();
        window.initStyle(StageStyle.UNDECORATED);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        window.setTitle("Cafe Log");
        window.setScene(scene);
        window.show();
    }

    public void changeScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        window.getScene().setRoot(fxmlLoader.load());
    }

    public static void main(String[] args) {
        launch();
    }
}