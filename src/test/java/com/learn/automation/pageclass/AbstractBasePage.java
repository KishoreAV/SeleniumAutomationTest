package com.learn.automation.pageclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

abstract class AbstractBasePage {
    protected WebDriver webDriver;
    protected static Logger logger = LogManager.getLogger();
    
    public AbstractBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
