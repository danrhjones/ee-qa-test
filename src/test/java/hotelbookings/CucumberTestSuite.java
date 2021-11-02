package hotelbookings;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = {"pretty"},
    tags = "not @wip",
    features = "src/test/resources/features"
)
public class CucumberTestSuite {}
