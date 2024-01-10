package com.example.carlos_14_lab5;

import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class OracleDB {

    private final String jdbcURL;
    private final String username;
    private final String password;
    private static OracleDataSource dataSource;
    private static OracleDB database;

    private OracleDB() {
        //These data should be stored in environmental variables, but they were declared here for practical purposes
        jdbcURL = "jdbc:oracle:thin:@//oracle1.centennialcollege.ca:1521/SQLD";
        username = "COMP228_F23_jp_36";
        password = "password";
        try{
            dataSource = new OracleDataSource();
            dataSource.setURL(jdbcURL);
            dataSource.setUser(username);
            dataSource.setPassword(password);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static OracleDB getDatabase(){
        if(database == null){
            database = new OracleDB();
        }
        return database;
    }

    public DataSource getSource() throws SQLException {
        return dataSource;
    }
}

