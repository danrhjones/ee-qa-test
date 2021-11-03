Feature: Retrieve existing bookings.

  @Manual
  Scenario: Existing bookings are displayed on the home page
    Given Jon has an existing booking
    When he browses to the booking page
    Then he should see his booking

