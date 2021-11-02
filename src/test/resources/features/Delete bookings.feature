Feature: Delete bookings

  Scenario: An existing booking can be deleted
    Given Simon has an existing booking
    When he attempts to delete it
    Then he sees that the booking is no longer displayed

  @failing-test @ignore
  Scenario: An error is returned when trying to delete a booking that doesn't exist
    Given Simon does not have an existing booking
    When he tries to delete it
    Then he should see an error that booking doesn't exist

  @manual
  Scenario: Unable to delete a booking if not authenticated
    Given John has an existing booking
    But he is not authenticated
    When he tries to delete it
    Then he should see an error that says he is unable to delete the booking
