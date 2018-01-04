package com.learn.automation.pageclass;

import com.testhelp.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        logger.debug("clicking Signin");
        clickWebElement(lblmenuAlert);
    }
    
    public boolean checkPopupLoginForm(){
        logger.debug("checking for login form popup");
        try {
            return elepopLoginForm.isDisplayed();
        }catch (Exception e){
            logger.error("failed to work", () -> e.getLocalizedMessage());
            return false;
        }
    }
    
}
