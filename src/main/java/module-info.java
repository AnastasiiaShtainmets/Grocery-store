module com.example.grocery_store {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grocery_store to javafx.fxml;
    exports com.example.grocery_store;
}