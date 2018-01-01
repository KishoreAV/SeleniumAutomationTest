package com.learn.automation.tests;

import com.learn.automation.pageclass.HomePage;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {
    
    @Test
    public void openPageTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openBaseUrl();

    }
    @Test
    public void testExclude(){
        logger.info("This is second test.");
    }
}
