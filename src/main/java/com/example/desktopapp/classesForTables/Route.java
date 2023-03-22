package com.example.desktopapp.classesForTables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Route extends Tables {
    private SimpleStringProperty idRoute;
    private SimpleStringProperty idStartLocation;
    private SimpleStringProperty idEndLocation;

    public Route(String idRoute,String idStartLocation,String idEndLocation){
        this.idRoute= new SimpleStringProperty(idRoute);
        this.idStartLocation= new SimpleStringProperty(idStartLocation);
        this.idEndLocation= new SimpleStringProperty(idEndLocation);
    }

    public String getIdRoute() {
        return idRoute.get();
    }

    public SimpleStringProperty idRouteProperty() {
        return idRoute;
    }

    public void setIdRoute(String idRoute) {
        this.idRoute.set(idRoute);
    }

    public String getIdStartLocation() {
        return idStartLocation.get();
    }

    public SimpleStringProperty idStartLocationProperty() {
        return idStartLocation;
    }

    public void setIdStartLocation(String idStartLocation) {
        this.idStartLocation.set(idStartLocation);
    }

    public String getIdEndLocation() {
        return idEndLocation.get();
    }

    public SimpleStringProperty idEndLocationProperty() {
        return idEndLocation;
    }

    public void setIdEndLocation(String idEndLocation) {
        this.idEndLocation.set(idEndLocation);
    }
}
