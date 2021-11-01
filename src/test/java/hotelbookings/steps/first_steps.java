package hotelbookings.steps;

import hotelbookings.tasks.BrowseTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class first_steps {

    @Given("I go to the page")
    public void iGoToThePage() {
        OnStage.aNewActor()
            .attemptsTo(BrowseTo.theHomePage());
    }


    @When("^I do something$")
    public void iDoSomething() {
        System.out.println("will this work?");
    }

    @Then("^somethign happens$")
    public void somethignHappens() {
        System.out.println("will this work?");
    }
}
