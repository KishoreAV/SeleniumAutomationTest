package com.learn.automation.util;

import com.testhelp.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.util.concurrent.TimeUnit;

public class GlobalUtil {
    private WebDriver webDriver;
    public GlobalUtil() {
        System.setProperty("webdriver.opera.driver", Config.getResourcePath(this.getClass(),"./drivers/operadriver.exe").getFile());
        System.setProperty("webdriver.edge.driver", Config.getResourcePath(this.getClass(),"./drivers/MicrosoftWebDriver.exe").getFile());
        System.setProperty("webdriver.gecko.driver", Config.getResourcePath(this.getClass(),"./drivers/geckodriver.exe").getFile());
        Config config = new Config();
        config.setResourcePath(this.getClass(),"./global/global.properties");
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.setBinary(config.getValue("OPERA_BINARY"));
        operaOptions.addArguments("no-sandbox");
//        webDriver = new OperaDriver(operaOptions);
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getValue("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(Integer.parseInt(config.getValue("SCRIPT_TIMEOUT")), TimeUnit.SECONDS);
        
    }
    
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
