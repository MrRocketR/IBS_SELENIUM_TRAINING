package ru.ibs.selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='_username']")
    WebElement usernameInputForm;
    @FindBy(xpath = "//input[@name='_password']")
    WebElement usernamePasswordForm;
    @FindBy(xpath = "//button[text()='Войти']")
    WebElement submitBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void inputLoginAndPassword(String login, String password) {
        usernameInputForm.sendKeys(login);
        usernamePasswordForm.sendKeys(password);
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

}
