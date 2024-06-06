import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.ibs.selenium.training.pages.AllTripsPage;
import ru.ibs.selenium.training.pages.CreateTripPage;
import ru.ibs.selenium.training.pages.LoginPage;
import ru.ibs.selenium.training.pages.QuickLaunchBarPage;

import java.util.Properties;

import static ru.ibs.selenium.training.config.TestConfig.getInstance;

@ExtendWith(DriverExtension.class)
public class TripTestsSecond {

    private static Properties properties = getInstance().getProperties();
    private LoginPage loginPage = new LoginPage();
    private QuickLaunchBarPage quickLaunchBarPage = new QuickLaunchBarPage();
    private AllTripsPage allTripsPage = new AllTripsPage();
    private CreateTripPage createTripPage = new CreateTripPage();


    @Test
    public void tripTest() {
        //Шаг 1: Авторизируемся на странице
        loginPage.openPage(properties.getProperty("HOSTNAME"));
        loginPage.inputLoginAndPassword(properties.getProperty("LOGIN"), properties.getProperty("PASSWORD"));
        loginPage.clickSubmitBtn();
        //Шаг 2: Выбираем создать командировку
        quickLaunchBarPage.checkQuickLaunchTitle();
        quickLaunchBarPage.clickTripsFromList();
        allTripsPage.checkCreateTripLink();
        allTripsPage.clickCreateTripLink();
        createTripPage.checkCreateTripPage();
        //Шаг 3: Создать командировку
        createTripPage.selectDepartment("Отдел внутренней разработки");
        createTripPage.inputCompanyName("ОАО РОГА И КОПЫТА");
        createTripPage.clickPickOrganizationFromList();
        createTripPage.selectTripTransport("Метро");
        createTripPage.selectTripClass("Маркетинговая");
        createTripPage.selectPickTicketCheckBox();
        createTripPage.inputArrivalCity("Россия, Магадан");
        createTripPage.pickDepartureDate("26");
        createTripPage.pickReturnDate("27");
        createTripPage.clickSaveAndReturnBtn();
        //Шаг 4: Проверить ошибку на экране
        createTripPage.checkValidationWarning();
        String trip_users = createTripPage.getTripUsersValidationText();
        String trip_users_foreign = createTripPage.getTripUsersForeignValidationText();
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", trip_users, "Для поля 'Командированные сотрудники' не найдена предпреждение");
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", trip_users_foreign, "Для поля 'Внештатные сотрудники' не найдена предпреждение");
    }
}
