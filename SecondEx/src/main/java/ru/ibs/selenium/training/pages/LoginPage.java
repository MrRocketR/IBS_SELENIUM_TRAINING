package ru.ibs.selenium.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@name='_username']")
    WebElement usernameInputForm;
    @FindBy(xpath = "//input[@name='_password']")
    WebElement usernamePasswordForm;
    @FindBy(xpath = "//button[text()='Войти']")
    WebElement submitBtn;



    public void openPage(String url) {
        driver.get(url);
    }

    public void doLogin(String login, String password) {
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
    }

}
