package ru.ibs.selenium.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    @FindBy(xpath = "//button/span[text()='Каталог']")
    WebElement openCatalogBtn;

    String catalogFilter = "//div[text()='%s']";

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void openCatalog() {
        openCatalogBtn.click();
    }

    public void pickPosition(String position) {
        driver.findElement(By.xpath(String.format(catalogFilter, position))).click();
    }
}
