package com.learn.automation.tests.drag;

import com.learn.automation.pageclass.HomePage;
import com.learn.automation.pageclass.drag.DragPage;
import com.learn.automation.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestDrag extends BaseTest {
    
    @Test(testName = "Verify dragging function", description = "random dragging")
    public void testElementDrag() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = getWebDriver();
        HomePage homePage = new HomePage(driver);
        homePage.Login();
        homePage.navigateToDragablePage();
        homePage.waitForPageReady();
        //error expected due to different spacing
        softAssert.assertEquals(homePage.getText(homePage.elePageheading), "Draggable  ");
        softAssert.assertTrue(false,"Test soft asserts");
        DragPage dragPage = new DragPage(driver);
        dragPage.switchToDefaultFunctionalityFrame();
        for (int i = 0; i < 10; i++) {
            dragPage.dragElementRandom();
        }
        softAssert.assertAll();
    }
}
