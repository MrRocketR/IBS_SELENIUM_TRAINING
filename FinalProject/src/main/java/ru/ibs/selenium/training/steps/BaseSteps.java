package ru.ibs.selenium.training.steps;

import io.cucumber.java.ru.Допустим;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ru.ibs.selenium.training.config.TestConfig;
import ru.ibs.selenium.training.managers.PageManager;

import java.util.List;
import java.util.Properties;

public class BaseSteps {

    private static Properties properties = TestConfig.getInstance().getProperties();
    private static PageManager pageManager = PageManager.getPageManager();

    @Допустим("Открытие основной страницы магазина и выбор каталога")
    public void openCatalog() {
        pageManager.geMainPage().openPage(properties.getProperty("HOSTNAME"));
        pageManager.geMainPage().openCatalog();
    }

    @Допустим("Выбираем категорию: {string} и тип товара: {string}")
    public void chooseCategoryAndProduct(String category, String cardCategory) {
        pageManager.geMainPage().pickPosition(category);
        pageManager.getCatalogPage().waitForCardAndPickProduct(cardCategory);
        pageManager.getCatalogPage().waitForProductsPageShow(cardCategory);
    }

    @Допустим("Фильтруем по минимальной цене - {string} и производителю - {string}")
    public void filterByPriceAndFirm(String minPrice, String firm) {
        pageManager.getCatalogPage().filterMinimumPriceAndCheck(minPrice);
        pageManager.getCatalogPage().filterByFirmAndCheck(firm);
    }

    @Допустим("Проверяем, что на странице отображается 24 позиции")
    public void if24ElementsOnPageShow() {
        pageManager.getCatalogPage().waitUntilProductsOnPageShow();
        String elementsCount = pageManager.getCatalogPage().getProductsOnPageText();
        Assert.assertEquals("Неверное количество товаров на странице", "по 24", elementsCount);
    }

    @Допустим("Получить первый товар из списка и найти его по поиску")
    public void getFirstProductFromCardAndSearch() {
        pageManager.getCatalogPage().checkIfProductsOnPage();
        String firstProduct = pageManager.getCatalogPage().getFirstProductName();
        pageManager.getCatalogPage().searchProductAnCheckScreen(firstProduct);
        List<WebElement> popularProduct = pageManager.getCatalogPage().getPopularProductName();
        int searchedSize = popularProduct.size();
        Assert.assertEquals("Найдено больше 1 элемента", 1, searchedSize);
        String actualProduct = popularProduct.get(0).getText();
        Assert.assertTrue("Неверное наименование товара", firstProduct.contains(actualProduct));
    }

}
