package com.test.nhsProject.pages;

import com.test.nhsProject.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DashboardAdminPage {
    public DashboardAdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".panel-heading")
    List<WebElement> allCards;
    @FindBy(xpath = "//div[@class='panel-heading']//div[@class='col-xs-9 text-right']//div[2]")
    List<WebElement> titlesOfCards;

    @FindBy(xpath = "//div[@class='col-xs-3']//i")
    List<WebElement> allIconNames;

    @FindBy(xpath = "//th[@aria-controls='patients-in-hospital' and contains(text(),'no.')]")
    WebElement headerNo_T1;

    @FindBy(xpath = "//th[contains(text(),'Patients with rooms')]")
    WebElement headerPatientsWithRooms_T1;

    @FindBy(xpath = "//th[contains(text(),'Room')]")
    WebElement headerRoom_T1;

    @FindBy(xpath = "//th[contains(text(),'Room')]//following::th[1]")
    WebElement headerScore_T1;

    @FindBy(linkText = "Add patient")
    WebElement addPatientButton;

    @FindBy(xpath = "//table[@id='patients-waiting']//tbody//tr")
    List<WebElement> rowsPatientsWaitingTable;
    @FindBy(linkText = "System settings")
    WebElement systemSettingButton;
    @FindBy(xpath = "//*[@id='patients-in-hospital']//td")
    List<WebElement> allWebElementsFromPatientsWithRoomsTable;
    @FindBy(xpath = "//*[@id='patients-in-hospital']//td")
    List<WebElement> allWebElementsFromPatientsWaitingTable;
    @FindBy(xpath = "//*[@id='patients-in-hospital']//td")
    List<WebElement> allWebElementsFromFreeRoomsTable;
    @FindBy (xpath = "//a[@href='/']")
    WebElement logOutBtn;



    public int getCountOfAllCards() {
        return allCards.size();
    }

    public void validateTitlesAndColorsOfCards(String title, String color, String iconName) {
        for (int i = 0; i < titlesOfCards.size(); i++) {
            if (BrowserUtils.getText(titlesOfCards.get(i)).equals(title)) {
                Assert.assertEquals(title, BrowserUtils.getText(titlesOfCards.get(i)));
                Assert.assertEquals(color, allCards.get(i).getCssValue("background-color"));
                Assert.assertTrue(allIconNames.get(i).getAttribute("class").contains(iconName));
                break;
            }
        }
    }

    public void validateHeadersForTable_PatientsWithRooms(String header1, String header2, String header3, String header4) {
        Assert.assertEquals(header1, BrowserUtils.getText(headerNo_T1));
        Assert.assertEquals(header2, BrowserUtils.getText(headerPatientsWithRooms_T1));
        Assert.assertEquals(header3, BrowserUtils.getText(headerRoom_T1));
        Assert.assertEquals(header4, BrowserUtils.getText(headerScore_T1));

    }

    public void clickAddPatientBtn() {
        addPatientButton.click();
    }

    public void validatingPatientIsAddedToPatientsWaitingTable(String firstName, String lastName, String no_) {
        Assert.assertTrue(rowsPatientsWaitingTable.get(rowsPatientsWaitingTable.size() - 1)
                .getText().contains(no_ + " " + firstName + " " + lastName));
    }

    public void openPatientPage(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.doubleClick(rowsPatientsWaitingTable.get(rowsPatientsWaitingTable.size() - 1)).perform();
    }

    public void clickSystemSettingsButton() {
        systemSettingButton.click();
    }



    public List<String> getAllDataFromAllTablesDashBoard(WebDriver driver,String user,String password) {

        LoginPage loginPage=new LoginPage(driver);
        logOutBtn.click();
        loginPage.logIn2(user,password);
        List<String> allDataFromPatientsWithRoomsTable = new ArrayList<>();
        List<String> allDataFromPatientsWaitingTable = new ArrayList<>();
        List<String> allDataFromFreeRoomsTable = new ArrayList<>();
        List<String> allDataFromAllTables = new ArrayList<>();
        for (WebElement webelement : allWebElementsFromPatientsWithRoomsTable
        ) {
            allDataFromPatientsWithRoomsTable.add(webelement.getText());
        }
        for (WebElement webelement : allWebElementsFromPatientsWaitingTable
        ) {
            allDataFromPatientsWaitingTable.add(webelement.getText());
        }
        for (WebElement webelement : allWebElementsFromFreeRoomsTable
        ) {
            allDataFromFreeRoomsTable.add(webelement.getText());
        }
        allDataFromAllTables.addAll(allDataFromPatientsWithRoomsTable);
        allDataFromAllTables.addAll(allDataFromPatientsWaitingTable);
        allDataFromAllTables.addAll(allDataFromFreeRoomsTable);
        return allDataFromAllTables;
    }
}
