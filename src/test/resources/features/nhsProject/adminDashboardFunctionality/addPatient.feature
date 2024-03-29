@regression @smoke
Feature: Testing of Adding Patient functionality for Admin User NHS Dashboard

  Background:
    Given the user navigate to the NHS website
    And the user enters the username "validUserName" and password "validPassword"
    And the user press the SignIn button
    And the user clicks the add patient button on the left side of the page

  @NA-T17
  Scenario: Admin User can see add patient details
    Then the user should be able to see add patient details like "First Name", "Last Name", "Hospital no.", "Date of birth" and "Sex"

  @NA-T18
  Scenario: Happy Path for adding new Patient
    When the user enters patient data: First Name, Last Name, Hospital no., Date of birth, Sex and clicks the button addPatient
    Then the user should be able to see new patient's First Name, Last Name, Hospital no. on Dashboard page under Patients waiting
    And the user deletes the patient

