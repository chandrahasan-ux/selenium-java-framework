package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader — Reads key-value pairs from config.properties file.
 */
public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            String configPath = System.getProperty("user.dir")
                    + "/src/test/resources/config.properties";
            FileInputStream fis = new FileInputStream(configPath);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("config.properties file not found! " + e.getMessage());
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key not found in config.properties: " + key);
        }
        return value.trim();
    }
}
