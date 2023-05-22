package com.example.registrationformpro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.resizableProperty().set(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void  changeScene(String FXML) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(SignUp.class.getResource("signUp.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 400, 600);
        Stage stg = new Stage();
        stg.setScene(scene1);
        stg.show();
    }

    public static void main(String[] args) {
        launch();
    }
}