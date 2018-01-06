package com.learn.automation.pageclass;

import com.testhelp.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

abstract class AbstractBasePage {
    protected WebDriver webDriver;
    protected static Logger logger = LogManager.getLogger();
    private WebDriverWait wait;
    protected Actions actions;
    private Config config = new Config();
    
    protected AbstractBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        
        config.setResourcePath(this.getClass(),"./global/global.properties");
        
        wait = new WebDriverWait(webDriver,Integer.parseInt(config.getValue("WAIT_LONG")));
        actions = new Actions(webDriver);
    }
    
    
    public void waitForPageReady(){
        Boolean usedJquery;
        wait.until((webDriver)-> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete"));
        logger.trace("page ready");
        usedJquery = (Boolean) ((JavascriptExecutor)webDriver).executeScript("return typeof jQuery != 'undefined'");
        if(usedJquery){
            wait.until((webDriver)-> ( (Boolean) ((JavascriptExecutor)webDriver).executeScript("return jQuery.active==0")));
            logger.trace("jQ Done.");
        }
    }
    
    protected void clickWebElement(WebElement webElement) {
        try{
            Objects.requireNonNull(checkVisible(webElement)).click();
            logger.debug("Clicked on " + webElement.toString());
        }catch (Exception e){
            logger.error("Error in clicking element", webElement.toString());
        }
    }
    
    private WebElement checkVisible(WebElement webElement){
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
            logger.debug(element.toString() + " Element found in page. Location: " + element.getLocation().toString());
            return element;
        }catch (Exception e){
            logger.error("Error in finding element. " + webElement.toString() + e.getLocalizedMessage());
            return null;
        }
    }
    private WebElement checkClickable(WebElement webElement){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
            logger.debug(element.getText() + " Element found in page. Location: " + element.getLocation().toString());
            return element;
        }catch (Exception e){
            logger.error("Error in finding element. " + webElement.toString() + e.getLocalizedMessage());
            return null;
        }
    }
    
    protected void setText(WebElement webElement, String string){
        try {
            WebElement element = checkVisible(webElement);
            element.sendKeys(string);
            logger.debug("Following value is set for " + webElement.toString() + ": " + string);
        }catch (Exception e){
            logger.error("Error in setting text. " + webElement.toString() + e.getLocalizedMessage());
        }
    }
}
