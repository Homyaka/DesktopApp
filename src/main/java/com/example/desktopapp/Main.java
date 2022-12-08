package com.example.desktopapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("loginform.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1800, 900);
        stage.setTitle("Desktop App");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
        DbFunctions db= new DbFunctions("DBstock","postgres","1234");
        //db.createUsersTable(conn);
        //List<String> queryList=db.getAllQuery();
        //db.createAllTable(conn,queryList);
    }
}