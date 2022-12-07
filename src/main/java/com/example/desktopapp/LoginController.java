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

    public void setMainWindow(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../resources/com.example.desktopapp.main.fxml"));
        System.out.println("OK");
        Parent root=fxmlLoader.getRoot();
      try {
          stage.setScene(new Scene(root));
          stage.showAndWait();
      }catch (Exception e){
          System.out.println(e);
      }
       // }
       // else {System.out.println("NOOOO");}

    }
    public Stage stage=new Stage();
   /* public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Desktop App");
        stage.setScene(scene);
        stage.show();
    }*/
    @FXML
    void initialize(){
        btn_login.setOnAction(event ->{
            setMainWindow();
        });
    }
}
