package com.edutech.progressive.config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

    private static final Properties properties =  new Properties();

    private static void loadProperties(){
        try{
            properties.load(new FileInputStream("application.properties"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection()throws SQLException{
        loadProperties();
        String user=properties.getProperty("spring.datasource.username");
        String pass=properties.getProperty("spring.datasource.password");
        String url=properties.getProperty("spring.datasource.url");

        return DriverManager.getConnection(url,user,pass);

    }

}
