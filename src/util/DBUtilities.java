package util;

import java.sql.*;

public class DBUtilities {

    private static Connection dbConnection = null;
    private static Statement statement = null;

    public static Connection getConnection()
    {
        if (dbConnection == null) {
            try {
                DatabaseConfig config = DatabaseConfig.getInstance();
                dbConnection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dbConnection;
    }

    public static void ExecuteSQLStatement(String sql_stmt)
    {
        try {
            statement = getConnection().createStatement();

            statement.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }
}
