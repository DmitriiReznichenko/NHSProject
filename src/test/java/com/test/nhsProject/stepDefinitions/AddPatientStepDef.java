package com.test.nhsProject.stepDefinitions;

import com.test.nhsProject.pages.AddPatientPage;
import com.test.nhsProject.pages.DashboardAdminPage;
import com.test.nhsProject.utils.DriverHelper;

import com.test.nhsProject.utils.GenerateFakeTestData;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;



public class AddPatientStepDef {
    WebDriver driver= DriverHelper.getDriver();
    DashboardAdminPage dashboardAdminPage=new DashboardAdminPage(driver);
    AddPatientPage addPatientPage=new AddPatientPage(driver);
    GenerateFakeTestData fakeTestData=new GenerateFakeTestData();
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
    @When("the user enters patient data: First Name, Last Name, Hospital no., Date of birth, Sex and clicks the button addPatient")
    public void the_user_enters_patient_data_first_name_last_name_hospital_no_date_of_birth_sex_and_clicks_the_button_add_patient() {
        addPatientPage.inputPatientDataAndClickAddPatientBtn(fakeTestData.getFirstNamePatient(), fakeTestData.getLastNamePatient(),
                fakeTestData.getHospitalNo_Patient(), fakeTestData.getDateOfBirthPatient(), fakeTestData.getSexPatient());
    }
    @Then("the user should be able to see new patient's First Name, Last Name, Hospital no. on Dashboard page under Patients waiting")
    public void the_user_should_be_able_to_see_new_patient_s_first_name_last_name_hospital_no_on_dashboard_page_under_patients_waiting(){
        addPatientPage.validatingPatientIsAddedToPatientsWaitingTable(
                fakeTestData.getFirstNamePatient(),
                fakeTestData.getLastNamePatient(),
                fakeTestData.getHospitalNo_Patient());
    }
    @Then("the user validates Search results for searching with First Name, Last Name, Full Name and Hospital no. show new patient data")
    public void the_user_validates_search_results_for_searching_with_first_name_last_name_full_name_and_hospital_no_show_new_patient_data() {
        dashboardAdminPage.validatingSearchForPatientWaitingBarFunctionality(
                fakeTestData.getFirstNamePatient(), fakeTestData.getLastNamePatient(), fakeTestData.getHospitalNo_Patient());
    }







}
