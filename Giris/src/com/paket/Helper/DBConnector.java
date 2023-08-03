package com.paket.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private Connection baglan;

    public Connection connector(){
        try {
            this.baglan= DriverManager.getConnection(Config.CONNECT_URL,Config.CONNECT_USER,Config.CONNECT_PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.baglan;
    }
    public static Connection baglantiYap(){
        DBConnector dbc= new DBConnector();

        return dbc.connector();
    }
}
