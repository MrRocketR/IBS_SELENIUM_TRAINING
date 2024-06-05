package ru.ibs.selenium.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateTripPage extends BasePage {

    @FindBy(xpath = "//h1[text()='Создать командировку']")
    WebElement createTripTitle;
    private String departmentSelector = "//select/option[text()='%s']";
    @FindBy(xpath = "//input[@data-name = 'field__company']")
    WebElement companyNameField;
    @FindBy(xpath = "//div/a[@id = 'company-selector-show']")
    WebElement companySelector;
    private String subwayTransportOptionSelector = "//select[@data-name = 'field__transport']/option[text()='%s']";

    private String tripClassPattern = "//select[contains(@id, 'crm_business_trip_class')]/option[text()='%s']";
    @FindBy(xpath = "//input[@type='checkbox' and contains(@id, 'business_trip_tasks_1')]")
    WebElement buyTicketCheckBox;

    @FindBy(xpath = "//input[contains(@id, 'business_trip_arrivalCity')]")
    WebElement arrivalCityForm;

    @FindBy(xpath = "//input[@placeholder='Укажите дату' and contains(@id, 'business_trip_departureDatePlan')]")
    WebElement departureDatePlan;

    @FindBy(xpath = "//input[@placeholder='Укажите дату' and contains(@id, 'business_trip_returnDatePlan')]")
    WebElement returnDatePlan;

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    WebElement saveAndReturnBtn;

    @FindBy(xpath = "//span[@class= 'validation-failed']")
    WebElement validationFailedWarning;

    private String validationFailedTextPattern = "(//span[@class= 'validation-failed'])[%s]";

    public void checkCreateTripPage() {
        wait.until(ExpectedConditions.visibilityOf(createTripTitle));
    }

    public void selectDepartment(String department) {
        driver.findElement(By.xpath(String.format(departmentSelector, department))).click();
    }

    public void inputCompanyName(String name) {
        companyNameField.sendKeys(name);
    }

    public void clickPickOrganizationFromList() {
        companySelector.click();
    }

    public void selectTripTransport(String transport) {
        driver.findElement(By.xpath(String.format(subwayTransportOptionSelector, transport))).click();
    }

    public void selectTripClass(String tripClass) {
        driver.findElement(By.xpath(String.format(tripClassPattern, tripClass))).click();
    }

    public void selectPickTicketCheckBox() {
        buyTicketCheckBox.click();
    }

    public void inputArrivalCity(String name) {
        arrivalCityForm.sendKeys(name);
    }

    public void pickDepartureDate(String date) {
        departureDatePlan.click();
        driver.findElement(By.xpath(String.format("//table/tbody/tr/td/a[text()='%s']", date))).click();
    }

    public void pickReturnDate(String date) {
        returnDatePlan.click();
        driver.findElement(By.xpath(String.format("//table/tbody/tr/td/a[text()='%s']", date))).click();
    }

    public void clickSaveAndReturnBtn() {
        saveAndReturnBtn.click();
    }

    public void checkValidationWarning() {
        wait.until(ExpectedConditions.visibilityOf(validationFailedWarning));
    }

    public String getTripUsersValidationText() {
        return driver.findElement(By.xpath(String.format(validationFailedTextPattern, "1"))).getText();
    }

    public String getTripUsersForeignValidationText() {
        return driver.findElement(By.xpath(String.format(validationFailedTextPattern, "2"))).getText();
    }
}
