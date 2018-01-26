package com.learn.automation.pageclass;

import com.testhelp.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends CommonPage {
    
    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }
    
    /**
     * Section to have all the elements to be used in the page.
     */
    @FindBy(linkText = "Signin")
    private WebElement lblmenuAlert;
    
    @FindBy(id = "load_box")
    private WebElement elepopRegisterForm;
    
    @FindBy(id = "login")
    private WebElement elepopLoginForm;
    
    @FindBy(xpath = "(//input[@name='username'])[2]")
    private WebElement txtLoginUsername;
    
    @FindBy(xpath = "(//input[@name='password'])[2]")
    private WebElement txtLoginPassword;
    
    @FindBy(xpath = "(//input[@class='button'])[2]")
    private WebElement btnSubmitLogin;
    
    @FindBy(css = "#toggleNav > li:nth-child(7) > a:nth-child(1)")
    private WebElement menuItemAlert;
    
    @FindBy(css = "#toggleNav > li:nth-child(5) > a:nth-child(1)")
    private WebElement menuDynamicElements;
    
    @FindBy(css = "#toggleNav > li:nth-child(5) > ul:nth-child(2) > li:nth-child(2) > a")
    private  WebElement menuDynamicElementsDropdown;
    
    @FindBy(linkText = "Interaction")
    private WebElement menuInteraction;
    
    @FindBy(linkText = "Draggable")
    private WebElement menuDraggable;
    
    public void openBaseUrl(){
        logger.debug("Opening base url");
        webDriver.get(Config.getPropertyValue(Config.getResourcePath(this.getClass(),"./global/global.properties"),"BASE_URL"));
    }
    
    
    private void clickSigninLink(){
        logger.trace("clicking Signin");
        clickWebElement(lblmenuAlert);
    }
    
    private void setUsernamePasswordAndSubmit(){
        logger.trace("setting text");
        setText(txtLoginUsername,"test");
        setText(txtLoginPassword,"test");
        logger.trace("clicking submit");
        clickWebElement(btnSubmitLogin);
    }
    
    public void navigateToAlertPage(){
        clickWebElement(menuItemAlert);
    }
    
    public void navigateToDropdownPage(){
        moveCursor(menuDynamicElements);
        clickWebElement(menuDynamicElementsDropdown);
    }
    
    public void navigateToDragablePage(){
        moveCursor(menuInteraction);
        clickWebElement(menuDraggable);
    }
    
    public void Login(){
        openBaseUrl();
        if (checkElementDisplayed(elepopRegisterForm)){
            clickSigninLink();
        }else {
            logger.trace("Registration form not displayed.");
        }
        waitForPageReady();
        if (checkElementDisplayed(elepopLoginForm)){
            setUsernamePasswordAndSubmit();
            waitForPageReady();
            Assert.assertFalse(checkElementDisplayed(elepopLoginForm));
        }else{
            logger.trace("Login not displayed.");
        }
        
    }
}


