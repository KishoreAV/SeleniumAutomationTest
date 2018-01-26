package com.learn.automation.pageclass.drag;

import com.learn.automation.pageclass.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragPage extends CommonPage {
    
    @FindBy(xpath = "(//iframe[@class='demo-frame'])[1]")
    private WebElement frameDefault;
    
    @FindBy(linkText = "Default functionality")
    private WebElement btnSelectDefault;
    
    @FindBy(id="draggable")
    private WebElement eleDrag;
    
    public DragPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }
    
    public DragPage switchToDefaultFunctionalityFrame() {
        clickWebElement(btnSelectDefault);
        switchToFrame(frameDefault);
        return this;
    }
    
    public DragPage dragElementRandom(){
        actions.dragAndDropBy(eleDrag,randomNumber(-250,250),randomNumber(-250,250)).perform();
        return this;
    }
}
