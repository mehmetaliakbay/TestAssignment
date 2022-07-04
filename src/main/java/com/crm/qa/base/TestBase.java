package com.crm.qa.base;

import com.crm.qa.config.GlobalConst;
import com.crm.qa.utils.TestListener;
import com.crm.qa.utils.TestUtils;
import com.crm.qa.utils.WebEventListener;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

@Listeners(TestListener.class)
public class TestBase {


    public static WebDriver driver ;
    public static EventFiringWebDriver e_driver ;
    public static WebEventListener eventListener ;

    @BeforeMethod(alwaysRun = true)
    public static void initialization (){
         driver = DriverFactory.getLocalWebDriver("CHROME");

        PropertyConfigurator.configure("log4j.properties");
        e_driver = new EventFiringWebDriver(driver);

        // Now create object of EventListerHandler to register it with  EventFiringWebDriver
         eventListener = new WebEventListener() ;
         e_driver.register(eventListener);
         driver = e_driver ;

        driver.get(GlobalConst.URL);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getDriver()!=null) {
            getDriver().close();
            getDriver().quit();
        }

    }




}
