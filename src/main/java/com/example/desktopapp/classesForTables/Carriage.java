package com.example.desktopapp.classesForTables;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Carriage extends Tables{
    private SimpleStringProperty idCarriage;
    private SimpleStringProperty wagonType;
    private SimpleStringProperty idModel;
    private SimpleStringProperty fullEmpty;
    private SimpleStringProperty material;
    private SimpleStringProperty onWay;
    private SimpleStringProperty idPosition;
    private SimpleStringProperty onRepair;

    public Carriage() {
    }

    public Carriage(String idCarriage, String wagonType, String idModel, String fullEmpty, String material, String onWay, String idPosition, String onRepair){
        this.idCarriage= new SimpleStringProperty(idCarriage);
        this.wagonType= new SimpleStringProperty(wagonType);
        this.idModel=new SimpleStringProperty(idModel);
        this.fullEmpty= new SimpleStringProperty(fullEmpty);
        this.material= new SimpleStringProperty(material);
        this.onWay= new SimpleStringProperty(onWay);
        this.idPosition= new SimpleStringProperty(idPosition);
        this.onRepair= new SimpleStringProperty(onRepair);
    }

    public String getIdCarriage() {
        return idCarriage.get();
    }

    public SimpleStringProperty idCarriageProperty() {
        return idCarriage;
    }

    public void setIdCarriage(String idCarriage) {
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

    public String getIdModel() {
        return idModel.get();
    }

    public SimpleStringProperty idModelProperty() {
        return idModel;
    }

    public void setIdModel(String idModel) {
        this.idModel.set(idModel);
    }

    public String getFullEmpty() {
        return fullEmpty.get();
    }

    public SimpleStringProperty fullEmptyProperty() {
        return fullEmpty;
    }

    public void setFullEmpty(String fullEmpty) {
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

    public String getOnWay() {
        return onWay.get();
    }

    public SimpleStringProperty onWayProperty() {
        return onWay;
    }

    public void setOnWay(String onWay) {
        this.onWay.set(onWay);
    }

    public String getIdPosition() {
        return idPosition.get();
    }

    public SimpleStringProperty idPositionProperty() {
        return idPosition;
    }

    public void setIdPosition(String idPosition) {
        this.idPosition.set(idPosition);
    }

    public String getOnRepair() {
        return onRepair.get();
    }

    public SimpleStringProperty onRepairProperty() {
        return onRepair;
    }

    public void setOnRepair(String onRepair) {
        this.onRepair.set(onRepair);
    }
}
