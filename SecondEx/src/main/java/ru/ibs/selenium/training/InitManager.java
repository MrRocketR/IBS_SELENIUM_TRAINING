package ru.ibs.selenium.training;

import ru.ibs.selenium.training.pages.LoginPage;

public class InitManager {

    private static InitManager INSTANCE;

    public static InitManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InitManager();
        }
        return INSTANCE;
    }

    private LoginPage loginPage;

    public void initPages() {
         loginPage = new LoginPage();

    }


}
