module com.example.cetvrtamagareca {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cetvrtamagareca to javafx.fxml;
    exports com.example.cetvrtamagareca;
}