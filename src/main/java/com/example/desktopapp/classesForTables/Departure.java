package com.example.desktopapp.classesForTables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Departure extends Tables{
    private SimpleIntegerProperty idDeparture;
    private SimpleStringProperty dateTimeStart;
    private SimpleStringProperty travelTime;
    private SimpleIntegerProperty idRoute;
    private SimpleIntegerProperty countCarriage;

    public Departure(int idDeparture,String dateTimeStart,String travelTime,int idRoute,int countCarriage){
        super("departure");
        this.idDeparture=new SimpleIntegerProperty(idDeparture);
        this.dateTimeStart= new SimpleStringProperty(dateTimeStart);
        this.travelTime= new SimpleStringProperty(travelTime);
        this.idRoute=new SimpleIntegerProperty(idRoute);
        this.countCarriage= new SimpleIntegerProperty(countCarriage);
    }

    public int getIdDeparture() {
        return idDeparture.get();
    }

    public SimpleIntegerProperty idDepartureProperty() {
        return idDeparture;
    }

    public void setIdDeparture(int idDeparture) {
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

    public int getIdRoute() {
        return idRoute.get();
    }

    public SimpleIntegerProperty idRouteProperty() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute.set(idRoute);
    }

    public int getCountCarriage() {
        return countCarriage.get();
    }

    public SimpleIntegerProperty countCarriageProperty() {
        return countCarriage;
    }

    public void setCountCarriage(int countCarriage) {
        this.countCarriage.set(countCarriage);
    }
}
