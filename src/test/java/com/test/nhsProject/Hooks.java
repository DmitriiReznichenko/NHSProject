package com.test.nhsProject;

import com.test.nhsProject.utils.BrowserUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.test.nhsProject.utils.ConfigReader;
import com.test.nhsProject.utils.DriverHelper;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public WebDriver driver;
    @Before
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("nhsUrl"));
    }
    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotCucumber(scenario,driver);
        driver.quit();


    }
}

