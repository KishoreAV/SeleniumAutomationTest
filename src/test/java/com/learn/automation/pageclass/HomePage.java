package com.learn.automation.pageclass;

import com.testhelp.Config;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractBasePage {
    
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    
    public void openBaseUrl(){
        logger.info("Opening base url");
        webDriver.get(Config.getPropertyValue(Config.getResourcePath(this.getClass(),"./global/global.properties"),"BASE_URL"));
    }
}
