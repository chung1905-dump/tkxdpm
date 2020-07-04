package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public Properties load(String file) throws IOException {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream(file);
        props.load(in);
        return props;
    }
}
