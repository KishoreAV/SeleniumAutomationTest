package com.learn.automation.tests;

import com.learn.automation.pageclass.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CheckAlertBox extends BaseTest{
    
    @Test(testName = "Login Test")
    public void Login(){
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        
        homePage.openBaseUrl();
        if (homePage.checkPopupRegistrationForm()){
            homePage.clickSigninLink();
        }else {
            logger.trace("registration form not displayed");
        }
        homePage.waitForPageReady();
        if (homePage.checkPopupLoginForm()){
            logger.debug("found login box");
            homePage.setUsernamePasswordAndSubmit();
        }else{
            logger.debug("not found the box");
        }
        
    }
}
