package com.test.nhsProject.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

//SINGLETON PATTERN DESIGN (Centralize your driver into one spot)
public class DriverHelper {
    //Private variable
    private static WebDriver driver;
    //private constructor
    private DriverHelper(){}//you can make the constructor private since you do not want to
    //create an object from this class.One of the great ways of ENCAPSULATION.

    public static WebDriver getDriver(){

        if(driver==null||((RemoteWebDriver)driver).getSessionId()==null){
          //  String browser="chrome";
            switch (ConfigReader.readProperty("browser")){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
            }
            driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }


}
