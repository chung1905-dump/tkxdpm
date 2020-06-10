package util;

import java.sql.*;

public class DatabaseExecutor {
    private final DatabaseConfig config;

    public DatabaseExecutor() {
        this.config = DatabaseConfig.getInstance();
    }

    public ResultSet executeQuery(String rawSQL) throws SQLException {
        Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(rawSQL);
    }

    public int executeUpdate(String rawSQL) throws SQLException {
        Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(rawSQL);
    }
}
