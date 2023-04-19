package com.example.javafx_supermarket_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplicationSupermarket extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationSupermarket.class.getResource("SupermarketView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Supermarket");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}
