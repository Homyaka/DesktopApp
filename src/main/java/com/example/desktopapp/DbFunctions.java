package com.example.desktopapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

public class DbFunctions {
    public Connection connect_db(String dbname,String user,String pass){
        Connection conn=null;
        try{
         Class.forName("org.postgresql.Driver");
         conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
         if (conn!=null)
             System.out.println("Connections Established");
         else
             System.out.println("Connections Failed");
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    public void createTable(Connection conn, String query){
        Statement statement;
        try {
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }
     public void createAllTable(Connection conn,List<String> queryList){
         for (String str:queryList) {
             createTable(conn,str);
         }
     }
    public List<String> getAllQuery(){
        List<String> queryList=new ArrayList<String>();
        String location="create table location(id_loc SERIAL,name_loc varchar(200),primary key (id_loc))";
        String route="create table route(id_route SERIAL,id_startloc SERIAL,id_endloc SERIAL,primary key(id_route),foreign key(id_startloc) REFERENCES  location (id_loc),foreign key(id_endloc) REFERENCES  location (id_loc))";
        String boxcar="create table boxcar(id_model SERIAL,model_name varchar(200),car_cap real,volume real,st_ser_life integer, primary key(id_model))";
        String gondola="create table gondola(id_model SERIAL,model_name varchar(200),car_cap real,volume real,st_ser_life integer, primary key(id_model))";
        String tankwagon="create table tankwagon(id_model SERIAL,model_name varchar(200),car_cap real,volume real,st_ser_life integer, model_special varchar(200),primary key(id_model))";
        String hopper="create table hopper(id_model SERIAL,model_name varchar(200),car_cap real,volume real,st_ser_life integer, model_special varchar(200),primary key(id_model))";
        String departure="create table(id_dep SERIAL,datetime_start TIMESTAMP,travel_time interval,id_route SERIAL,car_count integer, primary key(id_dep),foreign key(id_route) REFERENCES route(id_route))";
        queryList.add(location);
        queryList.add(route);
        queryList.add(boxcar);
        queryList.add(gondola);
        queryList.add(tankwagon);
        queryList.add(hopper);
        queryList.add(departure);
        return queryList;
    }


}
