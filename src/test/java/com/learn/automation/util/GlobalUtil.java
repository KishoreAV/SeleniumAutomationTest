package com.learn.automation.util;

import com.testhelp.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class GlobalUtil {
    private WebDriver webDriver;
    public GlobalUtil() {
//        System.setProperty("webdriver.opera.driver", Config.getResourcePath(this.getClass(),"./drivers/operadriver.exe").getFile());
        System.setProperty("webdriver.edge.driver", Config.getResourcePath(this.getClass(),"./drivers/MicrosoftWebDriver.exe").getFile());
        System.setProperty("webdriver.gecko.driver", Config.getResourcePath(this.getClass(),"./drivers/geckodriver.exe").getFile());
        System.setProperty("webdriver.ie.driver", Config.getResourcePath(this.getClass(),"./drivers/IEDriverServer.exe").getFile());
//        OperaOptions operaOptions = new OperaOptions();
//        operaOptions.setBinary(Config.getPropertyValue(Config.getResourcePath(this.getClass(),"./global/global.properties"),"OPERA_BINARY"));
//        operaOptions.addArguments("no-sandbox");
//        webDriver = new OperaDriver(operaOptions);
//        webDriver = new FirefoxDriver();
//        webDriver = new HtmlUnitDriver(true);
        webDriver = new EdgeDriver();
//        webDriver = new InternetExplorerDriver();
    }
    
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
