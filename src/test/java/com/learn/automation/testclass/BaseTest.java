package com.learn.automation.testclass;

import com.learn.automation.util.GlobalUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver driver;
    protected static Logger logger = LogManager.getLogger();
    @BeforeTest
    public void setup(){
        GlobalUtil globalUtil = new GlobalUtil();
        this.driver = globalUtil.getWebDriver();
        logger.info("Webdriver is setup.");
    }
    
    @AfterTest
    public void tearDown() {
            driver.quit();
            logger.info("Driver is quit.");
    }
}
