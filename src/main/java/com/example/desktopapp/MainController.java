package com.example.desktopapp;

import com.example.desktopapp.classesForTables.Tables;
import com.example.desktopapp.classesForTables.Wagons;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MainController {

    DbFunctions db= new DbFunctions("DBstock","postgres","1234");

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
    private Tab tab_user;

    @FXML
    private Tab tab_query;
    @FXML
    private TableView<Tables> table_query;

    private void addTablesInCheckbox(){
        ObservableList<String> cursors = FXCollections.observableArrayList("Крытые вагоны","Открытые вагоны","Вагоны-хопперы","Вагоны-цистерны","Отдельные вагоны","Отправления","Маршруты","Города");
        cb_choicetables_query.setItems(cursors);
    }

   /* public void initData(ArrayList<String> login){
        label_name.setText(login.get(0));
        label_lastname.setText(login.get(1));
        label_jobtitle.setText(login.get(2));
        label_right.setText(login.get(3));
    }*/

    public void fillTableView(){
        fillTableHopper();
    }
    public void fillTableBoxcar(){
       ResultSet resultSet= db.readTable("boxcar");
       ObservableList<Tables> boxcar= FXCollections.observableArrayList();
       try{
           while (resultSet.next()) {
               boxcar.add(new Wagons("boxcar",resultSet.getInt("id_model"),resultSet.getString("model_name"),resultSet.getDouble("car_cap"),resultSet.getDouble("volume"),resultSet.getInt("st_ser_life")));
           }
       }catch (Exception e){
           System.out.println(e);
       }
      table_query.setItems(boxcar);
       //создание столбца id_model
       TableColumn<Tables, Integer> columnIdModel= new TableColumn<Tables,Integer>("id_model");
       columnIdModel.setCellValueFactory(new PropertyValueFactory<Tables,Integer>("idModel"));
       table_query.getColumns().add(columnIdModel);
       //создание столбца model_name
        TableColumn<Tables,String> columnModelName= new TableColumn<Tables,String>("Model Name");
       columnModelName.setCellValueFactory(new PropertyValueFactory<Tables,String>("modelName"));
       table_query.getColumns().add(columnModelName);
       // создание столбца capacity
        TableColumn<Tables, Double> columnCapacity= new TableColumn<Tables, Double>("Capacity");
        columnCapacity.setCellValueFactory(new PropertyValueFactory<Tables,Double>("capacity"));
        table_query.getColumns().add(columnCapacity);
        // создание столбца volume
        TableColumn<Tables, Double> columnVolume= new TableColumn<Tables, Double>("Volume");
        columnVolume.setCellValueFactory(new PropertyValueFactory<Tables,Double>("volume"));
        table_query.getColumns().add(columnVolume);
        //создание столбца serviceLife
        TableColumn<Tables, Integer> colunmServiceLife= new TableColumn<Tables,Integer>("Service Life");
        colunmServiceLife.setCellValueFactory(new PropertyValueFactory<>("serviceLife"));
        table_query.getColumns().add(colunmServiceLife);
    }

    public void fillTableGondola(){
        ResultSet resultSet= db.readTable("gondola");
        ObservableList<Tables> gondola= FXCollections.observableArrayList();
        try{
            while (resultSet.next()) {
                gondola.add(new Wagons("gondola",resultSet.getInt("id_model"),resultSet.getString("model_name"),resultSet.getDouble("car_cap"),resultSet.getDouble("volume"),resultSet.getInt("st_ser_life")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table_query.setItems(gondola);
        //создание столбца id_model
        TableColumn<Tables, Integer> columnIdModel= new TableColumn<Tables,Integer>("id_model");
        columnIdModel.setCellValueFactory(new PropertyValueFactory<Tables,Integer>("idModel"));
        table_query.getColumns().add(columnIdModel);
        //создание столбца model_name
        TableColumn<Tables,String> columnModelName= new TableColumn<Tables,String>("Model Name");
        columnModelName.setCellValueFactory(new PropertyValueFactory<Tables,String>("modelName"));
        table_query.getColumns().add(columnModelName);
        // создание столбца capacity
        TableColumn<Tables, Double> columnCapacity= new TableColumn<Tables, Double>("Capacity");
        columnCapacity.setCellValueFactory(new PropertyValueFactory<Tables,Double>("capacity"));
        table_query.getColumns().add(columnCapacity);
        // создание столбца volume
        TableColumn<Tables, Double> columnVolume= new TableColumn<Tables, Double>("Volume");
        columnVolume.setCellValueFactory(new PropertyValueFactory<Tables,Double>("volume"));
        table_query.getColumns().add(columnVolume);
        //создание столбца serviceLife
        TableColumn<Tables, Integer> colunmServiceLife= new TableColumn<Tables,Integer>("Service Life");
        colunmServiceLife.setCellValueFactory(new PropertyValueFactory<>("serviceLife"));
        table_query.getColumns().add(colunmServiceLife);

    }

    public void fillTableTankWagon(){
        ResultSet resultSet= db.readTable("tankwagon");
        ObservableList<Tables> boxcar= FXCollections.observableArrayList();
        try{
            while (resultSet.next()) {
                boxcar.add(new Wagons(resultSet.getInt("id_model"),resultSet.getString("model_name"),resultSet.getDouble("car_cap"),resultSet.getDouble("volume"),resultSet.getInt("st_ser_life"),resultSet.getString("model_special")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table_query.setItems(boxcar);
        //создание столбца id_model
        TableColumn<Tables, Integer> columnIdModel= new TableColumn<Tables,Integer>("id_model");
        columnIdModel.setCellValueFactory(new PropertyValueFactory<Tables,Integer>("idModel"));
        table_query.getColumns().add(columnIdModel);
        //создание столбца model_name
        TableColumn<Tables,String> columnModelName= new TableColumn<Tables,String>("Model Name");
        columnModelName.setCellValueFactory(new PropertyValueFactory<Tables,String>("modelName"));
        table_query.getColumns().add(columnModelName);
        // создание столбца capacity
        TableColumn<Tables, Double> columnCapacity= new TableColumn<Tables, Double>("Capacity");
        columnCapacity.setCellValueFactory(new PropertyValueFactory<Tables,Double>("capacity"));
        table_query.getColumns().add(columnCapacity);
        // создание столбца volume
        TableColumn<Tables, Double> columnVolume= new TableColumn<Tables, Double>("Volume");
        columnVolume.setCellValueFactory(new PropertyValueFactory<Tables,Double>("volume"));
        table_query.getColumns().add(columnVolume);
        //создание столбца serviceLife
        TableColumn<Tables, Integer> colunmServiceLife= new TableColumn<Tables,Integer>("Service Life");
        colunmServiceLife.setCellValueFactory(new PropertyValueFactory<>("serviceLife"));
        table_query.getColumns().add(colunmServiceLife);
        // создание столбца model_special
        TableColumn<Tables,String > columnModelSpecial=new TableColumn<>("Model Special");
        columnModelSpecial.setCellValueFactory(new PropertyValueFactory<>("special"));
        table_query.getColumns().add(columnModelSpecial);
    }

    public void fillTableHopper(){
        ResultSet resultSet= db.readTable("hopper");
        ObservableList<Tables> boxcar= FXCollections.observableArrayList();
        try{
            while (resultSet.next()) {
                boxcar.add(new Wagons(resultSet.getInt("id_model"),resultSet.getString("model_name"),resultSet.getDouble("car_cap"),resultSet.getDouble("volume"),resultSet.getInt("st_ser_life"),resultSet.getString("model_special"),resultSet.getInt("load_hatches"),resultSet.getInt("unload_hatches")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table_query.setItems(boxcar);
        //создание столбца id_model
        TableColumn<Tables, Integer> columnIdModel= new TableColumn<Tables,Integer>("id_model");
        columnIdModel.setCellValueFactory(new PropertyValueFactory<Tables,Integer>("idModel"));
        table_query.getColumns().add(columnIdModel);
        //создание столбца model_name
        TableColumn<Tables,String> columnModelName= new TableColumn<Tables,String>("Model Name");
        columnModelName.setCellValueFactory(new PropertyValueFactory<Tables,String>("modelName"));
        table_query.getColumns().add(columnModelName);
        // создание столбца capacity
        TableColumn<Tables, Double> columnCapacity= new TableColumn<Tables, Double>("Capacity");
        columnCapacity.setCellValueFactory(new PropertyValueFactory<Tables,Double>("capacity"));
        table_query.getColumns().add(columnCapacity);
        // создание столбца volume
        TableColumn<Tables, Double> columnVolume= new TableColumn<Tables, Double>("Volume");
        columnVolume.setCellValueFactory(new PropertyValueFactory<Tables,Double>("volume"));
        table_query.getColumns().add(columnVolume);
        // создание столбца load Hatches
        TableColumn<Tables,Integer> columnLoadHatches= new TableColumn<>("Load Hatches");
        columnLoadHatches.setCellValueFactory(new PropertyValueFactory<>("loadHatches"));
        table_query.getColumns().add(columnLoadHatches);
        //создание столбца unload Hatches
        TableColumn<Tables,Integer> columnUnLoadHatches= new TableColumn<>("UnLoad Hatches");
        columnUnLoadHatches.setCellValueFactory(new PropertyValueFactory<>("unloadHatches"));
        table_query.getColumns().add(columnUnLoadHatches);
        //создание столбца serviceLife
        TableColumn<Tables, Integer> colunmServiceLife= new TableColumn<Tables,Integer>("Service Life");
        colunmServiceLife.setCellValueFactory(new PropertyValueFactory<>("serviceLife"));
        table_query.getColumns().add(colunmServiceLife);
        // создание столбца model_special
        TableColumn<Tables,String > columnModelSpecial=new TableColumn<>("Model Special");
        columnModelSpecial.setCellValueFactory(new PropertyValueFactory<>("special"));
        table_query.getColumns().add(columnModelSpecial);
       // table_query.setPrefHeight();
    }
    @FXML
    void initialize() {
        addTablesInCheckbox();
        fillTableView();
    }
}
