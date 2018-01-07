package com.learn.automation.tests;

import com.learn.automation.util.GlobalUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected static Logger logger = LogManager.getLogger();
    @BeforeMethod
    public void setup(){
        GlobalUtil globalUtil = new GlobalUtil();
        this.driver = globalUtil.getWebDriver();
        logger.info("Webdriver is setup.");
        //driver.manage().window().setSize(new Dimension(1280, 720));
    }
    
    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
        logger.info("Driver is quit.");
    }
}
