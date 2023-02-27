package com.test.nhsProject.stepDefinitions;

import com.test.nhsProject.pages.AddPatientPage;
import com.test.nhsProject.pages.DashboardAdminPage;
import com.test.nhsProject.utils.DriverHelper;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;



public class AddPatientStepDef {
    WebDriver driver= DriverHelper.getDriver();
    DashboardAdminPage dashboardAdminPage=new DashboardAdminPage(driver);
    AddPatientPage addPatientPage=new AddPatientPage(driver);
    @When("the user clicks the add patient button on the left side of the page")
    public void the_user_clicks_the_add_patient_button_on_the_left_side_of_the_page(){
        dashboardAdminPage.clickAddPatientBtn();
    }
    @Then("the user should be able to see add patient details like {string}, {string}, {string}, {string} and {string}")
    public void the_user_should_be_able_to_see_add_patient_details_like_and(String firstNameLabelText,
                                                                            String lastNameLabelText,
                                                                            String hospitalNo_labelText,
                                                                            String dateOfBirthLabelText,
                                                                            String sexLabelText) {
        addPatientPage.validateAddPatientDetailsAreDisplayedAndCorrect(firstNameLabelText, lastNameLabelText, hospitalNo_labelText,
                dateOfBirthLabelText, sexLabelText);
    }
    @When("the user enters patient data:{string},{string},{string},{string},{string} and clicks the button addPatient")
    public void the_user_enters_patient_data_and_clicks_the_button_add_patient(String firstName, String lastName, String hospitalNo,
                                                                               String dateOfBirth, String sex) {
        addPatientPage.inputPatientDataAndClickAddPatientBtn(firstName,lastName,hospitalNo,dateOfBirth,sex);
    }







}
