package com.example.desktopapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Button btn_login;

    @FXML
    private PasswordField tf_pass;

    @FXML
    private TextField tf_user;
    public Stage stage=new Stage();
    public void setMainWindow(){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root=fxmlLoader.getRoot();
        try {
          stage.setScene(new Scene(root));
          stage.showAndWait();
        }catch (Exception e){
          System.out.println(e);
        }
    }

    @FXML
    void initialize(){
        btn_login.setOnAction(event ->{
            setMainWindow();
        });
    }
}
