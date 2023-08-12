module com.example.assignment2javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment2javafx to javafx.fxml;
    exports com.example.assignment2javafx;
}