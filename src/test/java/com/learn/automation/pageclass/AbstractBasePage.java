package com.learn.automation.pageclass;

import com.testhelp.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

abstract class AbstractBasePage {
    protected WebDriver webDriver;
    protected static Logger logger = LogManager.getLogger();
    private WebDriverWait wait;
    private Config config = new Config();
    
    public AbstractBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        
        config.setResourcePath(this.getClass(),"./global/global.properties");
        
        wait = new WebDriverWait(webDriver,Integer.parseInt(config.getValue("WAIT_LONG")));
    }
    
    public void clickWebElement(WebElement webElement) {
        try{
            Objects.requireNonNull(checkVisible(webElement)).click();
            logger.debug("Clicked on ", webElement.toString());
        }catch (Exception e){
            logger.error("Error in clicking element", webElement.toString());
        }
    }
    
    private WebElement checkVisible(WebElement webElement){
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
            logger.debug(element.getText() + " Element found in page. Location: " + element.getLocation().toString());
            return element;
        }catch (Exception e){
            logger.error("Error in finding element. " + e.getLocalizedMessage());
            return null;
        }
    }
}
