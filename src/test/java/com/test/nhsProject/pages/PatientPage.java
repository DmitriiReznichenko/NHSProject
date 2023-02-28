package com.test.nhsProject.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientPage {
    public PatientPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = "#delete-button")
    WebElement deletePatientButton;



    public void deletePatient() {
            deletePatientButton.click();
    }
}
