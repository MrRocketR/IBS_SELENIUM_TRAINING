package ru.ibs.selenium.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.selenium.training.managers.DriverManager;

public class BasePage {
    protected static WebDriver driver = DriverManager.getDriver();
    protected static Wait<WebDriver> wait = new WebDriverWait(driver, 60, 10);
}
