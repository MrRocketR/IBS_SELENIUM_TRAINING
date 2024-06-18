package ru.ibs.selenium.training.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.ibs.selenium.training.managers.DriverManager;

import static ru.ibs.selenium.training.managers.DriverManager.closeDriver;
import static ru.ibs.selenium.training.managers.DriverManager.getDriver;

public class InitHook {

    @Before
    public void beforeExample() {
        getDriver();
    }

    @After
    public void afterExample() {
        closeDriver();
    }
}
