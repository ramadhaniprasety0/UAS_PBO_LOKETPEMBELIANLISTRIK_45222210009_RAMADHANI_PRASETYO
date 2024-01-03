module com.example.newpbo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.newpbo to javafx.fxml;
    exports com.example.newpbo;
}