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
     public void createUsersTable(Connection conn){
       String query="Create table users(id_user SERIAL,login varchar(255),password varchar(200),first_name varchar(200),last_name varchar(200),job_title varchar(200),rights varchar(200))";
       Statement statement;
       try {
           statement=conn.createStatement();
           statement.executeUpdate(query);
           System.out.println("Table Created");
       }catch (Exception e){
           System.out.println(e);
         }
    }
    /*public List<String> getAllQuery(){
        List<String> queryList=new ArrayList<String>();
        String location="create table location(id_loc SERIAL,name_loc varchar(200),primary key (id_loc))";
        String route="create table route(id_route SERIAL,id_startloc SERIAL,id_endloc SERIAL,primary key(id_route),foreign key(id_startloc) REFERENCES  location (id_loc),foreign key(id_endloc) REFERENCES  location (id_loc))";
        String boxcar="create table boxcar(id_model SERIAL,model_name varchar(200),car_cap real,volume real,year_manufacture integer, st_ser_life integer, primary key(id_model))";
        String gondola="create table gondola(id_model SERIAL,model_name varchar(200),car_cap real,volume real,year_manufacture integer,st_ser_life integer, primary key(id_model))";
        String tankwagon="create table tankwagon(id_model SERIAL,model_name varchar(200),car_cap real,volume real,year_manufacture integer, st_ser_life integer, model_special varchar(200),primary key(id_model))";
        String hopper="create table hopper(id_model SERIAL,model_name varchar(200),car_cap real,volume real,load_hatches integer,unload_hatches integer,year_manufacture integer,st_ser_life integer, model_special varchar(200),primary key(id_model))";
        String departure="create table departure(id_dep SERIAL,datetime_start TIMESTAMP,travel_time interval,id_route SERIAL,car_count integer, primary key(id_dep),foreign key(id_route) REFERENCES route(id_route))";
        String carriage="create table carriage(id_carr SERIAL,wagon_type varchar(200),id_model SERIAL,full_empty boolean,material varchar(200),on_way boolean,id_pos SERIAL,on_repair boolean," +
                "foreign key(id_pos) REFERENCES departure(id_dep),foreign key(id_pos) REFERENCES location (id_loc)," +
                "foreign key(id_model) REFERENCES boxcar(id_model),foreign key(id_model) REFERENCES gondola(id_model),foreign key(id_model) REFERENCES tankwagon(id_model),foreign key(id_model) REFERENCES hopper(id_model))";
        queryList.add(location);
        queryList.add(route);
        queryList.add(boxcar);
        queryList.add(gondola);
        queryList.add(tankwagon);
        queryList.add(hopper);
        queryList.add(departure);
        queryList.add(carriage);
        return queryList;
    }*/


}
