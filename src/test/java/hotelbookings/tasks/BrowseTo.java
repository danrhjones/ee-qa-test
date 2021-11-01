package hotelbookings.tasks;

import static hotelbookings.utilities.SerenityData.DataKeys.BASE_URL;

import hotelbookings.utilities.SerenityData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class BrowseTo implements Performable {

    private static String url = "";

    private static SerenityData testData = new SerenityData();

    public static Performable theHomePage() {
        url = testData.getData(BASE_URL);
        return Instrumented.instanceOf(BrowseTo.class).newInstance();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.url(url)
        );
    }
}
