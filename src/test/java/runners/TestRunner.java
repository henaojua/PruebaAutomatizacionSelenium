package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {
                "pretty",
                "html:build/cucumber-reports/cucumber.html",
                "json:build/cucumber-reports/cucumber.json"
        },
        tags = ""
)

public class TestRunner {


}

