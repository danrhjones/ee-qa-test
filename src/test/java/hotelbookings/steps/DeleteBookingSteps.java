package hotelbookings.steps;

import static hotelbookings.utilities.SerenityData.DataKeys.BOOKING;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.assertj.core.api.Assertions.*;


import hotelbookings.models.Booking;
import hotelbookings.questions.TheBooking;
import hotelbookings.tasks.Delete;
import hotelbookings.tasks.UseApi;
import hotelbookings.utilities.SerenityData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.EventualConsequence;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Steps;

public class DeleteBookingSteps {

    @Steps
    SerenityData testData;

    @When("he attempts to delete it")
    public void deleteBooking() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Delete.theBooking()
        );
    }

    @Then("he sees that the booking is no longer displayed")
    public void bookingIsNotDisplayed() {
        Booking thisBooking = testData.getData(BOOKING);
        OnStage.theActorInTheSpotlight().should(EventualConsequence.eventually(
            seeThat(
                TheBooking.contains(), not(containsString(thisBooking.getFirstname()))
            )).waitingForNoLongerThan(10).seconds()
        );
    }

    @When("he tries to delete it")
    public void deleteBookingWithApi() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            UseApi.toDeleteBooking()
        );
    }

    @Then("he should see an error that booking doesn't exist")
    public void returnErrorThatBookingDoesntExist() {
        int actualStatusCode = SerenityRest.lastResponse().getStatusCode();

        assertThat(actualStatusCode).as(
                "This should be 401, but instead it is %d", actualStatusCode)
            .isEqualTo(401);
    }
}
