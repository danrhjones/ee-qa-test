package hotelbookings.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

public class SetDepositDropDown implements Performable {
    public static final Target DEPOSIT = Target.the("campaign name field").located(By.id("depositpaid"));
    private static String state;


    public static Performable to(String depositState) {
        state = depositState;
        return Instrumented.instanceOf(SetDepositDropDown.class).withProperties(depositState);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectFromOptions.byVisibleText(state).from(DEPOSIT));
    }

}
