package com.learn.automation.pageclass.dynamic;

import com.learn.automation.pageclass.CommonPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class DropDown extends CommonPage {
    
    public DropDown(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    
    public void switchToSelectCountryFrame() {
        clickWebElement(btnFrameSeletCounty);
        switchToFrame(frameSelectCountry);
    }
    
    public void switchToEnterCountryFrame() {
        clickWebElement(btnFrameEnterCounty);
        switchToFrame(frameEnterCountry);
    }
    public void selectRandomItem(){
        Select select = new Select(drpdwnSimple);
        List<WebElement> list = select.getOptions();
        select.selectByIndex((new Random()).nextInt(list.size())+1);
        logger.info("Selected Item: " + select.getFirstSelectedOption().getText());
    }
    
    private String selectRandomItemFromList(){
        Select select = new Select(lstItems);
        String selectedItem = select.getOptions().get((new Random()).nextInt(select.getOptions().size())+1).getText();
        logger.info("Random Text Selected : " + selectedItem );
        return selectedItem;
    }
    
    public void enterTextInCombobox(){
        setText(ipCustomBox,selectRandomItemFromList());
    }
    public void verifytext(){
        ipCustomBox.sendKeys(Keys.TAB);
        waitForPageReady();
//        can't verify without elaborate techniques.
//        Assert.assertNotEquals(ipCustomBox.getText().trim(),"".trim());
        
    }
    
    
    @FindBy(linkText = "Select Country")
    private WebElement btnFrameSeletCounty;
    
    @FindBy(linkText = "Enter Country")
    private WebElement btnFrameEnterCounty;
    
    @FindBy(xpath = "(//iframe[@class='demo-frame'])[1]")
    private WebElement frameSelectCountry;
    
    @FindBy(xpath = "(//iframe[@class='demo-frame'])[2]")
    private WebElement frameEnterCountry;
    
    @FindBy(css = "body > select")
    private WebElement drpdwnSimple;
    
    @FindBy(id = "combobox")
    private WebElement lstItems;
    
    @FindBy(css = "input.custom-combobox-input")
    private WebElement ipCustomBox;
    
}
