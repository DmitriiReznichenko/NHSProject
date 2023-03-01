package com.test.nhsProject.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        List<String> listOfDisease=new ArrayList<>();
        for (WebElement webElement : listOfWebElement) {
            listOfDisease.add(webElement.getText());
        }
        if (!listOfDisease.contains(disease)) {
            diseaseNameField.sendKeys(disease);
            diseaseScoreField.sendKeys(score);
            addDiseaseBtn.click();
        }
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
    public void deleteDisease(WebDriver driver,String disease) {
        String path1 = "//td[.='";
        String path2= "']/following-sibling::td/input";
        driver.findElement(By.xpath(path1+disease.charAt(0)+disease.substring(1).toLowerCase()+path2)).click();
        deleteDiseaseBtn.click();
    }
    public void validatingDeletingDisease(String disease){
        List<String> updatedListOfDisease=new ArrayList<>();
        for (WebElement webElement : listOfWebElement) {
            updatedListOfDisease.add(webElement.getText());
        }
        Assert.assertFalse(updatedListOfDisease.contains(disease));
    }
}
