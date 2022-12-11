package com.example.desktopapp.classesForTables;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Wagons  extends Tables{
    private SimpleIntegerProperty idModel;
    private SimpleStringProperty modelName;
    private SimpleDoubleProperty capacity;
    private SimpleDoubleProperty volume;
    private SimpleIntegerProperty serviceLife;
    private SimpleStringProperty special;
    private SimpleIntegerProperty loadHatches;
    private SimpleIntegerProperty unloadHatches;
    public Wagons(String type,int idModel,String modelName,double capacity,double volume,int serviceLife){
        super(type);
        this.idModel=new SimpleIntegerProperty(idModel);
        this.modelName= new SimpleStringProperty(modelName);
        this.capacity=new SimpleDoubleProperty(capacity);
        this.volume=new SimpleDoubleProperty(volume);
        this.serviceLife= new SimpleIntegerProperty(serviceLife);
    }
    public Wagons(int idModel,String modelName,double capacity,double volume,int serviseLife,String special){
        super("tankwagon");
        this.idModel=new SimpleIntegerProperty(idModel);
        this.modelName= new SimpleStringProperty(modelName);
        this.capacity=new SimpleDoubleProperty(capacity);
        this.volume=new SimpleDoubleProperty(volume);
        this.serviceLife= new SimpleIntegerProperty(serviseLife);
        this.special= new SimpleStringProperty(special);
    }
    public Wagons(int idModel,String modelName,double capacity,double volume,int serviseLife,String special,int loadHatches,int unloadHatches){
        super("hopper");
        this.idModel=new SimpleIntegerProperty(idModel);
        this.modelName= new SimpleStringProperty(modelName);
        this.capacity=new SimpleDoubleProperty(capacity);
        this.volume=new SimpleDoubleProperty(volume);
        this.serviceLife= new SimpleIntegerProperty(serviseLife);
        this.special= new SimpleStringProperty(special);
        this.loadHatches=new SimpleIntegerProperty(loadHatches);
        this.unloadHatches=new SimpleIntegerProperty(unloadHatches);
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

    public String getModelName() {
        return modelName.get();
    }

    public SimpleStringProperty modelNameProperty() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName.set(modelName);
    }

    public double getCapacity() {
        return capacity.get();
    }

    public SimpleDoubleProperty capacityProperty() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity.set(capacity);
    }

    public double getVolume() {
        return volume.get();
    }

    public SimpleDoubleProperty volumeProperty() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume.set(volume);
    }

    public double getServiceLife() {
        return serviceLife.get();
    }

    public SimpleIntegerProperty serviceLifeProperty() {
        return serviceLife;
    }

    public void setServiceLife(int serviceLife) {
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

    public int getLoadHatches() {
        return loadHatches.get();
    }

    public SimpleIntegerProperty loadHatchesProperty() {
        return loadHatches;
    }

    public void setLoadHatches(int loadHatches) {
        this.loadHatches.set(loadHatches);
    }

    public int getUnloadHatches() {
        return unloadHatches.get();
    }

    public SimpleIntegerProperty unloadHatchesProperty() {
        return unloadHatches;
    }

    public void setUnloadHatches(int unloadHatches) {
        this.unloadHatches.set(unloadHatches);
    }
}
