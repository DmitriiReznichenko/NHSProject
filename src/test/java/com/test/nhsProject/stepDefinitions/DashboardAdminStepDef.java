package com.test.nhsProject.stepDefinitions;

import com.test.nhsProject.pages.DashboardAdminPage;

import com.test.nhsProject.pages.PatientPage;

import com.test.nhsProject.utils.DriverHelper;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class DashboardAdminStepDef {
    WebDriver driver= DriverHelper.getDriver();
    DashboardAdminPage dashboardAdminPage=new DashboardAdminPage(driver);
    PatientPage patientPage=new PatientPage(driver);


    @Then("the user validates the amount of cards on dashboard is {int}")
    public void the_user_validates_the_amount_of_cards_on_dashboard_is(Integer expectedAmountOfcards) {
        Assert.assertEquals((int) expectedAmountOfcards,dashboardAdminPage.getCountOfAllCards());
    }
    @Then("the user validates the {string}, the {string} and the {string} of the card")
    public void the_user_validates_the_the_and_the_of_the_card(String expectedTitle, String expectedBackgroundColor,String iconName) {
        dashboardAdminPage.validateTitlesAndColorsOfCards(expectedTitle,expectedBackgroundColor,iconName);
    }
    @Then("the user can see the headers  with information: {string}, {string}, {string}, {string}.")
    public void the_user_can_see_the_headers_with_information(String headerNo_T1, String headerPatientsWithRooms, String headerRoom, String headerScore_T1) {
        dashboardAdminPage.validateHeadersForTable_PatientsWithRooms(headerNo_T1,headerPatientsWithRooms,headerRoom,headerScore_T1);

    }



    @Then("the user deletes the patient")
    public void the_user_deletes_the_patient()  {
        dashboardAdminPage.openPatientPage(driver);
        patientPage.deletePatient();
    }
    @When("the user clicks the system setting")
    public void the_user_clicks_the_system_setting() {
dashboardAdminPage.clickSystemSettingsButton();
    }
}
