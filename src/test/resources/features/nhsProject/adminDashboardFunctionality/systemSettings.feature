@regression @smoke
#  Creating TestData from FakerJavaClass
Feature: Testing of System Settings functionality for Admin User NHS Dashboard

  Background:
    Given the user navigate to the NHS website
    And the user enters the username "validUserName" and password "validPassword"
    And the user press the SignIn button
    And the user clicks the system setting

  @NA-T20
  Scenario: NHS Positive Testing for Adding new Disease
    When the user should be able to add the disease with name and score
    Then the user validates the diseases from the system are displayed in a table by default order of disease name
    And the user will be able to delete the created diseases
    And the user does not see deleted disease in the table

  @NA-T20
  Scenario: NHS Positive Testing for Adding new Room
    When the user should be able to add the room with name
    Then the user validates the rooms from the system are displayed in a table by default order of rooms name
    And the user will be able to delete the created rooms
    And the user does not see deleted rooms in the table

  @NA-T21
  Scenario: NHS Positive Testing for Adding new User
    When the user adds a new user to system with UserName and Password
    And the user can login to website with credentials for added user
    Then the user validates information displayed on the dashboard page did not change after logging  with new user




