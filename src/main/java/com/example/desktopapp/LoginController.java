package com.example.desktopapp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    DbFunctions db= new DbFunctions("DBstock","postgres","1234");
    @FXML
    private Button btn_login;
    @FXML
    private Label error_label;
    @FXML
    private PasswordField tf_pass;

    @FXML
    private TextField tf_user;
    public Stage stage=new Stage();
    public void setMainWindow(){
        btn_login.getScene().getWindow().hide();
        ArrayList<String> usersData= db.get_user_data(tf_user.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MainController mc= fxmlLoader.getController();
        mc.initData(usersData);
        Parent root=fxmlLoader.getRoot();
        try {
          stage.setScene(new Scene(root));
          stage.showAndWait();
        }catch (Exception e){
          System.out.println(e);
        }
    }
    public boolean checkLoginIn(String login,String password){
        if (login.length()!=0 && password.length()!=0){
            HashMap<String,String> users_data= db.get_loginpassword_fromBD();
            if(!users_data.isEmpty())
                if (password.equals(users_data.get(login)))
                    return true;
        }
        error_label.setText("Неправильный логин или пароль");
        return false;
    }
    @FXML
    void initialize(){
        btn_login.setOnAction(event ->{
            if (checkLoginIn(tf_user.getText(),tf_pass.getText()))
                setMainWindow();
        });
    }
}
