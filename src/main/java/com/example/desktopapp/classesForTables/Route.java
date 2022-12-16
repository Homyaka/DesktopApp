package com.example.desktopapp.classesForTables;

import javafx.beans.property.SimpleIntegerProperty;

public class Route extends Tables {
    private SimpleIntegerProperty idRoute;
    private SimpleIntegerProperty idStartLocation;
    private SimpleIntegerProperty idEndLocation;

    public Route(int idRoute,int idStartLocation,int idEndLocation){
        super("route");
        this.idRoute= new SimpleIntegerProperty(idRoute);
        this.idStartLocation= new SimpleIntegerProperty(idStartLocation);
        this.idEndLocation= new SimpleIntegerProperty(idEndLocation);
    }

    public int getIdRoute() {
        return idRoute.get();
    }

    public SimpleIntegerProperty idRouteProperty() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute.set(idRoute);
    }

    public int getIdStartLocation() {
        return idStartLocation.get();
    }

    public SimpleIntegerProperty idStartLocationProperty() {
        return idStartLocation;
    }

    public void setIdStartLocation(int idStartLocation) {
        this.idStartLocation.set(idStartLocation);
    }

    public int getIdEndLocation() {
        return idEndLocation.get();
    }

    public SimpleIntegerProperty idEndLocationProperty() {
        return idEndLocation;
    }

    public void setIdEndLocation(int idEndLocation) {
        this.idEndLocation.set(idEndLocation);
    }
}
