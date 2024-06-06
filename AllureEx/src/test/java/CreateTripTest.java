import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class CreateTripTest extends BaseSteps{

    @Test
    @Story("Простой тест на создание командировки")
    @Description("Авторизация по паролю и попытка создать командировку без заполнения сотрудников")
    @Feature("Создание командировки")
    public void createTripTest() {
        baseAuth();
        pickCreateTrip();
        createDefaultTrip();
        checkErrors();
    }
}
