package ru.ibs.selenium.training.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {

    private final Properties properties = new Properties();

    private static TestConfig INSTANCE = null;

    private TestConfig() {
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestConfig();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }

}
