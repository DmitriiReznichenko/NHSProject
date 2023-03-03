package com.test.nhsProject.stepDefinitions;

import com.test.nhsProject.pages.LoginPage;
import com.test.nhsProject.utils.ConfigReader;
import com.test.nhsProject.utils.DriverHelper;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;



public class LoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    @Given("the user navigate to the NHS website")
    public void the_user_navigate_to_the_nhs_website() {
        driver.get(ConfigReader.readProperty("nhsUrl"));
    }
    @Given("the user validates the url {string} and the title {string}")
    public void the_user_validates_the_url_and_the_title(String exceptedUrl, String exceptedTitle) {
        Assert.assertEquals(exceptedUrl,driver.getCurrentUrl());
        Assert.assertEquals(exceptedTitle,driver.getTitle());

    }
    @When("the user enters the username {string} and password {string}")
    public void the_user_enters_the_username_and_password(String userName, String password){
        loginPage.loginToWebsite(userName,password);
    }
    @When("the user press the SignIn button")
    public void the_user_press_the_sign_in_button(){
        loginPage.clickSignInBtn();
    }
    @Then("the user validates title {string}")
    public void the_user_validates_title(String exceptedTitle) {
        Assert.assertEquals(exceptedTitle,driver.getTitle());
    }
    @Then("the user does not see title {string}")
    public void the_user_does_not_see_title(String title) {
        Assert.assertNotEquals(title, driver.getTitle());
    }
    @Then("the user validates message {string}")
    public void the_user_validates_message(String message){
       loginPage.getErrorMessage(driver,message);
    }

}
