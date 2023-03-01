@regression @smoke
#  Creating TestData from FakerJavaClass
Feature: Testing of System Settings functionality for Admin User NHS Dashboard

  Scenario: NHS Positive Testing for Adding new Disease
    Given the user navigate to the NHS website
    And the user enters the username "validUserName" and password "validPassword"
    And the user press the SignIn button
    When the user clicks the system setting
    And the user should be able to add the disease with name and score
    Then the user validates the diseases from the system are displayed in a table by default order of disease name
    And the user will be able to delete the created diseases
    And the user does not see deleted disease in the table

  Scenario: NHS Positive Testing for Adding new Room
    Given the user navigate to the NHS website
    And the user enters the username "validUserName" and password "validPassword"
    And the user press the SignIn button
    When the user clicks the system setting
    And the user should be able to add the room with name
    Then the user validates the rooms from the system are displayed in a table by default order of rooms name
    And the user will be able to delete the created rooms
    And the user does not see deleted rooms in the table