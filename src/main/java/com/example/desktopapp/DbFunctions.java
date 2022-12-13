package com.example.desktopapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class DbFunctions {
    Connection connection;

    public  DbFunctions(String dbname,String user,String pass){
        try{
         Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
         if (connection!=null)
             System.out.println("Connections Established");
         else
             System.out.println("Connections Failed");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void createTable( String query){
        Statement statement;
        try {
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }
     public void createAllTable(List<String> queryList){
         for (String str:queryList) {
             createTable(str);
         }
     }
     public ResultSet getQuery(String query){
         Statement statement;
         ResultSet resultSet=null;
         try {
             statement=connection.createStatement();
             resultSet= statement.executeQuery(query);
         }catch (Exception e){ System.out.println(e);}
         return resultSet;
     }

    public ResultSet readTable(String table_name){
        Statement statement;
        ResultSet resultSet=null;
        try {
            String query="Select * from "+ table_name;
            statement=connection.createStatement();
            resultSet= statement.executeQuery(query);
        }catch (Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public HashMap<String,String> getLoginpasswordFromBD() {
        HashMap<String, String> users_data = new HashMap<>();
        ResultSet resultSet;
        try {
            resultSet = readTable( "users");
            while (resultSet.next()) {
                users_data.put(resultSet.getString("login"), resultSet.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return users_data;
    }

    public ArrayList<String> getUserData(String login){
        ResultSet rs=readTable("users");
        ArrayList<String> data= new ArrayList<>();
        try {
            while (rs.next()){
                if(login.equals(rs.getString("login")))
                {
                    data.add(rs.getString("first_name"));
                    data.add(rs.getString("last_name"));
                    data.add(rs.getString("job_title"));
                    data.add(rs.getString("rights"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }
    public ArrayList<String> getAllQuery(){
        ArrayList<String> queryList=new ArrayList<String>();
        String location="create table location(id_loc SERIAL,name_loc varchar(200),primary key (id_loc))";
        String route="create table route(id_route SERIAL,id_startloc SERIAL,id_endloc SERIAL,primary key(id_route),foreign key(id_startloc) REFERENCES  location (id_loc),foreign key(id_endloc) REFERENCES  location (id_loc))";
        String boxcar="create table boxcar(id_model SERIAL,model_name varchar(200),car_cap real,volume real,year_manufacture integer, st_ser_life integer, primary key(id_model))";
        String gondola="create table gondola(id_model SERIAL,model_name varchar(200),car_cap real,volume real,year_manufacture integer,st_ser_life integer, primary key(id_model))";
        String tankwagon="create table tankwagon(id_model SERIAL,model_name varchar(200),car_cap real,volume real,year_manufacture integer, st_ser_life integer, model_special varchar(200),primary key(id_model))";
        String hopper="create table hopper(id_model SERIAL,model_name varchar(200),car_cap real,volume real,load_hatches integer,unload_hatches integer,year_manufacture integer,st_ser_life integer, model_special varchar(200),primary key(id_model))";
        String departure="create table departure(id_dep SERIAL,datetime_start TIMESTAMP,travel_time interval,id_route SERIAL,car_count integer, primary key(id_dep),foreign key(id_route) REFERENCES route(id_route))";
        String carriage="create table carriage(id_carr SERIAL,wagon_type varchar(200),id_model integer,full_empty boolean,material varchar(200),on_way boolean,id_pos integer,on_repair boolean," +
                "foreign key(id_pos) REFERENCES departure(id_dep))";
                //"foreign key(id_model) REFERENCES boxcar(id_model),foreign key(id_model) REFERENCES gondola(id_model),foreign key(id_model) REFERENCES tankwagon(id_model),foreign key(id_model) REFERENCES hopper(id_model))";
        String users="Create table users(id_user SERIAL,login varchar(255),password varchar(200),first_name varchar(200),last_name varchar(200),job_title varchar(200),rights varchar(200))";
        queryList.add(location);
        queryList.add(route);
        queryList.add(boxcar);
        queryList.add(gondola);
        queryList.add(tankwagon);
        queryList.add(hopper);
        queryList.add(departure);
        queryList.add(carriage);
        queryList.add(users);
        return queryList;
    }


}
