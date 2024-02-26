package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    //Creating Connection
    public static Connection connection;

    //Creating universal method to open connect will mysql database
    public static Connection getConnection() {
        try {
            //Registering with mysql Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "root00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (connection);
    }

    //Creating universal method to close connect will mysql database
    public static void CloseConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //Creating universal method to query for retriving information
    public static ResultSet getResultFromSqlQuery(String SqlQueryString) {
        //Creating Resultset object
        ResultSet rs = null;
        try {
            //Checking whether the connection is null or null
            if (connection == null) {
                getConnection();
            }
            //Querying the query
            rs = connection.createStatement().executeQuery(SqlQueryString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    //Creating universal method to query for inserting or updating information in mysql database
    public static int insertUpdateFromSqlQuery(String SqlQueryString) {
        int i = 2;
        try {
            //Checking whether the connection is null or null
            if (connection == null) {
                getConnection();
            }
            //Querying the query
            i = connection.createStatement().executeUpdate(SqlQueryString);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }
}
