module com.example.javafx_supermarket_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.configuration;


    opens com.example.javafx_supermarket_project to javafx.fxml;
    opens com.example.javafx_supermarket_project.controller to javafx.fxml;
    opens com.example.javafx_supermarket_project.model to javafx.fxml;
    opens com.example.javafx_supermarket_project.test to javafx.fxml;
    exports com.example.javafx_supermarket_project;
    exports com.example.javafx_supermarket_project.controller;
    exports com.example.javafx_supermarket_project.model;
    exports com.example.javafx_supermarket_project.test;

}
