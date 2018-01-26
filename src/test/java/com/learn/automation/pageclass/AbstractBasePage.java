package com.learn.automation.pageclass;

import com.testhelp.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractBasePage {
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
            try {
                wait.until((webDriver) -> ((Boolean) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active==0")));
                logger.trace("jQ Done.");
            }catch (WebDriverException e){
                if (e.getMessage().contains("'jQuery'")){
                    logger.trace("jQuery Run Exception");
                    waitForPageReady();
                }
            }
        }
    }
    
    protected void switchToFrame(WebElement element){
        webDriver.switchTo().frame(element);
    }
    
    protected void switchToFrame(){
        webDriver.switchTo().defaultContent();
    }
    
    protected String getAlertText(){
        return webDriver.switchTo().alert().getText();
    }
    
    public void acceptAlert(){
        webDriver.switchTo().alert().accept();
    }
    
    public void sendTextToAlert(String string){
        webDriver.switchTo().alert().sendKeys(string);
    }
    
    protected boolean isAlertPresent() {
         WebDriverWait webDriverWait = new WebDriverWait(webDriver,Integer.parseInt(config.getValue("WAIT_SHORT")));
         try {
             webDriverWait.until((webDriver) -> {
                 try {
                     webDriver.switchTo().alert();
                     return true;
                 } catch (NoAlertPresentException e) {
                     return false;
                 }
             });
             return true;
         }catch (TimeoutException e){
             logger.trace(e.getLocalizedMessage());
             return false;
         }
    }
    
    
    
    protected void clickWebElement(WebElement webElement) {
        try{
            logger.trace("Clicking on " + webElement.toString());
            Objects.requireNonNull(checkClickable(webElement)).click();
        }catch (Exception e){
            logger.error("Error in clicking element", webElement.toString());
        }
    }
    protected void moveCursor(WebElement webElement){
        actions.moveToElement(checkVisible(webElement)).perform();
    }
    
    private WebElement checkVisible(WebElement webElement){
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
            logger.trace(element.toString() + " Element found in page. Location: " + element.getLocation().toString());
            return element;
        }catch (Exception e){
            logger.error("Error in finding element. " + webElement.toString() + e.getLocalizedMessage());
            return null;
        }
    }
    private WebElement checkClickable(WebElement webElement){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
            logger.trace(element.toString() + " Element found in page. Location: " + element.getLocation().toString());
            return element;
        }catch (Exception e){
            logger.error("Error in finding element. " + webElement.toString() + e.getLocalizedMessage());
            return null;
        }
    }
    protected Boolean checkElementDisplayed(WebElement webElement){
        try {
            return webElement.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
    
    public String getText(WebElement webElement){
        return checkVisible(webElement).getText();
    }
    
    protected void setText(WebElement webElement, String string){
        try {
            WebElement element = checkVisible(webElement);
            element.clear();
            element.sendKeys(string);
            logger.trace("Following value is set for " + webElement.toString() + ": " + string);
        }catch (Exception e){
            logger.error("Error in setting text. " + webElement.toString() + e.getLocalizedMessage());
        }
    }
    
    public int randomNumber(int lBound, int uBound){
        return ThreadLocalRandom.current().nextInt(lBound,uBound+1);
    }
}
