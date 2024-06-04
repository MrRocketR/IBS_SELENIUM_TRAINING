package ru.ibs.selenium.training.pages;

import org.openqa.selenium.WebDriver;
import ru.ibs.selenium.training.DriverManager;

public class BasePage {
    protected WebDriver driver;

    protected void initWebDriver(String os) {
        driver = DriverManager.getDriver(os);
    }
}
