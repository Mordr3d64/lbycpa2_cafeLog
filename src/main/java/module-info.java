module com.socialnet.cafelog {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.socialnet.cafelog to javafx.fxml;
    exports com.socialnet.cafelog;
}