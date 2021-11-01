package hotelbookings.steps;

import static hotelbookings.utilities.SerenityData.DataKeys.BOOKING;

import hotelbookings.models.Booking;
import hotelbookings.questions.TheBooking;
import hotelbookings.tasks.BrowseTo;
import hotelbookings.tasks.FillInTheBooking;
import hotelbookings.tasks.SaveThe;
import hotelbookings.tasks.SetDepositDropDown;
import hotelbookings.utilities.SerenityData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.EventualConsequence;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;


public class first_steps {
    @Steps
    Booking booking;
    @Steps
    SerenityData testData;

    @Given("^(.*) completes the booking form with his information$")
    public void alvinCompletesTheBookingFormWithHisInformation(String actor) {
        OnStage.theActorCalled(actor)
            .attemptsTo(BrowseTo.theHomePage());
        OnStage.theActorInTheSpotlight().attemptsTo(FillInTheBooking.withTheirInformation(booking.booking()));
    }

    @And("^he (does|does not) pay a deposit$")
    public void heScenarioPayADeposit(String payDeposit) {
        String depositState = payDeposit.equals("does") ? "true" : "false";
        OnStage.theActorInTheSpotlight().attemptsTo(SetDepositDropDown.to(depositState));

        Booking booking = testData.getData(BOOKING);
        booking.setDepositpaid(Boolean.valueOf(depositState));
        testData.setData(BOOKING, booking);
    }

    @When("he saves the booking")
    public void heSavesTheBooking() {
        OnStage.theActorInTheSpotlight().attemptsTo(SaveThe.booking());
    }

    @Then("he should see his booking is displayed")
    public void heShouldSeeTheBookingIsDisplayed() {
        Booking thisBooking = testData.getData(BOOKING);
        OnStage.theActorInTheSpotlight().should(EventualConsequence.eventually(
            seeThat("which is first",
                TheBooking.contains(), containsString(thisBooking.getFirstname())
            )).waitingForNoLongerThan(10).seconds()
        );
    }
}
