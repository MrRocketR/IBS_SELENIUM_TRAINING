import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.selenium.training.config.TestConfig;
import ru.ibs.selenium.training.managers.DriverManager;
import ru.ibs.selenium.training.managers.PageManager;

import java.sql.Driver;
import java.util.Properties;

public class Pure {

    private static Properties properties = TestConfig.getInstance().getProperties();
    private static PageManager pageManager = PageManager.getPageManager();

    @Test
    public void t1() {
        WebDriver driver = DriverManager.getDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver, 60, 10);
        driver.get("https://www.regard.ru/");
        driver.findElement(By.xpath("//button/span[text()='Каталог']")).click();
        driver.findElement(By.xpath("//div[text()='Комплектующие для ПК']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'CardCategory') and text()='Видеокарты']")));
        driver.findElement(By.xpath("//p[contains(@class, 'CardCategory') and text()='Видеокарты']")).click();
        driver.findElement(By.xpath("(//div[contains(@class,'RangeSelector_inputs')]/input[@name = 'min'])[1]")).sendKeys("20000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'FilterTags_title') and text()='Цена:']")));
        driver.findElement(By.xpath("//label[text()='Gigabyte']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'FilterTags_item')]/span[text() = 'Gigabyte']")));

        By productsOnPage = By.xpath("//div[text()='Товаров на странице: ']/span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsOnPage));
        String products = driver.findElement(productsOnPage).getText();
        Assert.assertEquals("Неверное количество товаров на странице", "по 24", products);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'CardText_wrap')]/a/div[string-length(text()) > 0] ")));
        String firstProduct = driver.findElement(By.xpath("(//div[contains(@class,'CardText_wrap')])[1]//div")).getText();
        driver.findElement(By.xpath("//div[contains(@class,'inputWrap SearchInput_input')]//input[@id='searchInput']")).sendKeys(firstProduct);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'Search_popularTitle_') and text() = 'Популярные товары']")));

        By popularProduct = By.xpath("//div[contains(@class,'Search_popularCards')]//div[contains(@class, 'CardText_title')]");

        int searchedSize = driver.findElements(popularProduct).size();
        Assert.assertEquals("Найдено больше 1 элемента", 1, searchedSize);
        Assert.assertTrue("Неверное наименование товара", firstProduct.contains(driver.findElement(popularProduct).getText()));

        driver.close();
    }

    @Test
    public void t2() {
        WebDriver driver = DriverManager.getDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver, 60, 10);
       //MainPage
        driver.get("https://www.regard.ru/");
        driver.findElement(By.xpath("//button/span[text()='Каталог']")).click();
        driver.findElement(By.xpath("//div[text()='Периферия']")).click();
        //CatalogPage
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'CardCategory') and text()='Клавиатуры']")));
        driver.findElement(By.xpath("//p[contains(@class, 'CardCategory') and text()='Клавиатуры']")).click();
        driver.findElement(By.xpath("(//div[contains(@class,'RangeSelector_inputs')]/input[@name = 'min'])[1]")).sendKeys("2000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'FilterTags_title') and text()='Цена:']")));
        driver.findElement(By.xpath("//label[text()='A4Tech']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'FilterTags_item')]/span[text() = 'A4Tech']")));

        By productsOnPage = By.xpath("//div[text()='Товаров на странице: ']/span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsOnPage));
        String products = driver.findElement(productsOnPage).getText();
        Assert.assertEquals("Неверное количество товаров на странице", "по 24", products);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'CardText_wrap')]/a/div[string-length(text()) > 0] ")));
        String firstProduct = driver.findElement(By.xpath("(//div[contains(@class,'CardText_wrap')])[1]//div")).getText();
        driver.findElement(By.xpath("//div[contains(@class,'inputWrap SearchInput_input')]//input[@id='searchInput']")).sendKeys(firstProduct);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'Search_popularTitle_') and text() = 'Популярные товары']")));

        By popularProduct = By.xpath("//div[contains(@class,'Search_popularCards')]//div[contains(@class, 'CardText_title')]");

        int searchedSize = driver.findElements(popularProduct).size();
        Assert.assertEquals("Найдено больше 1 элемента", 1, searchedSize);
        Assert.assertTrue("Неверное наименование товара", firstProduct.contains(driver.findElement(popularProduct).getText()));

        driver.close();
    }
}
