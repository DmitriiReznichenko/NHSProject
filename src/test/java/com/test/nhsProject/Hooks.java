package com.test.nhsProject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.test.nhsProject.utils.ConfigReader;
import com.test.nhsProject.utils.DriverHelper;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public WebDriver driver;
    @Before
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty(""));
    }
    @After
    public void tearDown(){


    }
}

