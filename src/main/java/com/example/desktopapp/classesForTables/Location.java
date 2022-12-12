package com.example.desktopapp.classesForTables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Location extends Tables {
    private SimpleIntegerProperty idLocation;
    private SimpleStringProperty nameLocation;

    public Location(int idLocation,String nameLocation){
        super("location");
        this.idLocation=new SimpleIntegerProperty(idLocation);
        this.nameLocation=new SimpleStringProperty(nameLocation);
    }

    public int getIdLocation() {
        return idLocation.get();
    }

    public SimpleIntegerProperty idLocationProperty() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation.set(idLocation);
    }

    public String getNameLocation() {
        return nameLocation.get();
    }

    public SimpleStringProperty nameLocationProperty() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation.set(nameLocation);
    }
}
