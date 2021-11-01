package hotelbookings.steps;

import static contentmanager.SerenityData.DataKeys.BASE_URL;
import static contentmanager.SerenityData.DataKeys.THIS_ONE;

import contentmanager.SerenityData;
import hotelbookings.exceptions.MissingDataException;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;

public class Hooks {
      @Steps
      private SerenityData testData;

      private EnvironmentVariables environmentVariables;

      @Before
      public void setTheStage() {
            OnStage.setTheStage(new OnlineCast());
            testData.setData(THIS_ONE, "that");
            testData.setData(BASE_URL, environmentVariables.optionalProperty("webdriver.base.url")
                .orElseThrow(() -> new MissingDataException("Missing environment property called webdriver.base.url")));
      }

}
