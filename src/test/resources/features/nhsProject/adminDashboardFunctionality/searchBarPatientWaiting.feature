@regression @smoke
Feature: NHS Dashboard Testing of  "patient waiting" Search Bar functionality

  @NA-T22
  Scenario: Positive Testing for "patient waiting" search Bar functionality
    Given the user navigate to the NHS website
    And the user enters the username "validUserName" and password "validPassword"
    And the user press the SignIn button
    And the user clicks the add patient button on the left side of the page
    When the user enters patient data: First Name, Last Name, Hospital no., Date of birth, Sex and clicks the button addPatient
    And the user should be able to see new patient's First Name, Last Name, Hospital no. on Dashboard page under Patients waiting
    Then the user validates Search results for searching with First Name, Last Name, Full Name and Hospital no. show new patient data
    And the user deletes the patient
