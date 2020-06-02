package util;

import java.sql.*;

public class DatabaseExecutor {
    public ResultSet executeQuery(String rawSQL) throws SQLException {
        DatabaseConfig config = new DatabaseConfig();
        Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(rawSQL);
    }
}
