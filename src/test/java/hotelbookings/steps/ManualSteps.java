package hotelbookings.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class ManualSteps {

    @Given("he is not authenticated")
    public void notAuthenticated() {
    }

    @Then("he should see an error that says he is unable to delete the booking")
    public void errorMessageUnableToDeleteBooking() {
    }

    @Then("^he should see the error message (.*)$")
    public void errorMessageDisplayed(String errorMessage) {

    }

    @Given("^(.*) fills in the booking form with the following details")
    public void fillInBookingFormWithTheFollowingDetails(String actor, DataTable datatable) {
    }

    @When("he saves his booking")
    public void heSavesHisBooking() {
    }

    @When("he browses to the booking page")
    public void browseToBookingPage() {
    }

    @Then("he should see his booking")
    public void isBookigVisible() {
    }

    @Given("Theo browses to the site")
    public void browseToTheSite() {
    }

    @When("he changes the browsers size")
    public void changesTheBrowsersSize() {
    }

    @Then("the page is still readable")
    public void thePageIsStillReadable() {
    }

    @Given("there are {int} bookings")
    public void countOfBookings(int arg0) {
    }

    @When("Derek views the bookings page")
    public void viewTheBookingsPage() {
    }

    @Then("he can see {int} bookings")
    public void numberOfBookings(int arg0) {
    }

    @And("the pagination counter displays {int} tabs")
    public void paginationCounterDisplaysTabs(int arg0) {
    }
}

