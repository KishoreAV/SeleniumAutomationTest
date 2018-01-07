package com.learn.automation.tests.alert;

import com.learn.automation.pageclass.HomePage;
import com.learn.automation.pageclass.alert.AlertPage;
import com.learn.automation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckAlertBox extends BaseTest{
    
    @Test(testName = "Verify simple alert Box Contents", description = "Login and navigate to alert box page and open Alerts")
    public void testSimpleAlert(){
        HomePage homePage = new HomePage(driver);
        homePage.Login();
        homePage.navigateToAlertPage();
        homePage.waitForPageReady();
        Assert.assertEquals(homePage.getText(homePage.elePageheading),"Alert");
        AlertPage alertPage = new AlertPage(driver);
        alertPage.switchToAlertSimpleFrame();
        alertPage.clickAlertButton();
        alertPage.validateAlert();
        alertPage.acceptAlert();
        alertPage.switchToDefaultFrame();
    }
    
    @Test(testName = "Verify Input alert Box", description = "Login and navigate to alert box page and open Alerts")
    public void testInputAlert(){
        HomePage homePage = new HomePage(driver);
        homePage.Login();
        homePage.navigateToAlertPage();
        homePage.waitForPageReady();
        Assert.assertEquals(homePage.getText(homePage.elePageheading),"Alert");
        AlertPage alertPage = new AlertPage(driver);
        alertPage.switchToAlertInputFrame();
        alertPage.waitForPageReady();
        alertPage.clickAlertButton();
        String stringTemp = "John Doe";
        alertPage.sendTextToAlert(stringTemp);
        alertPage.acceptAlert();
        alertPage.waitForPageReady();
        Assert.assertTrue(alertPage.getEleTextDisplayString().contains(stringTemp));
    }
    
}
