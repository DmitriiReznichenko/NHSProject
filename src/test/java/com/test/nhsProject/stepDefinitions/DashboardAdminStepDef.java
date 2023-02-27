package com.test.nhsProject.stepDefinitions;

import com.test.nhsProject.pages.DashboardAdminPage;

import com.test.nhsProject.pages.PatientPage;
import com.test.nhsProject.utils.DriverHelper;
import io.cucumber.java.en.Then;
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

    @Then("the user should be able to see the patient {string},{string},{string} is added to the main page under Patients waiting")
    public void the_user_should_be_able_to_see_the_patient_is_added_to_the_main_page_under_patients_waiting(String firstName,
                                                                                                            String lastName,
                                                                                                            String no_) {
        dashboardAdminPage.validatingPatientIsAddedToPatientsWaitingTable(firstName,lastName,no_);
    }

    @Then("the user deletes the patient")
    public void the_user_deletes_the_patient()  {
        dashboardAdminPage.openPatientPage(driver);
        patientPage.deletePatient();

    }

}