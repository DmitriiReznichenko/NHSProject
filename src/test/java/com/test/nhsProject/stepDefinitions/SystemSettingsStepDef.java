package com.test.nhsProject.stepDefinitions;


import com.test.nhsProject.pages.SystemSettingsPage;
import com.test.nhsProject.utils.DriverHelper;
import com.test.nhsProject.utils.GenerateFakeTestData;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class SystemSettingsStepDef {

    WebDriver driver = DriverHelper.getDriver();
    GenerateFakeTestData fakeTestData = new GenerateFakeTestData();
    SystemSettingsPage systemSettingsPage = new SystemSettingsPage(driver);

    @When("the user should be able to add the disease with name and score")
    public void the_user_should_be_able_to_add_the_disease_with_name_and_score() {
        systemSettingsPage.addDisease(fakeTestData.getDisease(), fakeTestData.getScoreDisease());
    }

    @Then("the user validates the diseases from the system are displayed in a table by default order of disease name")
    public void the_user_validates_the_diseases_from_the_system_are_displayed_in_a_table_by_default_order_of_disease_name() {
        systemSettingsPage.isOrderOfDiseaseAlphabetical();
    }

    @Then("the user will be able to delete the created diseases")
    public void the_user_will_be_able_to_delete_the_created_diseases(){
        systemSettingsPage.deleteDisease(driver, fakeTestData.getDisease());
    }

    @Then("the user does not see deleted disease in the table")
    public void the_user_does_not_see_deleted_disease_in_the_table() {
        systemSettingsPage.validatingDeletingDisease(fakeTestData.getDisease());
    }
    @When("the user should be able to add the room with name")
    public void the_user_should_be_able_to_add_the_room_with_name() {
        systemSettingsPage.addNewRoom(fakeTestData.getNameRoom());
    }
    @Then("the user validates the rooms from the system are displayed in a table by default order of rooms name")
    public void the_user_validates_the_rooms_from_the_system_are_displayed_in_a_table_by_default_order_of_rooms_name() {
        systemSettingsPage.isOrderOfRoomTableAlphabetical();
    }
    @Then("the user will be able to delete the created rooms")
    public void the_user_will_be_able_to_delete_the_created_rooms() {
        systemSettingsPage.deleteRoom(fakeTestData.getNameRoom());
    }
    @Then("the user does not see deleted rooms in the table")
    public void the_user_does_not_see_deleted_rooms_in_the_table() {
        systemSettingsPage.validatingRoomIsDeleted(fakeTestData.getNameRoom());
    }
}
