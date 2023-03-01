package com.test.nhsProject.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SystemSettingsPage {
    public SystemSettingsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (name = "diseaseName")
    WebElement diseaseNameField;
    @FindBy (name = "diseaseScore")
    WebElement diseaseScoreField;
    @FindBy (xpath = "//input[@value='Add disease']")
    WebElement addDiseaseBtn;
    @FindBy(xpath = "//table[@id='diseases-table']//td[1]")
    List<WebElement> listOfWebElement;
    @FindBy(xpath = "//input[@value='Delete diseases']")
    WebElement deleteDiseaseBtn;


    public void addDisease(String disease,String score)  {
        diseaseNameField.sendKeys(disease);
        diseaseScoreField.sendKeys(score);
        addDiseaseBtn.click();
    }
    public void isOrderOfDiseaseAlphabetical(){
        List<String> listOfDisease=new ArrayList<>();
        for (WebElement webElement : listOfWebElement) {
            listOfDisease.add(webElement.getText());
        }
        List<String> sortedListOfDisease=new ArrayList<>();
        for (WebElement webElement : listOfWebElement) {
            sortedListOfDisease.add(webElement.getText());
        }
        Collections.sort(sortedListOfDisease);
        Assert.assertEquals(sortedListOfDisease,listOfDisease);
    }
    public void deleteDisease(WebDriver driver,String disease)  {
        for (WebElement webElement : listOfWebElement) {
            if (webElement.getText().equals(disease)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(webElement).moveByOffset(290, 0).click().build().perform();
                break;
            }
        }
        deleteDiseaseBtn.click();
    }




}