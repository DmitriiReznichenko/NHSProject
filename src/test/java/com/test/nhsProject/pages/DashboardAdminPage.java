package com.test.nhsProject.pages;

import com.test.nhsProject.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardAdminPage {
    public DashboardAdminPage(WebDriver driver){
        PageFactory.initElements(driver,this);}
    @FindBy (css = ".panel-heading")
    List<WebElement> allCards;
    @FindBy (xpath = "//div[@class='panel-heading']//div[@class='col-xs-9 text-right']//div[2]")
    List<WebElement> titlesOfCards;

    @FindBy(xpath = "//div[@class='col-xs-3']//i")
    List<WebElement> allIconNames;

    @FindBy (linkText = "Add patient")
    WebElement addPatientButton;

    @FindBy(xpath = "//input[@placeholder='Search patient waiting...']")
    WebElement searchPatientWaiting;
    @FindBy(xpath = "//table[@id='patients-waiting']//tbody//tr")
    List<WebElement> rowsPatientsWaitingTable;

    public int getCountOfAllCards(){
        return allCards.size();
    }
    public void validateTitlesAndColorsOfCards(String title, String color,String iconName){
        for(int i=0;i<titlesOfCards.size();i++){
            if (BrowserUtils.getText(titlesOfCards.get(i)).equals(title)){
                Assert.assertEquals(title,BrowserUtils.getText(titlesOfCards.get(i)));
                Assert.assertEquals(color,allCards.get(i).getCssValue("background-color"));
                Assert.assertTrue(allIconNames.get(i).getAttribute("class").contains(iconName));
                break;
            }
            }
    }
    public void clickAddPatientBtn(){
        addPatientButton.click();
    }
    public void validatingPatientIsAddedToPatientsWaitingTable(String firstName,String lastName,String no_){
        Assert.assertTrue(rowsPatientsWaitingTable.get(rowsPatientsWaitingTable.size() - 1)
                .getText().contains( no_+ " "+ firstName +" "+ lastName));
    }
    public void openPatientPage(WebDriver driver) {
        Actions actions=new Actions(driver);
        actions.doubleClick(rowsPatientsWaitingTable.get(rowsPatientsWaitingTable.size()-1)).perform();

    }
}
