package com.test.nhsProject.pages;

import com.test.nhsProject.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputEmail")
    WebElement userNameField;

    @FindBy(css = "#inputPassword")
    WebElement passwordField;

    @FindBy(tagName = "button")
    WebElement signInBtn;

    public void loginToWebsite(String userName, String password) {
        String name, passwrd;
        if (userName.equals("validUserName")) {
            name = ConfigReader.readProperty("adminUserName");
        } else if (userName.equals("blankUserName")) {
            name="";
    }else {
            name=ConfigReader.readProperty("invalidUserName");
        }
        userNameField.sendKeys(name);
        if (password.equals("validPassword")){
            passwrd=ConfigReader.readProperty("adminPassword");
        } else if (password.equals("blankPassword")) {
            passwrd= "";
        } else {
            passwrd = ConfigReader.readProperty("invalidPassword");
        }
        passwordField.sendKeys(passwrd);
    }
    public void clickSignInBtn() {
        signInBtn.click();
    }
    public void getErrorMessage(WebDriver driver,String message) {
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(message,alert.getText());

    }
    public void logIn2(String userName,String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password, Keys.ENTER);
    }


}
