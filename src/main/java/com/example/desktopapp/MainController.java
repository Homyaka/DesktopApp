package com.example.desktopapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class MainController {
    @FXML
    private Button btn_checktables_query;

    @FXML
    private ChoiceBox<String> cb_choicetables_query;

    @FXML
    private Label label_jobtitle;

    @FXML
    private Label label_lastname;

    @FXML
    private Label label_name;

    @FXML
    private Label label_right;

    @FXML
    private Tab tab_change;

    @FXML
    private Tab tab_exit;

    @FXML
    private Tab tab_query;
    @FXML
    private TableColumn<?, ?> query_column1;

    @FXML
    private TableColumn<?, ?> query_column2;

    @FXML
    private TableColumn<?, ?> query_column3;

    @FXML
    private TableColumn<?, ?> query_column4;

    @FXML
    private TableColumn<?, ?> query_column5;

    @FXML
    private TableColumn<?, ?> query_column6;
    @FXML
    private TableView<TableColumn> table_query;
    @FXML
    private Button btn_hidetable;

    private void addTablesInCheckbox(){
        ObservableList<String> cursors = FXCollections.observableArrayList("Крытые вагоны","Открытые вагоны","Вагоны-хопперы","Вагоны-цистерны","Отдельные вагоны","Отправления","Маршруты","Города");
        cb_choicetables_query.setItems(cursors);
    }

    public void initData(ArrayList<String> login){
        label_name.setText(login.get(0));
        label_lastname.setText(login.get(1));
        label_jobtitle.setText(login.get(2));
        label_right.setText(login.get(3));
    }
    @FXML
    void initialize() {
        addTablesInCheckbox();
        /*btn_hidetable.setOnAction(event ->{
            if(table_query.isVisible())
                table_query.setVisible(false);
            else
                table_query.setVisible(true);
           */
           // query_column1.setVisible(false);
           // query_column2.setVisible(false);
           // query_column3.setVisible(false);
           // query_column4.setVisible(false);
           // query_column5.setVisible(false);
           // query_column6.setVisible(false);
        //});
    }

}
