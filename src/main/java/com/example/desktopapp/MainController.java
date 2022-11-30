package com.example.desktopapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> CB_location;

    @FXML
    private Label cityLabel;

    @FXML
    void initialize() {
        assert CB_location != null : "fx:id=\"CB_location\" was not injected: check your FXML file 'Untitled'.";
        assert cityLabel != null : "fx:id=\"cityLabel\" was not injected: check your FXML file 'Untitled'.";
    }

}
