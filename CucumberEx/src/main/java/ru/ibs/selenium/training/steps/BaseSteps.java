package ru.ibs.selenium.training.steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import org.junit.Assert;
import ru.ibs.selenium.training.config.TestConfig;
import ru.ibs.selenium.training.managers.PageManager;

import java.util.Map;
import java.util.Properties;


public class BaseSteps {
    private static Properties properties = TestConfig.getInstance().getProperties();
    private static PageManager pageManager = PageManager.getPageManager();


    @Допустим("Авторизация на странице корпоративного портала со стандартным паролем")
    protected void baseAuth() {
        pageManager.getLoginPage().openPage(properties.getProperty("HOSTNAME"));
        pageManager.getLoginPage().inputLoginAndPassword(properties.getProperty("LOGIN"), properties.getProperty("PASSWORD"));
        pageManager.getLoginPage().clickSubmitBtn();
    }

    @И("Выбор меню создать командировку")
    protected void pickCreateTrip() {
        pageManager.getQuickLaunchBarPage().checkQuickLaunchTitle();
        pageManager.getQuickLaunchBarPage().clickTripsFromList();
        pageManager.getAllTripsPage().checkCreateTripLink();
        pageManager.getAllTripsPage().clickCreateTripLink();
        pageManager.geCreateTripPage().checkCreateTripPage();
    }

    @И("Оформение командировки с стандартными тестовыми данными:")
    protected void createDefaultTrip(Map<String, String> arg) {
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

    @И("Проверка ошибки на экране")
    protected void checkErrors() {
        pageManager.geCreateTripPage().checkValidationWarning();
        String trip_users = pageManager.geCreateTripPage().getTripUsersValidationText();
        String trip_users_foreign = pageManager.geCreateTripPage().getTripUsersForeignValidationText();
        Assert.assertEquals("Для поля 'Командированные сотрудники' не найдена предупреждение", "Список командируемых сотрудников не может быть пустым", trip_users);
        Assert.assertEquals("Для поля 'Внештатные сотрудники' не найдена предпреждение", "Список командируемых сотрудников не может быть пустым", trip_users_foreign);
    }
}
