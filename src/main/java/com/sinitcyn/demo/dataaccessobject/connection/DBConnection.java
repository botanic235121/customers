package com.sinitcyn.demo.dataaccessobject.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static Connection con = null;

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Properties properties = new Properties();
            String user = "fgyphfqxmlfmct";
            String password = "ddc0ad120b876b742270cf10135fd7ebbd445b94e834611c66fd3fe3ed0acbf9";
            String url = "jdbc:postgresql://ec2-46-137-188-105.eu-west-1.compute.amazonaws.com:5432/d1rqvcgm0nt3d8" + "?sslmode=require";
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            properties.setProperty("characterEncoding", "UTF-8");
            con = DriverManager.getConnection(url, properties);
            System.out.println("Got our connection");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}
