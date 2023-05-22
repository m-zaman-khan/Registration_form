package com.example.registrationformpro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class HelloController {
    @FXML
    private Label loginCredentials;
    @FXML
    private Label userName;
    @FXML
    private Label passWord;
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;
    @FXML
    private Button signIn;
    @FXML
    private Button signUp;

    public void onSignupClicked(ActionEvent event) throws Exception {
        HelloApplication main = new HelloApplication();
        main.changeScene("signUp.fxml");
    }
    @FXML
    void onSignInClicked(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Connection dataBaselink;
        String databaseUser="root";
        String databasePassword="zamanlew6732";
        String url="jdbc:mysql://localhost:3306/registrationpro";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dataBaselink= DriverManager.getConnection(url,databaseUser,databasePassword);
        ResultSet rs ;
        PreparedStatement stat = dataBaselink.prepareStatement(("SELECT * FROM sign_up"));
        rs = stat.executeQuery();

        while (rs.next()){
            if(Objects.equals(rs.getString("full_name"), Username.getText())){
                if(Objects.equals(rs.getString("password"), Password.getText())){
                        FXMLLoader fxmlLoader1 = new FXMLLoader(SignUp.class.getResource("onSignIn.fxml"));
                        Scene scene1 = new Scene(fxmlLoader1.load(), 400, 600);
                        Stage stg = new Stage();
                        stg.setScene(scene1);
                        stg.show();                       // stage show
                }
            }
        }

    }

}