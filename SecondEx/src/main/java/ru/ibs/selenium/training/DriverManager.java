package ru.ibs.selenium.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static ru.ibs.selenium.training.config.TestConfig.getInstance;

public class DriverManager {
    private static WebDriver driver;
    private static final Properties properties = getInstance().getProperties();

    public static WebDriver getDriver(String os) {
        if (driver == null) {
            init(os);
        }
        return driver;
    }

    private static WebDriver init(String os) {
        switch (os) {
            case "WINDOWS":
                System.setProperty(properties.getProperty("DRIVER.ENV.KEY"), "src/test/resources/chromedriver125_windows.exe");
                break;
            case "MAC":
                System.setProperty(properties.getProperty("DRIVER.ENV.KEY"), "src/test/resources/chromedriver125_mac");
                break;
            case "LINUX":
                System.setProperty(properties.getProperty("DRIVER.ENV.KEY"), "src/test/resources/chromedriver125_linux");
                break;
            default:
                throw new RuntimeException("Не выбрана правильня операционная система под инициализацию драйвера");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
    }
}
