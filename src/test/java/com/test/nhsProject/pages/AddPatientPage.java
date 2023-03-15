package com.test.nhsProject.pages;

import com.test.nhsProject.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage {
    public AddPatientPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//label[.='First Name']")
    WebElement firstNameLabel;

    @FindBy (xpath = "//label[.='Last Name']")
    WebElement lastNameLabel;

    @FindBy (xpath = "//label[.='Hospital no.']")
    WebElement hospitalNoLabel;

    @FindBy (xpath = "//label[.='Date of birth']")
    WebElement dateOfBirthLabel;

    @FindBy (xpath = "//label[.='Sex']")
    WebElement sexLabel;

    @FindBy (css = ".btn-success")
    WebElement addPatientButton;

    @FindBy (css = "#first-name")
    WebElement firstNameField;

    @FindBy (name = "lastName")
    WebElement lastNameField;

    @FindBy (name = "hospitalNumber")
    WebElement hospitalNo_Field;

    @FindBy (name = "dateOfBirth")
    WebElement dateOfBirthField;

    @FindBy (xpath = "//input[@id='male-radio']//parent::label")
    WebElement maleRadioBtn;

    @FindBy (xpath = "//label//input[@id='female-radio']//parent::label")
    WebElement femaleRadioBtn;

    public void validateAddPatientDetailsAreDisplayedAndCorrect(String expectedFirstNameLabel, String expectedLastNameLabel,
                                                                String expectedHospitalNo_label, String expectedDateOfBirthLabel,
                                                                String expectedSexLabel){
        Assert.assertTrue(firstNameLabel.isDisplayed() && BrowserUtils.getText(firstNameLabel).equals(expectedFirstNameLabel));
        Assert.assertTrue(lastNameLabel.isDisplayed() && BrowserUtils.getText(lastNameLabel).equals(expectedLastNameLabel));
        Assert.assertTrue(hospitalNoLabel.isDisplayed() && BrowserUtils.getText(hospitalNoLabel).equals(expectedHospitalNo_label));
        Assert.assertTrue(dateOfBirthLabel.isDisplayed() && BrowserUtils.getText(dateOfBirthLabel).equals(expectedDateOfBirthLabel));
        Assert.assertTrue(sexLabel.isDisplayed() && BrowserUtils.getText(sexLabel).equals(expectedSexLabel));
    }
    public void inputPatientDataAndClickAddPatientBtn(String firstName,String lastName,
                                                      String hospitalNo,String dateOfBirth,String sex) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        hospitalNo_Field.sendKeys(hospitalNo);
        dateOfBirthField.sendKeys(dateOfBirth);
        if (sex.startsWith("M")){
            maleRadioBtn.click();
        }else {femaleRadioBtn.click();
        }
        addPatientButton.click();
    }
    public void validatingPatientIsAddedToPatientsWaitingTable(String firstName, String lastName, String no_) {
        Assert.assertTrue(DashboardAdminPage.rowsPatientsWaitingTable.get(DashboardAdminPage.rowsPatientsWaitingTable.size() - 1)
                .getText().contains(no_ + " " + firstName + " " + lastName));

    }
}
