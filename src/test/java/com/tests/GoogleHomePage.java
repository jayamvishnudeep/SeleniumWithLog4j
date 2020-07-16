package com.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleHomePage {
    //What is log? : capturing info/activities at the time of program execution.
    // types of logs:
    //1. info
    //2. warn
    //3. debug
    //4. fatal

    //how to generate the logs? : use Apache log4j API (log4j jar)
    //How it works? : it reads log 4j configuration from log4j.properties file
    //where to create: create inside resources folder

    WebDriver driver;
    Logger log = Logger.getLogger(GoogleHomePage.class);


    @BeforeMethod
    public void setup() {
        log.info("****************************** Starting test cases execution  *****************************************");

        System.setProperty("webdriver.chrome.driver", "/Users/naveenkhunteta/Downloads/chromedriver");
        driver = new ChromeDriver();
        log.info("launching chrome broswer");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com/");
        log.info("Entering Google URL");
        log.warn("Hey this just a warning message");
        log.fatal("Hey this is just fatal error message");
        log.debug("Hey this is debug message");
    }


    @Test(priority = 1)
    public void googleHomePageTest() {
        log.info("****************************** starting test case *****************************************");
        log.info("****************************** googleHomePageTest *****************************************");
        String title = driver.getTitle();
        System.out.println(title);
        log.info("Google page title is--->" + title);
        Assert.assertEquals(title, "google");

        log.info("****************************** ending test case *****************************************");
        log.info("****************************** googleHomePageTest *****************************************");

    }

    @Test(priority = 2)
    public void googleInputSearchBarTest() {
        log.info("****************************** starting test case *****************************************");
        log.info("****************************** googleInputSearchBarTest *****************************************");

        boolean b = driver.findElement(By.name("q")).isDisplayed();
        Assert.assertTrue(b);

        log.info("****************************** ending test case *****************************************");
        log.info("****************************** googleInputSearchBarTest *****************************************");

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("****************************** Browser is closed *****************************************");


    }


}