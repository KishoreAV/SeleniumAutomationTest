package com.learn.automation.pageclass;

import com.testhelp.Config;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractBasePage {
    WebDriver driver;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void openBaseUrl(){
        driver.get(Config.getPropertyValue(Config.getResourcePath(this.getClass(),"./global/global.properties"),"BASE_URL"));
    }
}
