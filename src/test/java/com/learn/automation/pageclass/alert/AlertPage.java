package com.learn.automation.pageclass.alert;

import com.learn.automation.pageclass.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlertPage extends CommonPage {
    
    public AlertPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }
    
    
    public void switchToAlertSimpleFrame(){
        clickWebElement(btnFrameSimpleAlert);
        switchToFrame(frameAlertSimple);
    }
    
    public void switchToAlertInputFrame(){
        clickWebElement(btnFrameInputAlert);
        switchToFrame(frameAlertInput);
    }
    
    public void validateAlert(){
        if (isAlertPresent()){
            Assert.assertEquals(getAlertText(),"I am an alert box!");
        }
    }
    public void  clickAlertButton(){
        clickWebElement(btnAlert);
    }
    
    public String getEleTextDisplayString() {
        return getText(eleTextDisplay);
    }
    
    @FindBy(xpath = "(//iframe[@class='demo-frame'])[1]")
    private WebElement frameAlertSimple;
    
    @FindBy(linkText = "Simple Alert")
    private WebElement btnFrameSimpleAlert;
    
    @FindBy(linkText = "Input Alert")
    private WebElement btnFrameInputAlert;
    
    @FindBy(xpath = "(//iframe[@class='demo-frame'])[2]")
    private WebElement frameAlertInput;
    
    @FindBy(css = "body > button")
    private WebElement btnAlert;
    
    @FindBy(css = "#demo")
    private WebElement eleTextDisplay;
    
    
}
