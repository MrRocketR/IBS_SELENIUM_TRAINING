package ru.ibs.selenium.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CatalogPage extends BasePage {

    String cardCategory = "//p[contains(@class, 'CardCategory') and text()='%s']";

    @FindBy(xpath = "(//div[contains(@class,'RangeSelector_inputs')]/input[@name = 'min'])[1]")
    WebElement priceMinField;

    @FindBy(xpath = "//span[contains(@class, 'FilterTags_title') and text()='Цена:']")
    WebElement filterTagPrice;

    String filterFirm = "//label[text()='%s']";

    String filterTagItem = "//div[contains(@class,'FilterTags_item')]/span[text() = '%s']";

    @FindBy(xpath = "//div[text()='Товаров на странице: ']/span")
    WebElement productsOnPage;

    @FindBy(xpath = "//div[contains(@class,'CardText_wrap')]/a/div[string-length(text()) > 0]")
    WebElement cardsWithProductsIs;

    @FindBy(xpath = "(//div[contains(@class,'CardText_wrap')])[1]//div")
    WebElement firstProduct;

    @FindBy(xpath = "//div[contains(@class,'inputWrap SearchInput_input')]//input[@id='searchInput']")
    WebElement searchProduct;

    @FindBy(xpath = "//span[contains(@class, 'Search_popularTitle_') and text() = 'Популярные товары']")
    WebElement popularTitle;

    String popularProduct = "//div[contains(@class,'Search_popularCards')]//div[contains(@class, 'CardText_title')]";

    String pageCategoryTitle = "//h1[contains(@class, ListingPageTitle) and text() = '%s']";

    @FindBy(xpath = "//div[contains(@class, 'ListingFilters_wrap')]")
    WebElement listingFilters;

    public CatalogPage() {
        PageFactory.initElements(driver, this);
    }

    public void waitForCardAndPickProduct(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(cardCategory, product))));
        driver.findElement(By.xpath(String.format(cardCategory, product))).click();
    }

    public void waitForProductsPageShow(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(pageCategoryTitle, product))));
      //  wait.until(ExpectedConditions.visibilityOf(By.xpath("//div[contains(@class, 'ListingFilters_wrap')]")));
        wait.until(ExpectedConditions.visibilityOf(listingFilters));
    }

    public void filterMinimumPriceAndCheck(String price) {
        priceMinField.sendKeys(price);
        wait.until(ExpectedConditions.visibilityOf(filterTagPrice));
    }

    public void filterByFirmAndCheck(String firm) {
        driver.findElement(By.xpath(String.format(filterFirm, firm))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(filterTagItem, firm))));
    }

    public void waitUntilProductsOnPageShow() {
        wait.until(ExpectedConditions.visibilityOf(productsOnPage));
    }

    public String getProductsOnPageText() {
        return productsOnPage.getText();
    }

    public void checkIfProductsOnPage() {
        wait.until(ExpectedConditions.visibilityOf(cardsWithProductsIs));
    }

    public String getFirstProductName() {
        return firstProduct.getText();
    }

    public void searchProductAnCheckScreen(String product) {
        searchProduct.sendKeys(product);
        wait.until(ExpectedConditions.visibilityOf(popularTitle));
    }

    public List<WebElement> getPopularProductName() {
        return driver.findElements(By.xpath(popularProduct));
    }
}
