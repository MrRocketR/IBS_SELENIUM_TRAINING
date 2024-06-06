import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.ibs.selenium.training.pages.AllTripsPage;
import ru.ibs.selenium.training.pages.CreateTripPage;
import ru.ibs.selenium.training.pages.LoginPage;
import ru.ibs.selenium.training.pages.QuickLaunchBarPage;

import java.util.Properties;

import static ru.ibs.selenium.training.config.TestConfig.getInstance;

public class CreateTripTest extends BaseSteps{

    @Test
    @Story("Простой тест на создание командировки")
    @Description("Авторизация по паролю и попытка создать командировку без заполнения сотрудников")
    @Feature("Создание командировки")
    public void tripTest() {
        baseAuth();
        pickCreateTrip();
        createDefaultTrip();
        checkErrors();
    }
}
