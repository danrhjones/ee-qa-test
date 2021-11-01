Feature: Create a new booking.

  Scenario Outline: a user is able to create a booking with or without a deposit.
    Given Alvin completes the booking form with his information
    And he <scenario> pay a deposit
    When he saves the booking
    Then he should see his booking is displayed

    Examples:
      | scenario |
      | does      |
      | does not  |
