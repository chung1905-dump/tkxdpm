package util;

import java.sql.*;

public class DatabaseExecutor {
    private final Connection connection;

    private static DatabaseExecutor instance;

    private DatabaseExecutor() throws SQLException {
        DatabaseConfig config = DatabaseConfig.getInstance();
        connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
    }

    public static DatabaseExecutor getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseExecutor();
        }
        return instance;
    }

    public ResultSet executeQuery(String rawSQL) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(rawSQL);
    }

    public int executeUpdate(String rawSQL) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(rawSQL);
    }
}
