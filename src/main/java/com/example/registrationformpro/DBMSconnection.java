package com.example.registrationformpro;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBMSconnection {
    public Connection dataBaselink;
    public Connection getConnection(){
        String databaseName="registrationpro";
        String databaseUser="root";
        String databasePassword="zamanlew6732";
        String url="jdbc:mysql://localhost:3306/registrationpro";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            dataBaselink=DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataBaselink;
    }
}
