package com.test.nhsProject.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SystemSettingsPage {
    public SystemSettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "diseaseName")
    WebElement diseaseNameField;
    @FindBy(name = "diseaseScore")
    WebElement diseaseScoreField;
    @FindBy(xpath = "//input[@value='Add disease']")
    WebElement addDiseaseBtn;
    @FindBy(xpath = "//table[@id='diseases-table']//td[1]")
    List<WebElement> listOfDiseasesWebElement;
    @FindBy(xpath = "//input[@value='Delete diseases']")
    WebElement deleteDiseaseBtn;
    @FindBy(name = "roomName")
    WebElement roomNameField;
    @FindBy(xpath = "//input[@value='Add room']")
    WebElement addRoomBtn;
    @FindBy(xpath = "//table[@id='rooms-table']//td[1]")
    List<WebElement> listOfRoomsWebelement;
    @FindBy(xpath = "//input[@placeholder='Search room...']")
    WebElement searchBarForRoomTable;
    @FindBy(name = "RD[]")
    WebElement checkBoxForRoomTable;
    @FindBy(xpath = "//input[@value='Delete rooms']")
    WebElement deleteRoomsBtb;
    @FindBy(className = "dataTables_empty")
    WebElement emptyTableMessage;
    @FindBy (name = "username")
    WebElement userNameField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy (linkText = "Logout")
    WebElement logOutBtn;


    public void addDisease(String disease, String score) {
        List<String> listOfDisease = new ArrayList<>();
        for (WebElement webElement : listOfDiseasesWebElement) {
            listOfDisease.add(webElement.getText());
        }
        if (!listOfDisease.contains(disease)) {
            diseaseNameField.sendKeys(disease);
            diseaseScoreField.sendKeys(score);
            addDiseaseBtn.click();
        }
    }
    public void isOrderOfDiseaseAlphabetical() {
        List<String> listOfDisease = new ArrayList<>();
        for (WebElement webElement : listOfDiseasesWebElement) {
            listOfDisease.add(webElement.getText());
        }
        List<String> sortedListOfDisease = new ArrayList<>();
        for (WebElement webElement : listOfDiseasesWebElement) {
            sortedListOfDisease.add(webElement.getText());
        }
        Collections.sort(sortedListOfDisease);
        Assert.assertEquals(sortedListOfDisease, listOfDisease);
    }

    public void deleteDisease(WebDriver driver, String disease) {
        String path1 = "//td[.='";
        String path2 = "']/following-sibling::td/input";
        driver.findElement(By.xpath(path1 + disease.charAt(0) + disease.substring(1).toLowerCase() + path2)).click();
        deleteDiseaseBtn.click();
    }

    public void validatingDeletingDisease(String disease) {
        List<String> updatedListOfDisease = new ArrayList<>();
        for (WebElement webElement : listOfDiseasesWebElement) {
            updatedListOfDisease.add(webElement.getText());
        }
        Assert.assertFalse(updatedListOfDisease.contains(disease));
    }

    public void addNewRoom(String nameRoom) {
        List<String> listOfRooms = new ArrayList<>();
        for (WebElement webElement : listOfRoomsWebelement) {
            listOfRooms.add(webElement.getText());
        }
        if (!listOfRooms.contains(nameRoom)) {
            roomNameField.sendKeys(nameRoom);
            addRoomBtn.click();
        }
    }

    public void isOrderOfRoomTableAlphabetical() {
        List<String> listOfRooms = new ArrayList<>();
        for (WebElement webElement : listOfRoomsWebelement) {
            listOfRooms.add(webElement.getText());
        }
        List<String> sortedListOfRooms = new ArrayList<>();
        for (WebElement webElement : listOfRoomsWebelement) {
            sortedListOfRooms.add(webElement.getText());
        }
        Collections.sort(sortedListOfRooms);
        Assert.assertEquals(sortedListOfRooms, listOfRooms);
    }

    public void deleteRoom(String nameRoom) {
        searchBarForRoomTable.sendKeys(nameRoom);
        checkBoxForRoomTable.click();
        deleteRoomsBtb.click();
    }

    public void validatingRoomIsDeleted(String nameRoom) {
        searchBarForRoomTable.sendKeys(nameRoom);
        Assert.assertTrue(emptyTableMessage.isDisplayed());
    }
    public void addNewUser(String userName,String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password, Keys.ENTER);
    }
    public void logOutSystem(){
        logOutBtn.click();
    }

}
