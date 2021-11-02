package hotelbookings.steps;

import static hotelbookings.utilities.SerenityData.DataKeys.BASE_URL;
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
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.EventualConsequence;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static hotelbookings.utilities.SerenityData.DataKeys.BOOKING_ID;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;


public class BookingSteps {
    @Steps
    Booking booking;
    @Steps
    SerenityData testData;

    @Given("^(.*) completes the booking form with his information$")
    public void fillInBookingForm(String actor) {
        OnStage.theActorCalled(actor)
            .attemptsTo(BrowseTo.theHomePage());
        OnStage.theActorInTheSpotlight().attemptsTo(FillInTheBooking.withTheirInformation(booking.booking()));
    }

    @And("^he (does|does not) pay a deposit$")
    public void setPayDeposit(String payDeposit) {
        String depositState = payDeposit.equals("does") ? "true" : "false";
        OnStage.theActorInTheSpotlight().attemptsTo(SetDepositDropDown.to(depositState));

        Booking booking = testData.getData(BOOKING);
        booking.setDepositpaid(Boolean.valueOf(depositState));
        testData.setData(BOOKING, booking);
    }

    @When("he saves the booking")
    public void saveBooking() {
        OnStage.theActorInTheSpotlight().attemptsTo(SaveThe.booking());
    }

    @Then("he should see his booking is displayed")
    public void isBookingdisplayed() {
        Booking thisBooking = testData.getData(BOOKING);
        OnStage.theActorInTheSpotlight().should(EventualConsequence.eventually(
            seeThat(
                TheBooking.contains(), containsString(thisBooking.getFirstname())
            )).waitingForNoLongerThan(10).seconds()
        );
    }

    @Given("^(.*) has an existing booking$")
    public void createBooking(String actor) {
        OnStage.theActorCalled(actor)
            .whoCan(CallAnApi.at(testData.getData(BASE_URL)))
            .attemptsTo(
                Post.to("booking")
                    .with(request -> request.log().all().header("Content-Type", "application/json")
                        .body(booking.booking())
                    )
            );

        long bookingId = SerenityRest.lastResponse().jsonPath().getLong("bookingid");
        testData.setData(BOOKING_ID, bookingId);
    }

    @Given("^(.*) does not have an existing booking$")
    public void noExistingBooking(String actor) {
        OnStage.theActorCalled(actor).whoCan(CallAnApi.at(testData.getData(BASE_URL)));
    }
}
