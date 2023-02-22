package com.test.nhsProject.stepDefinitions;

import com.test.nhsProject.pages.DashboardAdminPage;

import com.test.nhsProject.utils.DriverHelper;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class DashboardAdminStepDef {
    WebDriver driver= DriverHelper.getDriver();
    DashboardAdminPage dashboardAdminPage=new DashboardAdminPage(driver);

    @Then("the user validates the amount of cards on dashboard is {int}")
    public void the_user_validates_the_amount_of_cards_on_dashboard_is(Integer expectedAmountOfcards) {
        Assert.assertEquals((int) expectedAmountOfcards,dashboardAdminPage.getCountOfAllCards());
    }
    @Then("the user validates the {string}, the {string} and the {string} of the card")
    public void the_user_validates_the_the_and_the_of_the_card(String expectedTitle, String expectedBackgroundColor,String iconName) {
        dashboardAdminPage.validateTitlesAndColorsOfCards(expectedTitle,expectedBackgroundColor,iconName);
    }
}
