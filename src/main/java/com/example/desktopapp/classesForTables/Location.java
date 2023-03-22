package com.example.desktopapp.classesForTables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Location extends Tables {
    private SimpleStringProperty idLocation;
    private SimpleStringProperty nameLocation;

    public Location(String idLocation,String nameLocation){
        this.idLocation=new SimpleStringProperty(idLocation);
        this.nameLocation=new SimpleStringProperty(nameLocation);
    }

    public String getIdLocation() {
        return idLocation.get();
    }

    public SimpleStringProperty idLocationProperty() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
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
