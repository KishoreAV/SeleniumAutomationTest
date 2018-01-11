package com.learn.automation.tests.dynamic;

import com.learn.automation.pageclass.HomePage;
import com.learn.automation.pageclass.dynamic.DropDown;
import com.learn.automation.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDropDown extends BaseTest {
    
    @Test(testName = "Verify drop down 1", description = "Select a random country from the drop down list and log it")
    public void testSimpleDropDown(){
        WebDriver driver = getWebDriver();
        HomePage homePage = new HomePage(driver);
        homePage.Login();
        homePage.navigateToDropdownPage();
        homePage.waitForPageReady();
        Assert.assertEquals(homePage.getText(homePage.elePageheading), "Dropdown");
        DropDown dropDown = new DropDown(driver);
        dropDown.switchToSelectCountryFrame();
        dropDown.selectRandomItem();
    }
    
    @Test(testName = "Verify drop down 2", description = "Select a random country from the drop down list and log it")
    public void testComboDropDown(){
        WebDriver driver = getWebDriver();
        HomePage homePage = new HomePage(driver);
        homePage.Login();
        homePage.navigateToDropdownPage();
        homePage.waitForPageReady();
        Assert.assertEquals(homePage.getText(homePage.elePageheading), "Dropdown");
        DropDown dropDown = new DropDown(driver);
        dropDown.switchToEnterCountryFrame();
        dropDown.waitForPageReady();
        dropDown.enterTextInCombobox();
        dropDown.verifytext();
    }
    
}
