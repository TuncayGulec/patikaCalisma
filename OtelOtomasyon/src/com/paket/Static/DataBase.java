package com.paket.Static;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String CONNECT_URL="jdbc:mysql://localhost/otel";
    private static final String CONNECT_USER="root";
    private static final String CONNECT_PASS="mysql";
    private Connection baglan;

    public Connection connector(){
        try {
            this.baglan= DriverManager.getConnection(CONNECT_URL,CONNECT_USER,CONNECT_PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.baglan;
    }
    public static Connection baglantiYap(){
        DataBase dbc= new DataBase();

        return dbc.connector();
    }
}
