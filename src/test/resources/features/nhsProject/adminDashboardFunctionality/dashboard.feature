@regression @smoke

Feature: Testing of NHS Dashboard for Admin User

  Background: Given the user navigate to the NHS website
    When the user enters the username "validUserName" and password "validPassword"
    And the user press the SignIn button

  @NA-T10
  Scenario: Verification NHS Dashboard for Admin User have 3 cards
    Then the user validates the amount of cards on dashboard is 3

  @NA-T11
  Scenario Outline:
    Then the user validates the '<title>', the '<backgroundColor>' and the '<iconName>' of the card
    Examples:
      | title               | backgroundColor       | iconName |
      | Patients with rooms | rgba(51, 122, 183, 1) | hotel    |
      | Patients waiting    | rgba(217, 83, 79, 1)  | child    |
      | Free rooms          | rgba(232, 145, 6, 1)  | hospital |