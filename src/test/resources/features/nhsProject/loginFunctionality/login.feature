@regression @smoke
Feature: Testing the login positive and negative functionalities

  Background:
    Given the user navigate to the NHS website
    And the user validates the url "http://www.techtorialacademy.link/" and the title "LoginPage"

  Scenario: NHS Login Positive testing
    When the user enters the username "validUserName" and password "validPassword"
    And the user press the SignIn button
    Then the user validates title "NHS patients"
    And the user does not see title "LoginPage"

  Scenario: NHS Login Negative testing with invalid password
    When the user enters the username "validUserName" and password "invalidPassword"
    And the user press the SignIn button
    Then the user validates title "LoginPage"
    And the user does not see title "NHS patients"

  Scenario: NHS Login Negative testing with blank password
    When the user enters the username "validUserName" and password "blankPassword"
    And the user press the SignIn button
    Then the user validates title "LoginPage"
    And the user does not see title "NHS patients"

  Scenario: NHS Login Negative testing with invalid credentials
    When the user enters the username "invalidUserName" and password "invalidPassword"
    And the user press the SignIn button
    Then the user validates title "LoginPage"
    And the user does not see title "NHS patients"
