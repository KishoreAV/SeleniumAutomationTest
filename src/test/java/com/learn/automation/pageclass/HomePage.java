package com.learn.automation.pageclass;

import com.testhelp.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage extends AbstractBasePage {
    
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    
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
    
    
    public void openBaseUrl(){
        logger.debug("Opening base url");
        webDriver.get(Config.getPropertyValue(Config.getResourcePath(this.getClass(),"./global/global.properties"),"BASE_URL"));
    }
    
    public boolean checkPopupRegistrationForm(){
        logger.debug("checking for registration form popup");
        try {
            return elepopRegisterForm.isDisplayed();
        }catch (Exception e){
            logger.error("failed to work", () -> e.getLocalizedMessage());
            return false;

        }

    }
    
    public void clickSigninLink(){
        logger.trace("clicking Signin");
        clickWebElement(lblmenuAlert);
    }
    
    
    public boolean checkPopupLoginForm(){
        logger.trace("checking for login form popup");
        try {
            return elepopLoginForm.isDisplayed();
        }catch (Exception e){
            logger.error("failed to work", () -> e.getLocalizedMessage());
            return false;
        }
    }
    
    public void setUsernamePasswordAndSubmit(){
        logger.trace("setting text");
        setText(txtLoginUsername,"test");
        setText(txtLoginPassword,"test");
        logger.trace("clicking submit");
        clickWebElement(btnSubmitLogin);
    }
    
}


