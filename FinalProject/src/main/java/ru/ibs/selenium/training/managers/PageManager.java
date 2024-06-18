package ru.ibs.selenium.training.managers;

import ru.ibs.selenium.training.pages.*;

public class PageManager {
    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    private static CatalogPage catalogPage;
    private static MainPage mainPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link CatalogPage}
     *
     * @return CatalogPage
     */
    public CatalogPage getCatalogPage() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        return catalogPage;
    }

    /**
     * Ленивая инициализация {@link MainPage}
     *
     * @return InsurancePage
     */
    public MainPage geMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }
}
