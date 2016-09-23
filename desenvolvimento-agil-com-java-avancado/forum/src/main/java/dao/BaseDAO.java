package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO {

    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";
    private static final String JDBC_POSTGRESQL = "jdbc:postgresql://127.0.0.1:5432/forum?charSet=UTF-8";

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
