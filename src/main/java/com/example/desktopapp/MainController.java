package com.example.desktopapp;

import com.example.desktopapp.classesForTables.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainController {

    DbFunctions db= new DbFunctions("DBstock","postgres","1234");
    public Stage stage=new Stage();
    public int counter;
    @FXML
    private Button btn_checktables_change;

    @FXML
    private Button btn_checktables_query;

    @FXML
    private ChoiceBox<String> cb_choicetables_change;
    @FXML
    private ChoiceBox<String> cb_choicetables_query;

    @FXML
    private ChoiceBox<?> cb_add_row;

    @FXML
    private ComboBox<?> cb_remove_row;
    @FXML
    private Label add_status;
    @FXML
    private Label remove_status;

    @FXML
    private TextField tf_add_row;

    @FXML
    private TextField tb_remove_row;

    @FXML
    private Button btn_exit_system;

    @FXML
    private Button btn_query_carincity;

    @FXML
    private Button btn_query_route;

    @FXML
    private Button btn_query_volume;

    @FXML
    private Button btn_query_departure;

    @FXML
    private Button btn_add_row;

    @FXML
    private Button btn_remove_row;

    @FXML
    private Button btn_query_carronway;

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
    private Tab tab_query;

    @FXML
    private Tab tab_user;
    @FXML
    private TableView<Tables> table_query;
    @FXML
    private TableView<Tables> table_change;

    @FXML
    private TextField tb_city;

    @FXML
    private TextField tb_dep;

    @FXML
    private TextField tb_route;

    @FXML
    private TextField tb_volume;

    @FXML
    private ListView<String> list_view;

    @FXML
    private Pane work_pane;
    @FXML
    private Label error_label;

    public void exitFromSystem(){
        btn_exit_system.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("loginform.fxml"));
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
    private void addTablesInChoiceBox(){
        ObservableList<String> tables = FXCollections.observableArrayList("Крытые вагоны","Открытые вагоны","Вагоны-хопперы","Вагоны-цистерны","Отдельные вагоны","Отправления","Маршруты","Города");
        cb_choicetables_query.setItems(tables);
        cb_choicetables_change.setItems(tables);
    }

   /* public void initData(ArrayList<String> login){
        label_name.setText(login.get(0));
        label_lastname.setText(login.get(1));
        label_jobtitle.setText(login.get(2));
        label_right.setText(login.get(3));
    }*/
    public void fillTableView(TableView<Tables> table,ChoiceBox<String> choiceBox){
        try {
            String tables= choiceBox.getValue();
            table.getColumns().clear();
            table.refresh();
            switch (tables) {
                case "Крытые вагоны":
                    fillTableBoxcar(table);
                    break;
                case "Открытые вагоны":
                    fillTableGondola(table);
                    break;
                case "Вагоны-хопперы":
                    fillTableHopper(table);
                    break;
                case "Вагоны-цистерны":
                    fillTableTankWagon(table);
                    break;
                case "Отдельные вагоны":
                    fillTableCarriage(table);
                    break;
                case "Отправления":
                    fillTableDeparture(table);
                    break;
                case "Маршруты":
                    fillTableRoute(table);
                    break;
                case "Города":
                    fillTableLocation(table);
                    break;
            }
        }catch (Exception e) {System.out.println(e);}
        }
    public void fillTableBoxcar(TableView table){
        table.getItems().clear();
        ResultSet resultSet= db.readTable("boxcar");
        ObservableList<Tables> boxcarList= FXCollections.observableArrayList();
        try{
            while (resultSet.next()) {
                boxcarList.add(new Wagons("boxcar",resultSet.getInt("id_model"),resultSet.getString("model_name"),resultSet.getDouble("car_cap"),resultSet.getDouble("volume"),resultSet.getInt("st_ser_life")));
            }
        }catch (Exception e){
           System.out.println(e);
        }
        table.setItems(boxcarList);
       //создание столбца id_model
        TableColumn<Tables, Integer> columnIdModel= new TableColumn<Tables,Integer>("id_model");
        columnIdModel.setCellValueFactory(new PropertyValueFactory<Tables,Integer>("idModel"));
        table.getColumns().add(columnIdModel);
       //создание столбца model_name
        TableColumn<Tables,String> columnModelName= new TableColumn<Tables,String>("Model Name");
       columnModelName.setCellValueFactory(new PropertyValueFactory<Tables,String>("modelName"));
        table.getColumns().add(columnModelName);
       // создание столбца capacity
        TableColumn<Tables, Double> columnCapacity= new TableColumn<Tables, Double>("Capacity");
        columnCapacity.setCellValueFactory(new PropertyValueFactory<Tables,Double>("capacity"));
        table.getColumns().add(columnCapacity);
        // создание столбца volume
        TableColumn<Tables, Double> columnVolume= new TableColumn<Tables, Double>("Volume");
        columnVolume.setCellValueFactory(new PropertyValueFactory<Tables,Double>("volume"));
        table.getColumns().add(columnVolume);
        //создание столбца serviceLife
        TableColumn<Tables, Integer> colunmServiceLife= new TableColumn<Tables,Integer>("Service Life");
        colunmServiceLife.setCellValueFactory(new PropertyValueFactory<>("serviceLife"));
        table.getColumns().add(colunmServiceLife);
        table.setPrefWidth(370);
        table.setPrefHeight(170);
    }

    public void fillTableGondola(TableView table){
        table.getItems().clear();
        ResultSet resultSet= db.readTable("gondola");
        ObservableList<Tables> gondola= FXCollections.observableArrayList();
        try{
            while (resultSet.next()) {
                gondola.add(new Wagons("gondola",resultSet.getInt("id_model"),resultSet.getString("model_name"),resultSet.getDouble("car_cap"),resultSet.getDouble("volume"),resultSet.getInt("st_ser_life")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table.setItems(gondola);
        //создание столбца id_model
        TableColumn<Tables, Integer> columnIdModel= new TableColumn<Tables,Integer>("id_model");
        columnIdModel.setCellValueFactory(new PropertyValueFactory<Tables,Integer>("idModel"));
        table.getColumns().add(columnIdModel);
        //создание столбца model_name
        TableColumn<Tables,String> columnModelName= new TableColumn<Tables,String>("Model Name");
        columnModelName.setCellValueFactory(new PropertyValueFactory<Tables,String>("modelName"));
        table.getColumns().add(columnModelName);
        // создание столбца capacity
        TableColumn<Tables, Double> columnCapacity= new TableColumn<Tables, Double>("Capacity");
        columnCapacity.setCellValueFactory(new PropertyValueFactory<Tables,Double>("capacity"));
        table.getColumns().add(columnCapacity);
        // создание столбца volume
        TableColumn<Tables, Double> columnVolume= new TableColumn<Tables, Double>("Volume");
        columnVolume.setCellValueFactory(new PropertyValueFactory<Tables,Double>("volume"));
        table.getColumns().add(columnVolume);
        //создание столбца serviceLife
        TableColumn<Tables, Integer> colunmServiceLife= new TableColumn<Tables,Integer>("Service Life");
        colunmServiceLife.setCellValueFactory(new PropertyValueFactory<>("serviceLife"));
        table.getColumns().add(colunmServiceLife);
        table.setPrefWidth(370);
        table.setPrefHeight(170);

    }

    public void fillTableTankWagon(TableView table){
        table.getItems().clear();
        ResultSet resultSet= db.readTable("tankwagon");
        ObservableList<Tables> tankwagon= FXCollections.observableArrayList();
        try{
            while (resultSet.next()) {
                tankwagon.add(new Wagons(resultSet.getInt("id_model"),resultSet.getString("model_name"),resultSet.getDouble("car_cap"),resultSet.getDouble("volume"),resultSet.getInt("st_ser_life"),resultSet.getString("model_special")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table.setItems(tankwagon);
        //создание столбца id_model
        TableColumn<Tables, Integer> columnIdModel= new TableColumn<Tables,Integer>("id_model");
        columnIdModel.setCellValueFactory(new PropertyValueFactory<Tables,Integer>("idModel"));
        table.getColumns().add(columnIdModel);
        //создание столбца model_name
        TableColumn<Tables,String> columnModelName= new TableColumn<Tables,String>("Model Name");
        columnModelName.setCellValueFactory(new PropertyValueFactory<Tables,String>("modelName"));
        table.getColumns().add(columnModelName);
        // создание столбца capacity
        TableColumn<Tables, Double> columnCapacity= new TableColumn<Tables, Double>("Capacity");
        columnCapacity.setCellValueFactory(new PropertyValueFactory<Tables,Double>("capacity"));
        table.getColumns().add(columnCapacity);
        // создание столбца volume
        TableColumn<Tables, Double> columnVolume= new TableColumn<Tables, Double>("Volume");
        columnVolume.setCellValueFactory(new PropertyValueFactory<Tables,Double>("volume"));
        table.getColumns().add(columnVolume);
        //создание столбца serviceLife
        TableColumn<Tables, Integer> colunmServiceLife= new TableColumn<Tables,Integer>("Service Life");
        colunmServiceLife.setCellValueFactory(new PropertyValueFactory<>("serviceLife"));
        table.getColumns().add(colunmServiceLife);
        // создание столбца model_special
        TableColumn<Tables,String > columnModelSpecial=new TableColumn<>("Model Special");
        columnModelSpecial.setCellValueFactory(new PropertyValueFactory<>("special"));
        table.getColumns().add(columnModelSpecial);
        table.setPrefWidth(470);
        table.setPrefHeight(170);
    }

    public void fillTableHopper(TableView table){
        table.getItems().clear();
        ResultSet resultSet= db.readTable("hopper");
        ObservableList<Tables> hopper= FXCollections.observableArrayList();
        try{
            while (resultSet.next()) {
                hopper.add(new Wagons(resultSet.getInt("id_model"),resultSet.getString("model_name"),resultSet.getDouble("car_cap"),resultSet.getDouble("volume"),resultSet.getInt("st_ser_life"),resultSet.getString("model_special"),resultSet.getInt("load_hatches"),resultSet.getInt("unload_hatches")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table.setItems(hopper);
        //создание столбца id_model
        TableColumn<Tables, Integer> columnIdModel= new TableColumn<Tables,Integer>("id_model");
        columnIdModel.setCellValueFactory(new PropertyValueFactory<Tables,Integer>("idModel"));
        table.getColumns().add(columnIdModel);
        //создание столбца model_name
        TableColumn<Tables,String> columnModelName= new TableColumn<Tables,String>("Model Name");
        columnModelName.setCellValueFactory(new PropertyValueFactory<Tables,String>("modelName"));
        table.getColumns().add(columnModelName);
        // создание столбца capacity
        TableColumn<Tables, Double> columnCapacity= new TableColumn<Tables, Double>("Capacity");
        columnCapacity.setCellValueFactory(new PropertyValueFactory<Tables,Double>("capacity"));
        table.getColumns().add(columnCapacity);
        // создание столбца volume
        TableColumn<Tables, Double> columnVolume= new TableColumn<Tables, Double>("Volume");
        columnVolume.setCellValueFactory(new PropertyValueFactory<Tables,Double>("volume"));
        table.getColumns().add(columnVolume);
        // создание столбца load Hatches
        TableColumn<Tables,Integer> columnLoadHatches= new TableColumn<>("Load Hatches");
        columnLoadHatches.setCellValueFactory(new PropertyValueFactory<>("loadHatches"));
        table.getColumns().add(columnLoadHatches);
        //создание столбца unload Hatches
        TableColumn<Tables,Integer> columnUnLoadHatches= new TableColumn<>("UnLoad Hatches");
        columnUnLoadHatches.setCellValueFactory(new PropertyValueFactory<>("unloadHatches"));
        table.getColumns().add(columnUnLoadHatches);
        //создание столбца serviceLife
        TableColumn<Tables, Integer> colunmServiceLife= new TableColumn<Tables,Integer>("Service Life");
        colunmServiceLife.setCellValueFactory(new PropertyValueFactory<>("serviceLife"));
        table.getColumns().add(colunmServiceLife);
        // создание столбца model_special
        TableColumn<Tables,String > columnModelSpecial=new TableColumn<>("Model Special");
        columnModelSpecial.setCellValueFactory(new PropertyValueFactory<>("special"));
        table.getColumns().add(columnModelSpecial);
        table.setPrefWidth(670);
        table.setPrefHeight(170);
       // table_query.setPrefHeight();
    }

    public void fillTableLocation(TableView table){
        table.getItems().clear();
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
        table.setItems(locations);
        //создание столбца idLocation
        TableColumn<Tables, Integer> columnIdLocation= new TableColumn<>("id_Location");
        columnIdLocation.setCellValueFactory(new PropertyValueFactory<>("idLocation"));
        table.getColumns().add(columnIdLocation);
        //создание столбца name location
        TableColumn<Tables,String> columnNameLocation= new TableColumn<>("Name Location");
        columnNameLocation.setCellValueFactory(new PropertyValueFactory<>("nameLocation"));
        table.getColumns().add(columnNameLocation);
        table.setPrefWidth(200);
        table.setPrefHeight(500);
    }

    public void fillTableRoute(TableView table){
        table.getItems().clear();
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
        table.setItems(route);
        //создание столбца id Route
        TableColumn<Tables, Integer> columnIdRoute= new TableColumn<>("id_route");
        columnIdRoute.setCellValueFactory(new PropertyValueFactory<>("idRoute"));
        table.getColumns().add(columnIdRoute);
        //создание столбца id startLoc
        TableColumn<Tables, Integer> columnIdStart= new TableColumn<>("id_Start");
        columnIdStart.setCellValueFactory(new PropertyValueFactory<>("idStartLocation"));
        table.getColumns().add(columnIdStart);
        //
        TableColumn<Tables, Integer> columnIdEnd= new TableColumn<>("id_End");
        columnIdEnd.setCellValueFactory(new PropertyValueFactory<>("idEndLocation"));
        table.getColumns().add(columnIdEnd);
        table.setPrefWidth(200);
        table.setPrefHeight(800);
    }

    public void fillTableDeparture(TableView table){
        table.getItems().clear();
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
        table.setItems(departure);
        //создание столбца idDeparture
        TableColumn<Tables,Integer> columnIdDeparture= new TableColumn<>("id_Departure");
        columnIdDeparture.setCellValueFactory(new PropertyValueFactory<>("idDeparture"));
        table.getColumns().add(columnIdDeparture);
        //
        TableColumn<Tables,String> columnDatetimeStart= new TableColumn<>("DateTime Start");
        columnDatetimeStart.setCellValueFactory(new PropertyValueFactory<>("dateTimeStart"));
        table.getColumns().add(columnDatetimeStart);
        //
        TableColumn<Tables,String> columnTravelTime= new TableColumn<>("Travel Time");
        columnTravelTime.setCellValueFactory(new PropertyValueFactory<>("travelTime"));
        table.getColumns().add(columnTravelTime);
        //
        TableColumn<Tables,Integer> columnIdRoute= new TableColumn<>("id_Route");
        columnIdRoute.setCellValueFactory(new PropertyValueFactory<>("idRoute"));
        table.getColumns().add(columnIdRoute);
        //
        TableColumn<Tables,Integer> columnICountCarriage= new TableColumn<>("Count Carriage");
        columnICountCarriage.setCellValueFactory(new PropertyValueFactory<>("countCarriage"));
        table.getColumns().add(columnICountCarriage);
        table.setPrefWidth(460);
        table.setPrefHeight(500);
    }

    public void fillTableCarriage(TableView table){
        table.getItems().clear();
        ResultSet resultSet=db.readTable("carriage");
        ObservableList<Tables> carriage= FXCollections.observableArrayList();
        try {
            while (resultSet.next()){
                carriage.add(new Carriage(resultSet.getInt("id_carr"),resultSet.getString("wagon_type"),resultSet.getInt("id_model"),resultSet.getBoolean("full_empty"),resultSet.getString("material"),resultSet.getBoolean("on_way"),resultSet.getInt("id_pos"),resultSet.getBoolean("on_repair")));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        table.setItems(carriage);
        // создание столбца  idCarriage
        TableColumn<Tables,Integer> columnIdCarriage= new TableColumn<>("id_Carriage");
        columnIdCarriage.setCellValueFactory(new PropertyValueFactory<>("idCarriage"));
        table.getColumns().add(columnIdCarriage);
        // wagonType
        TableColumn<Tables,String> columnWagonType= new TableColumn<>("Wagon Type");
        columnWagonType.setCellValueFactory(new PropertyValueFactory<>("wagonType"));
        table.getColumns().add(columnWagonType);
        // idModel
        TableColumn<Tables,Integer> columnIdModel= new TableColumn<>("id_Model");
        columnIdModel.setCellValueFactory(new PropertyValueFactory<>("idModel"));
        table.getColumns().add(columnIdModel);
        // fullEmpty
        TableColumn<Tables,Boolean> columnFullEmpty = new TableColumn<>("full/empty");
        columnFullEmpty.setCellValueFactory(new PropertyValueFactory<>("fullEmpty"));
        table.getColumns().add(columnFullEmpty);
        //material
        TableColumn<Tables,String> columnMaterial= new TableColumn<>("Material");
        columnMaterial.setCellValueFactory(new PropertyValueFactory<>("material"));
        table.getColumns().add(columnMaterial);
        //onWay
        TableColumn<Tables,Boolean> columnOnWay = new TableColumn<>("on Way");
        columnOnWay.setCellValueFactory(new PropertyValueFactory<>("onWay"));
        table.getColumns().add(columnOnWay);
        //idPosition
        TableColumn<Tables,Integer> columnIdPosition= new TableColumn<>("id_Position");
        columnIdPosition.setCellValueFactory(new PropertyValueFactory<>("idPosition"));
        table.getColumns().add(columnIdPosition);
        //onRepair
        TableColumn<Tables,Boolean> columnOnRepair = new TableColumn<>("on Repair");
        columnOnRepair.setCellValueFactory(new PropertyValueFactory<>("onRepair"));
        table.getColumns().add(columnOnRepair);
        table.setPrefWidth(700);
        table.setPrefHeight(700);
        //int idCarriage,String wagonType,int idModel,boolean fullEmpty,String material,boolean onWay,int idPosition,boolean onRepair

    }
    public void queryGetVolume(){
        String model= tb_volume.getText();
        ObservableList<String> observableList=FXCollections.observableArrayList();
        ResultSet resultSet = null;
        ResultSet rsCarriage= db.getQuery("select wagon_type,id_model from carriage where id_carr="+model);
        try {
            if(rsCarriage.next())
                resultSet=db.getQuery("select * from "+ rsCarriage.getString("wagon_type")+" where id_model="+rsCarriage.getString("id_model"));
            if(resultSet.next()){
                observableList.add("Тип вагона: "+ rsCarriage.getString("wagon_type"));
                observableList.add("Модель вагона: "+resultSet.getString("model_name"));
                observableList.add("Грузоподъемность вагона: "+ resultSet.getString("car_cap")+" т.");
                observableList.add("Объем вагона: "+ resultSet.getString("volume")+ " м. куб");
                additionList(rsCarriage.getString("wagon_type"),observableList,resultSet);
                observableList.add("Год выпуска: " + resultSet.getString("year_manufacture"));
                observableList.add("Нормативный срок службы: "+ resultSet.getString("st_ser_life"));
                }
            list_view.setItems(observableList);
        }catch (Exception e){
            System.out.println(e);}

    }
    public void additionList(String wagon_type,ObservableList<String> observableList,ResultSet resultSet) throws Exception{
        if(wagon_type.equals("tankwagon"))
            observableList.add("Спецификация вагона: "+ resultSet.getString("model_special"));
        if(wagon_type.equals("hopper")){
            observableList.add("Спецификация вагона: "+ resultSet.getString("model_special"));
            observableList.add("Кол-во загрузочных люков: "+ resultSet.getString("load_hatches"));
            observableList.add("Кол-во рагрузочных люков: "+ resultSet.getString("unload_hatches"));
        }
    }

    public void queryCityInRoute() {
        String route=tb_route.getText();
        ObservableList<String> observableList=FXCollections.observableArrayList();
        ResultSet rsRoute=db.getQuery("Select * from route where id_route ="+route);
        try {
            if(rsRoute.next()) {
                ResultSet rsStartCity = db.getQuery("Select name_loc from location where id_loc=" + rsRoute.getString("id_startloc"));
                ResultSet rsEndCity = db.getQuery("Select name_loc from location where id_loc=" + rsRoute.getString("id_endloc"));
                if(rsStartCity.next() && rsEndCity.next()) {
                    observableList.add("Начальный город маршрута: " + rsStartCity.getString("name_loc"));
                    observableList.add("Конечный город маршрута: " + rsEndCity.getString("name_loc"));
                }
            }
        }catch (Exception e){System.out.println(e);}
        list_view.setItems(observableList);
    }

    public void queryCarInCity(){
        String city=tb_city.getText();
        ObservableList<String> observableList=FXCollections.observableArrayList();
        observableList.add("id вагонов: ");
        ResultSet rsRoute= db.getQuery("select id_route from route where id_endloc="+city+" and id_startloc="+city);//41
        try {
            if(rsRoute.next()) {
                ResultSet rsDep = db.getQuery("select * from departure where id_route=" + rsRoute.getString("id_route"));//41
                if(rsDep.next()) {
                    ResultSet rsCarr = db.getQuery("select id_carr from carriage where id_pos=" + rsDep.getString("id_dep"));
                    while (rsCarr.next())
                        observableList.add(rsCarr.getString("id_carr" ));
                }
            }
        }catch (Exception e){System.out.println(e);}
        list_view.setItems(observableList);
    }

    public void queryCarrOnWay(){
        ObservableList<String> observableList=FXCollections.observableArrayList();
        ResultSet rsCarr=db.getQuery("select id_carr,id_pos from carriage where on_way=true");
        try {
            while (rsCarr.next()){
                observableList.add("id вагона: "+rsCarr.getString("id_carr")+"; id отправления: "+rsCarr.getString("id_pos"));
            }
        }catch (Exception e){System.out.println(e);}
        list_view.setItems(observableList);
    }
    @FXML
    void initialize() {
        /*if(!label_right.getText().equals("Default") || !label_right.getText().equals("admin")) {
            work_pane.setVisible(false);
            error_label.setText("Недостаточно прав");
        }
        else {
            work_pane.setVisible(true);
            error_label.setText("");
        }*/
       // fillListView();
        addTablesInChoiceBox();
        btn_query_carronway.setOnAction(event -> {
            queryCarrOnWay();
        });
        btn_query_route.setOnAction(event -> {
            queryCityInRoute();
        });
        btn_query_volume.setOnAction(event -> {
            queryGetVolume();
        });
        btn_query_carincity.setOnAction(event -> {
            queryCarInCity();
        });
        btn_exit_system.setOnAction(event -> {
            exitFromSystem();
        });
        btn_checktables_query.setOnAction(event -> {
            if (!cb_choicetables_query.getValue().isEmpty())
                fillTableView(table_query,cb_choicetables_query);
        });
        btn_checktables_change.setOnAction(event -> {
            if(!cb_choicetables_change.getValue().isEmpty())
                fillTableView(table_change,cb_choicetables_change);
        });
    }
}
