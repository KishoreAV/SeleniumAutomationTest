package com.learn.automation.tests;

import com.learn.automation.util.GlobalUtil;
import com.testhelp.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
//    protected WebDriver driver;
    protected static Logger logger = LogManager.getLogger();
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    
    @BeforeMethod
    public void setup(){
        GlobalUtil globalUtil = new GlobalUtil();
        WebDriver driver;
//        this.driver = globalUtil.getWebDriver();
        /*
        Checking implementation of thread local
         */
        webDriverThreadLocal.set(globalUtil.getWebDriver());
        driver = webDriverThreadLocal.get();
        Config config = new Config();
        config.setResourcePath(this.getClass(),"./global/global.properties");
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getValue("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Integer.parseInt(config.getValue("SCRIPT_TIMEOUT")), TimeUnit.SECONDS);
        logger.info("Webdriver is setup.");
        logger.info("Setup Thread ID: " + Thread.currentThread().getId());
        //driver.manage().window().setSize(new Dimension(1280, 720));
    }
    
    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        webDriverThreadLocal.get().quit();
        logger.info("Driver is quit.");
    }
    
    protected WebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }
}
