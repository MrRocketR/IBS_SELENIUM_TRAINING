package ru.ibs.selenium.training.managers;

import ru.ibs.selenium.training.pages.AllTripsPage;
import ru.ibs.selenium.training.pages.CreateTripPage;
import ru.ibs.selenium.training.pages.LoginPage;
import ru.ibs.selenium.training.pages.QuickLaunchBarPage;

public class PageManager {
    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    private static AllTripsPage allTripsPage;
    private static CreateTripPage createTripPage;
    private static LoginPage loginPage;
    private static QuickLaunchBarPage quickLaunchBarPage;

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
     * Ленивая инициализация {@link AllTripsPage}
     *
     * @return AllTripsPage
     */
    public AllTripsPage getAllTripsPage() {
        if (allTripsPage == null) {
            allTripsPage = new AllTripsPage();
        }
        return allTripsPage;
    }

    /**
     * Ленивая инициализация {@link CreateTripPage}
     *
     * @return InsurancePage
     */
    public CreateTripPage geCreateTripPage() {
        if (createTripPage == null) {
            createTripPage = new CreateTripPage();
        }
        return createTripPage;
    }

    /**
     * Ленивая инициализация {@link LoginPage}
     *
     * @return LoginPage
     */
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    /**
     * Ленивая инициализация {@link QuickLaunchBarPage}
     *
     * @return QuickLaunchBarPage
     */
    public QuickLaunchBarPage getQuickLaunchBarPage() {
        if (quickLaunchBarPage == null) {
            quickLaunchBarPage = new QuickLaunchBarPage();
        }
        return quickLaunchBarPage;
    }
}
