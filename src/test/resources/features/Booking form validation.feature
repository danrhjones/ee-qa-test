Feature: Validation when creating a booking.

  @Manual
  Scenario Outline: Error message is display if a customer enters invalid details
    Given Ralph fills in the booking form with the following details
      | firstname    | lastname   | totalprice | depositpaid | check in   | check out   |
      | <First Name> | <Lastname> | <Price>    | <Deposit>   | <Check In> | <Check Out> |
    When he saves his booking
    Then he should see the error message <Error Message>

    Examples: of field inputs
      | First Name | Lastname | Price | Deposit | Check In | Check Out | Error Message                 |
      |            |          |       | false   |          |           | Null values provided          |
      | 123456     | 123123   | ABC   | true    | 123      | 123       | Enter valid characters        |
      | £$%^&*     | £$%^&*   | 10    | true    | today+1  | today+2   | Enter valid characters        |
      | Test       | Test     | -20   | false   | today+1  | today+2   | Price must be not be negative |
      | Test       | Test     | 20    | true    | today-5  | today-3   | Dates must not be in the past |
      | Test       | Test     | 20    | false   | today+2  | today-1   | Dates must not be in the past |
