package com.example.registrationformpro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SignUp implements Initializable {
   @FXML
    private Label name;
    @FXML
    private TextField Name;
    @FXML
    private Label phone;
    @FXML
    private TextField Phone;
    @FXML
    private Label email;
    @FXML
    private TextField Email;
    @FXML
    private Label password;
    @FXML
    private PasswordField Password;
    @FXML
    private Label dob;
   @FXML
    private DatePicker DOB;
    @FXML
    private Label qualification;
    @FXML
    private ChoiceBox<String> mychoicebox1;
    @FXML
    private String[] qual={"Matric","Intermediate","Bachelors"};
    @FXML
    private ChoiceBox<String> mychoicebox2;
    @FXML
    private String[] gen={"Male","Female","Other"};
    @FXML
    private Label city;
    @FXML
    private TextField City;

 @FXML
 void addRegister(ActionEvent event) throws ClassNotFoundException, SQLException {
  Connection dataBaselink;
  String databaseUser="root";
  String databasePassword="zamanlew6732";
  String url="jdbc:mysql://localhost:3306/registrationpro";
  Class.forName("com.mysql.cj.jdbc.Driver");
  dataBaselink=DriverManager.getConnection(url,databaseUser,databasePassword);
  PreparedStatement stat = dataBaselink.prepareStatement("INSERT Into sign_up  (full_name,phone,email,password,dob,gender,qualification,city) values (?,?,?,?,?,?,?,?)");

  stat.setString(1,Name.getText());
  stat.setString(2,Phone.getText());
  stat.setString(3,Email.getText());
  stat.setString(4,Password.getText());
  LocalDate localDate = DOB.getValue();
  Date date = Date.valueOf(localDate);
  stat.setDate(5, date);
  stat.setString(6,mychoicebox2.getValue());
  stat.setString(7,mychoicebox1.getValue());
  stat.setString(8,City.getText());
  stat.execute();
  stat.close();
  dataBaselink.close();
 }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mychoicebox1.getItems().addAll(qual);
        mychoicebox2.getItems().addAll(gen);
    }
}
