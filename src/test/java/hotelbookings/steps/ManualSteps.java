package hotelbookings.steps;

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
    public void browseToBookigPage() {
    }

    @Then("he should see his booking")
    public void isBookigVisible() {
    }
}

