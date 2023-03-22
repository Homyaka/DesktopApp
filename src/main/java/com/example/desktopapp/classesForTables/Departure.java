package com.example.desktopapp.classesForTables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Departure extends Tables{
    private SimpleStringProperty idDeparture;
    private SimpleStringProperty dateTimeStart;
    private SimpleStringProperty travelTime;
    private SimpleStringProperty idRoute;
    private SimpleStringProperty countCarriage;

    public Departure(String idDeparture,String dateTimeStart,String travelTime,String idRoute,String countCarriage){
        this.idDeparture=new SimpleStringProperty(idDeparture);
        this.dateTimeStart= new SimpleStringProperty(dateTimeStart);
        this.travelTime= new SimpleStringProperty(travelTime);
        this.idRoute=new SimpleStringProperty(idRoute);
        this.countCarriage= new SimpleStringProperty(countCarriage);
    }

    public String getIdDeparture() {
        return idDeparture.get();
    }

    public SimpleStringProperty idDepartureProperty() {
        return idDeparture;
    }

    public void setIdDeparture(String idDeparture) {
        this.idDeparture.set(idDeparture);
    }

    public String getDateTimeStart() {
        return dateTimeStart.get();
    }

    public SimpleStringProperty dateTimeStartProperty() {
        return dateTimeStart;
    }

    public void setDateTimeStart(String dateTimeStart) {
        this.dateTimeStart.set(dateTimeStart);
    }

    public String getTravelTime() {
        return travelTime.get();
    }

    public SimpleStringProperty travelTimeProperty() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime.set(travelTime);
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

    public String getCountCarriage() {
        return countCarriage.get();
    }

    public SimpleStringProperty countCarriageProperty() {
        return countCarriage;
    }

    public void setCountCarriage(String countCarriage) {
        this.countCarriage.set(countCarriage);
    }
}
