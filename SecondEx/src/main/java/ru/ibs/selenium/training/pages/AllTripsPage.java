package ru.ibs.selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllTripsPage extends BasePage {

    @FindBy(xpath = "//a[@title='Создать командировку']")
    WebElement createTripLink;

    public void checkCreateTripLink() {
        wait.until(ExpectedConditions.visibilityOf(createTripLink));
    }

    public void clickCreateTripLink() {
        createTripLink.click();
    }

}
