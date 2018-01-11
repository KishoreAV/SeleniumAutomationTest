package com.learn.automation.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends AbstractBasePage {
    protected CommonPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }
    
    public void switchToDefaultFrame(){
        switchToFrame();
    }
    
    @FindBy(css = "div.margin-top-20 > h1.heading")
    public WebElement elePageheading;
    
}
