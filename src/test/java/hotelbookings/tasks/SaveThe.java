package hotelbookings.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SaveThe implements Performable {
    public static final Target SAVE = Target.the("campaign name field").located(By.cssSelector("#form input[type='button']"));

    public static Performable booking() {
        return Instrumented.instanceOf(SaveThe.class).newInstance();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SAVE));
    }

}
