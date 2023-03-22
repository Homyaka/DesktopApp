package com.example.desktopapp.classesForTables;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Wagons  extends Tables{
    private SimpleStringProperty idModel;
    private SimpleStringProperty modelName;
    private SimpleStringProperty capacity;
    private SimpleStringProperty volume;

    private SimpleStringProperty yearManufacture;
    private SimpleStringProperty serviceLife;
    private SimpleStringProperty special;
    private SimpleStringProperty loadHatches;
    private SimpleStringProperty unloadHatches;

    public Wagons(String idModel, String modelName, String capacity, String volume, String yearManufacture, String serviceLife) {
        this.idModel = new SimpleStringProperty(idModel) ;
        this.modelName =new SimpleStringProperty(modelName);
        this.capacity = new SimpleStringProperty(capacity);
        this.volume = new SimpleStringProperty(volume);
        this.yearManufacture =new SimpleStringProperty( yearManufacture);
        this.serviceLife = new SimpleStringProperty(serviceLife);
    }
    public Wagons( String idModel, String modelName, String capacity, String volume, String yearManufacture, String serviceLife, String special) {
        this.idModel = new SimpleStringProperty(idModel);
        this.modelName = new SimpleStringProperty(modelName);
        this.capacity =new SimpleStringProperty( capacity);
        this.volume =new SimpleStringProperty( volume);
        this.yearManufacture = new SimpleStringProperty(yearManufacture);
        this.serviceLife = new SimpleStringProperty(serviceLife);
        this.special = new SimpleStringProperty(special);
    }

    public Wagons( String idModel, String modelName, String capacity, String volume, String yearManufacture, String serviceLife, String special, String loadHatches, String unloadHatches) {
        this.idModel = new SimpleStringProperty(idModel);
        this.modelName = new SimpleStringProperty(modelName);
        this.capacity =new SimpleStringProperty( capacity);
        this.volume =new SimpleStringProperty( volume);
        this.yearManufacture = new SimpleStringProperty(yearManufacture);
        this.serviceLife = new SimpleStringProperty(serviceLife);
        this.special = new SimpleStringProperty(special);
        this.loadHatches = new SimpleStringProperty(loadHatches);
        this.unloadHatches = new SimpleStringProperty(unloadHatches);
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

    public String getModelName() {
        return modelName.get();
    }

    public SimpleStringProperty modelNameProperty() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName.set(modelName);
    }

    public String getCapacity() {
        return capacity.get();
    }

    public SimpleStringProperty capacityProperty() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity.set(capacity);
    }

    public String getVolume() {
        return volume.get();
    }

    public SimpleStringProperty volumeProperty() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume.set(volume);
    }

    public String getYearManufacture() {
        return yearManufacture.get();
    }

    public SimpleStringProperty yearManufactureProperty() {
        return yearManufacture;
    }

    public void setYearManufacture(String yearManufacture) {
        this.yearManufacture.set(yearManufacture);
    }

    public String getServiceLife() {
        return serviceLife.get();
    }

    public SimpleStringProperty serviceLifeProperty() {
        return serviceLife;
    }

    public void setServiceLife(String serviceLife) {
        this.serviceLife.set(serviceLife);
    }

    public String getSpecial() {
        return special.get();
    }

    public SimpleStringProperty specialProperty() {
        return special;
    }

    public void setSpecial(String special) {
        this.special.set(special);
    }

    public String getLoadHatches() {
        return loadHatches.get();
    }

    public SimpleStringProperty loadHatchesProperty() {
        return loadHatches;
    }

    public void setLoadHatches(String loadHatches) {
        this.loadHatches.set(loadHatches);
    }

    public String getUnloadHatches() {
        return unloadHatches.get();
    }

    public SimpleStringProperty unloadHatchesProperty() {
        return unloadHatches;
    }

    public void setUnloadHatches(String unloadHatches) {
        this.unloadHatches.set(unloadHatches);
    }
}
