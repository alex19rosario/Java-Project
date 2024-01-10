module com.example.carlos_14_lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.oracle.database.jdbc;
    requires java.sql;
    requires java.naming;


    opens com.example.carlos_14_lab5 to javafx.fxml;
    exports com.example.carlos_14_lab5;
}