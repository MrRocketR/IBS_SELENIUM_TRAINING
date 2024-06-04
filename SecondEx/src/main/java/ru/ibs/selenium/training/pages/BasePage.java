package ru.ibs.selenium.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.selenium.training.DriverManager;

import java.util.Properties;

import static ru.ibs.selenium.training.config.TestConfig.getInstance;

public class BasePage {
    protected static WebDriver driver = DriverManager.getDriver();
    protected static Wait<WebDriver> wait = new WebDriverWait(driver, 10, 10);




}
