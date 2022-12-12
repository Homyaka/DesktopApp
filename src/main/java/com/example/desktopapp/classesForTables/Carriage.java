package com.example.desktopapp.classesForTables;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Carriage extends Tables{
    private SimpleIntegerProperty idCarriage;
    private SimpleStringProperty wagonType;
    private SimpleIntegerProperty idModel;
    private SimpleBooleanProperty fullEmpty;
    private SimpleStringProperty material;
    private SimpleBooleanProperty onWay;
    private SimpleIntegerProperty idPosition;
    private SimpleBooleanProperty onRepair;

    public Carriage(int idCarriage,String wagonType,int idModel,boolean fullEmpty,String material,boolean onWay,int idPosition,boolean onRepair){
        super("Carriage");
        this.idCarriage= new SimpleIntegerProperty(idCarriage);
        this.wagonType= new SimpleStringProperty(wagonType);
        this.idModel=new SimpleIntegerProperty(idModel);
        this.fullEmpty= new SimpleBooleanProperty(fullEmpty);
        this.material= new SimpleStringProperty(material);
        this.onWay= new SimpleBooleanProperty(onWay);
        this.idPosition= new SimpleIntegerProperty(idPosition);
        this.onRepair= new SimpleBooleanProperty(onRepair);
    }

    public int getIdCarriage() {
        return idCarriage.get();
    }

    public SimpleIntegerProperty idCarriageProperty() {
        return idCarriage;
    }

    public void setIdCarriage(int idCarriage) {
        this.idCarriage.set(idCarriage);
    }

    public String getWagonType() {
        return wagonType.get();
    }

    public SimpleStringProperty wagonTypeProperty() {
        return wagonType;
    }

    public void setWagonType(String wagonType) {
        this.wagonType.set(wagonType);
    }

    public int getIdModel() {
        return idModel.get();
    }

    public SimpleIntegerProperty idModelProperty() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel.set(idModel);
    }

    public boolean isFullEmpty() {
        return fullEmpty.get();
    }

    public SimpleBooleanProperty fullEmptyProperty() {
        return fullEmpty;
    }

    public void setFullEmpty(boolean fullEmpty) {
        this.fullEmpty.set(fullEmpty);
    }

    public String getMaterial() {
        return material.get();
    }

    public SimpleStringProperty materialProperty() {
        return material;
    }

    public void setMaterial(String material) {
        this.material.set(material);
    }

    public boolean isOnWay() {
        return onWay.get();
    }

    public SimpleBooleanProperty onWayProperty() {
        return onWay;
    }

    public void setOnWay(boolean onWay) {
        this.onWay.set(onWay);
    }

    public int getIdPosition() {
        return idPosition.get();
    }

    public SimpleIntegerProperty idPositionProperty() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition.set(idPosition);
    }

    public boolean isOnRepair() {
        return onRepair.get();
    }

    public SimpleBooleanProperty onRepairProperty() {
        return onRepair;
    }

    public void setOnRepair(boolean onRepair) {
        this.onRepair.set(onRepair);
    }
}
