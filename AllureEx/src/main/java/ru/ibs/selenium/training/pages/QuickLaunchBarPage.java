package ru.ibs.selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuickLaunchBarPage extends BasePage {

    @FindBy(xpath = "//h1[text() = 'Панель быстрого запуска']")
    WebElement quickLaunchTitle;
    @FindBy(xpath = "//ul[contains(@class,'multilevel main-menu')]/li/a/span[text()='Расходы']")
    WebElement expensesList;
    @FindBy(xpath = "//ul[contains(@class,'ropdown-menu menu_level_1')]//a/span[text()='Командировки']/..")
    WebElement tripsLink;

    public QuickLaunchBarPage() {
        PageFactory.initElements(driver, this);
    }


    public void checkQuickLaunchTitle() {
        wait.until(ExpectedConditions.visibilityOf(quickLaunchTitle));
    }

    public void clickTripsFromList() {
        expensesList.click();
        wait.until(ExpectedConditions.visibilityOf(tripsLink));
        tripsLink.click();
    }
}
