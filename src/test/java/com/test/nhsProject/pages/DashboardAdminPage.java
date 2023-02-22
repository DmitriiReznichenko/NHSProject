package com.test.nhsProject.pages;

import com.test.nhsProject.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
