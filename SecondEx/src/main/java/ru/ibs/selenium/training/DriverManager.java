package ru.ibs.selenium.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static ru.ibs.selenium.training.config.TestConfig.getInstance;

public class DriverManager {
    private static WebDriver driver;
    private static final Properties properties = getInstance().getProperties();

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static void initDriver() {
        System.setProperty(properties.getProperty("DRIVER.ENV.KEY"), properties.getProperty("DRIVER.ENV.VALUE"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void closeDriver() {
        driver.quit();
    }
}
