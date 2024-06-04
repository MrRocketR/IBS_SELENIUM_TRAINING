package ru.ibs.selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@name='_username']")
    WebElement usernameInputForm;
    @FindBy(xpath = "//input[@name='_password']")
    WebElement usernamePasswordForm;
    @FindBy(xpath = "//button[text()='Войти']")
    WebElement submitBtn;


}
