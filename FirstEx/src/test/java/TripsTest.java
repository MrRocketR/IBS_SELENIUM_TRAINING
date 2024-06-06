import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TripsTest {

    private WebDriver driver;
    private Wait<WebDriver> wait;
    private static String DRIVER_KEY = "webdriver.chrome.driver";
    private static String LOGIN = "Taraskina Valeriya";
    private static String PASSWORD = "testing";


    @BeforeEach
    public void init() {
        initDriver("WINDOWS");
    }

    @Test
    public void tripTest() {
        //Шаг 1: Авторизируемся на странице
        driver.get("https://training.appline.ru/user/login");
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(LOGIN);
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text() = 'Панель быстрого запуска']"))));

        //Шаг 2: Выбираем создать командировку
        WebElement element = driver.findElement(By.xpath(
                "//ul[contains(@class,'multilevel main-menu')]/li/a/span[text()='Расходы']"));
        element.click();
        wait.until(ExpectedConditions.visibilityOf(element.findElement(By.xpath("//ul[contains(@class,'ropdown-menu menu_level_1')]//a/span[text()='Командировки']/.."))));
        driver.findElement(By.xpath("//ul[contains(@class,'ropdown-menu menu_level_1')]//a/span[text()='Командировки']/..")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Создать командировку']"))));
        driver.findElement(By.xpath("//a[@title='Создать командировку']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='Создать командировку']"))));
        //Шаг 3: Создать командировку

        driver.findElement(By.xpath("//select/option[text()='Отдел внутренней разработки']")).click();
        driver.findElement(By.xpath("//input[@data-name = 'field__company']")).sendKeys("ОАО РОГА И КОПЫТА");
        driver.findElement(By.xpath("//div/a[@id = 'company-selector-show']")).click();
        driver.findElement(By.xpath("//select[@data-name = 'field__transport']/option[text()='Метро']")).click();
        driver.findElement(By.xpath("//select[contains(@id, 'crm_business_trip_class')]/option[text()='Маркетинговая']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and contains(@id, 'business_trip_tasks_1')]")).click();
        driver.findElement(By.xpath(" //input[contains(@id, 'business_trip_arrivalCity')]")).sendKeys("Россия, Магадан");

        driver.findElement(By.xpath("//input[@placeholder='Укажите дату' and contains(@id, 'business_trip_departureDatePlan')]")).click();
        driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='25']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Укажите дату' and contains(@id, 'business_trip_returnDatePlan')]")).click();
        driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='26']")).click();
        //Шаг 4: Нажать 'Сохранить и закрыть'
        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class= 'validation-failed']")));
        String trip_users = driver.findElement(By.xpath("(//span[@class= 'validation-failed'])[1]")).getText();
        String trip_users_foreign = driver.findElement(By.xpath("(//span[@class= 'validation-failed'])[2]")).getText();
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", trip_users, "Для поля 'Командированные сотрудники' не найдена предпреждение");
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", trip_users_foreign, "Для поля 'Внештатные сотрудники' не найдена предпреждение");
    }

    @AfterEach
    public void close() {
        driver.close();
    }

    public void initDriver(String os) {
        switch (os) {
            case "WINDOWS":
                System.setProperty(DRIVER_KEY, "src/test/resources/chromedriver125_windows.exe");
                break;
            case "MAC":
                System.setProperty(DRIVER_KEY, "src/test/resources/chromedriver125_mac");
                break;
            case "LINUX":
                System.setProperty(DRIVER_KEY, "src/test/resources/chromedriver125_linux");
                break;
            default:
                throw new RuntimeException("Не выбрана правильня операционная система под инициализацию драйвера");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 60, 10);
    }
}