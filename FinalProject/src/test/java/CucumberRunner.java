import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        glue = {"ru.ibs.selenium.training.steps"},
        features = {"src/test/resources/"},
        tags = {"@productTest"}
)
public class CucumberRunner {
}