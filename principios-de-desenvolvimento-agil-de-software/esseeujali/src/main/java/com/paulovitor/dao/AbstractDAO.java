package com.paulovitor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {

    public static final String USUARIO = "postgres";
    public static final String SENHA = "postgres";
    public static final String JDBC_POSTGRESQL = "jdbc:postgresql://localhost:5432/esseeujali?charSet=UTF-8";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_POSTGRESQL, USUARIO, SENHA);
    }
}
