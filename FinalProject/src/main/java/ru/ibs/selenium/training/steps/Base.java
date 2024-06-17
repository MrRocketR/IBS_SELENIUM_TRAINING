package ru.ibs.selenium.training.steps;

import io.cucumber.java.ru.Допустим;
import org.junit.Assert;
import ru.ibs.selenium.training.config.TestConfig;
import ru.ibs.selenium.training.managers.PageManager;

import java.util.Map;
import java.util.Properties;

public class Base {

    private static Properties properties = TestConfig.getInstance().getProperties();
    private static PageManager pageManager = PageManager.getPageManager();



    @Допустим("Авторизация на странице корпоративного портала со стандартным паролем")
    public void авторизация_на_странице_корпоративного_портала_со_стандартным_паролем() {
        pageManager.getLoginPage().openPage(properties.getProperty("HOSTNAME"));
        pageManager.getLoginPage().inputLoginAndPassword(properties.getProperty("LOGIN"), properties.getProperty("PASSWORD"));
        pageManager.getLoginPage().clickSubmitBtn();
    }


    @Допустим("Выбор меню создать командировку")
    public void выбор_меню_создать_командировку() {
        pageManager.getQuickLaunchBarPage().checkQuickLaunchTitle();
        pageManager.getQuickLaunchBarPage().clickTripsFromList();
        pageManager.getAllTripsPage().checkCreateTripLink();
        pageManager.getAllTripsPage().clickCreateTripLink();
        pageManager.geCreateTripPage().checkCreateTripPage();
    }

    @Допустим("Оформение командировки с стандартными тестовыми данными:")
    public void оформение_командировки_с_стандартными_тестовыми_данными(Map<String, String> arg) {
        pageManager.geCreateTripPage().selectDepartment(arg.get("Department"));
        pageManager.geCreateTripPage().inputCompanyName(arg.get("CompanyName"));
        pageManager.geCreateTripPage().clickPickOrganizationFromList();
        pageManager.geCreateTripPage().selectTripTransport(arg.get("TripTransport"));
        pageManager.geCreateTripPage().selectTripClass(arg.get("TripClass"));
        pageManager.geCreateTripPage().selectPickTicketCheckBox();
        pageManager.geCreateTripPage().inputArrivalCity(arg.get("ArrivalCity"));
        pageManager.geCreateTripPage().pickDepartureDate(arg.get("DepartureDate"));
        pageManager.geCreateTripPage().pickReturnDate(arg.get("ReturnDate"));
        pageManager.geCreateTripPage().clickSaveAndReturnBtn();
    }

    @Допустим("Проверка ошибки на экране")
    public void проверка_ошибки_на_экране() {
        pageManager.geCreateTripPage().checkValidationWarning();
        String trip_users = pageManager.geCreateTripPage().getTripUsersValidationText();
        String trip_users_foreign = pageManager.geCreateTripPage().getTripUsersForeignValidationText();
        Assert.assertEquals("Для поля 'Командированные сотрудники' не найдена предупреждение", "Список командируемых сотрудников не может быть пустым", trip_users);
        Assert.assertEquals("Для поля 'Внештатные сотрудники' не найдена предпреждение", "Список командируемых сотрудников не может быть пустым", trip_users_foreign);
    }
}
