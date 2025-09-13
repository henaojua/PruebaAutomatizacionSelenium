package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "stepdefinitions",
                "runners"
        },
        stepNotifications = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        tags = ""
)

public class TestRunner {

        @BeforeClass
        public static void setup() {
                WebDriverManager.chromedriver().setup();
        }
}

