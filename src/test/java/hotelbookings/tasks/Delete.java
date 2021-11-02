package hotelbookings.tasks;

import static hotelbookings.utilities.SerenityData.DataKeys.BASE_URL;
import static hotelbookings.utilities.SerenityData.DataKeys.BOOKING_ID;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import hotelbookings.utilities.SerenityData;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

public class Delete implements Performable {

    @Steps
    SerenityData testData;

    public static Performable theBooking() {
        return Instrumented.instanceOf(Delete.class).newInstance();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Long bookingId = testData.getData(BOOKING_ID);
        Target DELETE_BUTTON = Target.the("delete button")
            .located(By.cssSelector("[id='" + bookingId + "'] input[type='button']"));

        actor.attemptsTo(
            Open.url(testData.getData(BASE_URL))
                .then(WaitUntil.the(DELETE_BUTTON, isVisible()).forNoMoreThan(30).seconds())
                .then(Click.on(DELETE_BUTTON))
        );
    }
}
