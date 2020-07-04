package util;

import java.util.Properties;

public class DatabaseConfig {
    private static DatabaseConfig instance;

    private final String configFile = "config.ini";

    private Properties properties = null;

    private DatabaseConfig() {
    }

    public static DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }

        return new DatabaseConfig();
    }

    private Properties getProperties() {
        if (properties == null) {
            try {
                properties = new ConfigReader().load(configFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public String getUrl() {
        return getProperties().getProperty("db_url");
    }

    public String getUsername() {
        return getProperties().getProperty("db_username");
    }

    public String getPassword() {
        return getProperties().getProperty("db_password");
    }
}
