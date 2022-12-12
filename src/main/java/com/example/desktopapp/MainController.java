package com.example.desktopapp;

import com.example.desktopapp.classesForTables.*;
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
        String table= cb_choicetables_query.getValue();
        try {
            table_query.getColumns().clear();
            table_query.refresh();
            switch (table) {
                case "Крытые вагоны":
                    fillTableBoxcar();
                    break;
                case "Открытые вагоны":
                    fillTableGondola();
                    break;
                case "Вагоны-хопперы":
                    fillTableHopper();
                    break;
                case "Вагоны-цистерны":
                    fillTableTankWagon();
                    break;
                case "Отдельные вагоны":
                    fillTableCarriage();
                    break;
                case "Отправления":
                    fillTableDeparture();
                    break;
                case "Маршруты":
                    fillTableRoute();
                    break;
                case "Города":
                    fillTableLocation();
                    break;
            }
        }catch (Exception e) {System.out.println(e);}
            //fillTableDeparture();
            //fillTableCarriage();
        }
    public void fillTableBoxcar(){
        table_query.getItems().clear();
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
        table_query.getItems().clear();
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
        table_query.getItems().clear();
        ResultSet resultSet= db.readTable("tankwagon");
        ObservableList<Tables> tankwagon= FXCollections.observableArrayList();
        try{
            while (resultSet.next()) {
                tankwagon.add(new Wagons(resultSet.getInt("id_model"),resultSet.getString("model_name"),resultSet.getDouble("car_cap"),resultSet.getDouble("volume"),resultSet.getInt("st_ser_life"),resultSet.getString("model_special")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table_query.setItems(tankwagon);
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
        table_query.getItems().clear();
        ResultSet resultSet= db.readTable("hopper");
        ObservableList<Tables> hopper= FXCollections.observableArrayList();
        try{
            while (resultSet.next()) {
                hopper.add(new Wagons(resultSet.getInt("id_model"),resultSet.getString("model_name"),resultSet.getDouble("car_cap"),resultSet.getDouble("volume"),resultSet.getInt("st_ser_life"),resultSet.getString("model_special"),resultSet.getInt("load_hatches"),resultSet.getInt("unload_hatches")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table_query.setItems(hopper);
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

    public void fillTableLocation(){
        table_query.getItems().clear();
        ResultSet resultSet= db.readTable("location");
        ObservableList<Tables> locations= FXCollections.observableArrayList();
        try {
            while (resultSet.next())
            {
                locations.add(new Location(resultSet.getInt("id_loc"),resultSet.getString("name_loc")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table_query.setItems(locations);
        //создание столбца idLocation
        TableColumn<Tables, Integer> columnIdLocation= new TableColumn<>("id_Location");
        columnIdLocation.setCellValueFactory(new PropertyValueFactory<>("idLocation"));
        table_query.getColumns().add(columnIdLocation);
        //создание столбца name location
        TableColumn<Tables,String> columnNameLocation= new TableColumn<>("Name Location");
        columnNameLocation.setCellValueFactory(new PropertyValueFactory<>("nameLocation"));
        table_query.getColumns().add(columnNameLocation);
    }

    public void fillTableRoute(){
        table_query.getItems().clear();
        ResultSet resultSet=db.readTable("route");
        ObservableList<Tables> route= FXCollections.observableArrayList();
        try {
            while (resultSet.next())
            {
                route.add(new Route(resultSet.getInt("id_route"),resultSet.getInt("id_startloc"),resultSet.getInt("id_endloc")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table_query.setItems(route);
        //создание столбца id Route
        TableColumn<Tables, Integer> columnIdRoute= new TableColumn<>("id_route");
        columnIdRoute.setCellValueFactory(new PropertyValueFactory<>("idRoute"));
        table_query.getColumns().add(columnIdRoute);
        //создание столбца id startLoc
        TableColumn<Tables, Integer> columnIdStart= new TableColumn<>("id_Start");
        columnIdStart.setCellValueFactory(new PropertyValueFactory<>("idStartLocation"));
        table_query.getColumns().add(columnIdStart);
        //
        TableColumn<Tables, Integer> columnIdEnd= new TableColumn<>("id_End");
        columnIdEnd.setCellValueFactory(new PropertyValueFactory<>("idEndLocation"));
        table_query.getColumns().add(columnIdEnd);
    }

    public void fillTableDeparture(){
        table_query.getItems().clear();
        ResultSet resultSet=db.readTable("departure");
        ObservableList<Tables> departure= FXCollections.observableArrayList();
        try {
            while (resultSet.next())
            {
                departure.add(new Departure(resultSet.getInt("id_dep"),resultSet.getString("datetime_start"),resultSet.getString("travel_time"),resultSet.getInt("id_route"),resultSet.getInt("car_count")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table_query.setItems(departure);
        //создание столбца idDeparture
        TableColumn<Tables,Integer> columnIdDeparture= new TableColumn<>("id_Departure");
        columnIdDeparture.setCellValueFactory(new PropertyValueFactory<>("idDeparture"));
        table_query.getColumns().add(columnIdDeparture);
        //
        TableColumn<Tables,String> columnDatetimeStart= new TableColumn<>("DateTime Start");
        columnDatetimeStart.setCellValueFactory(new PropertyValueFactory<>("dateTimeStart"));
        table_query.getColumns().add(columnDatetimeStart);
        //
        TableColumn<Tables,String> columnTravelTime= new TableColumn<>("Travel Time");
        columnTravelTime.setCellValueFactory(new PropertyValueFactory<>("travelTime"));
        table_query.getColumns().add(columnTravelTime);
        //
        TableColumn<Tables,Integer> columnIdRoute= new TableColumn<>("id_Route");
        columnIdRoute.setCellValueFactory(new PropertyValueFactory<>("idRoute"));
        table_query.getColumns().add(columnIdRoute);
        //
        TableColumn<Tables,Integer> columnICountCarriage= new TableColumn<>("Count Carriage");
        columnICountCarriage.setCellValueFactory(new PropertyValueFactory<>("countCarriage"));
        table_query.getColumns().add(columnICountCarriage);
    }

    public void fillTableCarriage(){
        table_query.getItems().clear();
        ResultSet resultSet=db.readTable("carriage");
        ObservableList<Tables> carriage= FXCollections.observableArrayList();
        try {
            while (resultSet.next()){
                carriage.add(new Carriage(resultSet.getInt("id_carr"),resultSet.getString("wagon_type"),resultSet.getInt("id_model"),resultSet.getBoolean("full_empty"),resultSet.getString("material"),resultSet.getBoolean("on_way"),resultSet.getInt("id_pos"),resultSet.getBoolean("on_repair")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table_query.setItems(carriage);
        // создание столбца  idCarriage
        TableColumn<Tables,Integer> columnIdCarriage= new TableColumn<>("id_Carriage");
        columnIdCarriage.setCellValueFactory(new PropertyValueFactory<>("idCarriage"));
        table_query.getColumns().add(columnIdCarriage);
        // wagonType
        TableColumn<Tables,String> columnWagonType= new TableColumn<>("Wagon Type");
        columnWagonType.setCellValueFactory(new PropertyValueFactory<>("wagonType"));
        table_query.getColumns().add(columnWagonType);
        // idModel
        TableColumn<Tables,Integer> columnIdModel= new TableColumn<>("id_Model");
        columnIdModel.setCellValueFactory(new PropertyValueFactory<>("idModel"));
        table_query.getColumns().add(columnIdModel);
        // fullEmpty
        TableColumn<Tables,Boolean> columnFullEmpty = new TableColumn<>("full/empty");
        columnFullEmpty.setCellValueFactory(new PropertyValueFactory<>("fullEmpty"));
        table_query.getColumns().add(columnFullEmpty);
        //material
        TableColumn<Tables,String> columnMaterial= new TableColumn<>("Material");
        columnMaterial.setCellValueFactory(new PropertyValueFactory<>("material"));
        table_query.getColumns().add(columnMaterial);
        //onWay
        TableColumn<Tables,Boolean> columnOnWay = new TableColumn<>("on Way");
        columnOnWay.setCellValueFactory(new PropertyValueFactory<>("onWay"));
        table_query.getColumns().add(columnOnWay);
        //idPosition
        TableColumn<Tables,Integer> columnIdPosition= new TableColumn<>("id_Position");
        columnIdPosition.setCellValueFactory(new PropertyValueFactory<>("idPosition"));
        table_query.getColumns().add(columnIdPosition);
        //onRepair
        TableColumn<Tables,Boolean> columnOnRepair = new TableColumn<>("on Repair");
        columnOnRepair.setCellValueFactory(new PropertyValueFactory<>("onRepair"));
        table_query.getColumns().add(columnOnRepair);
        table_query.setPrefWidth(700);
        //int idCarriage,String wagonType,int idModel,boolean fullEmpty,String material,boolean onWay,int idPosition,boolean onRepair

    }
    @FXML
    void initialize() {
        addTablesInCheckbox();
        btn_checktables_query.setOnAction(event -> {
            if (!cb_choicetables_query.getValue().isEmpty())
                fillTableView();
        });
        //fillTableView();
    }
}
