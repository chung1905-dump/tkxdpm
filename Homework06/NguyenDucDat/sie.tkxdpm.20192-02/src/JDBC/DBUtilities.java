package JDBC;

import java.sql.*;

import util.DatabaseConfig;

public class DBUtilities {

    private static Connection dbConnection = null;
    private static Statement statement = null;

    public static Connection getConnection()
    {
<<<<<<< HEAD
        if (dbConnection != null)
        {
            return dbConnection;
        }
        else
        {
            try
            {
                InputStream inputStream = DBUtilities.class.getClassLoader().getResourceAsStream("db.properties");

                //Properties properties = new Properties();

                //properties.load(inputStream);
                //Connection dbConnection = null;
                dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tkxdpm?autoReconnect=true&useSSL=false",
    					"root", "luongbeat");
                
//                String dbDriver = properties.getProperty("dbDriver");
//                String connectionUrl = properties.getProperty("connectionUrl");
//                String userName = properties.getProperty("userName");
//                String password = properties.getProperty("password");
//
//                Class.forName(dbDriver).newInstance();
//                dbConnection = DriverManager.getConnection(connectionUrl, userName, password);
            }
            catch (Exception e)
            {
=======
        if (dbConnection == null) {
            try {
                DatabaseConfig config = DatabaseConfig.getInstance();
                dbConnection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            } catch (Exception e) {
>>>>>>> 37e6aa55e18d21e81d2757e85a310e76d5b88f07
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
