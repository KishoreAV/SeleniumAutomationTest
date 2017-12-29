/**
 * Created by avkis on 2017-12-25.
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;
    
    public class UntitledTestCase {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();
        
//        @BeforeClass(alwaysRun = true)
        public void setUp() throws Exception {
            System.setProperty("webdriver.gecko.driver", "G:\\Git\\SeleniumAutomationTest\\src\\main\\resources\\geckodriver64.exe");
            driver = new FirefoxDriver( );
            baseUrl = "https://www.katalon.com/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        
        
        private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(UntitledTestCase.class);
        @Test
        public void performSomeTask(){
            logger.debug("This is a debug message");
            logger.info("This is an info message");
            logger.warn("This is a warn message");
            logger.error("This is an error message");
            logger.fatal("This is a fatal message");
        }
        
        public void testUntitledTestCase() throws Exception {
            driver.get("https://forum.katalon.com/discussion/4056/katalon-automation-recorder-powerful-selenium-ide-to-record-debug-play-tests-in-any-browsers");
            driver.findElement(By.linkText("All Discussions")).click();
            driver.findElement(By.xpath("//img[@alt='Katalon']")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'Learn more')])[4]")).click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
            driver.findElement(By.linkText("Development Services")).click();
            driver.findElement(By.xpath("//div[@id='TestingServices']/ul/li[4]/a")).click();
            driver.findElement(By.xpath("(//a[contains(text(),'GET STARTED NOW')])[5]")).click();
            // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
            driver.findElement(By.id("207472_6744pi_207472_6744")).click();
            driver.findElement(By.id("207472_6744pi_207472_6744")).clear();
            driver.findElement(By.id("207472_6744pi_207472_6744")).sendKeys("dfrg");
            driver.findElement(By.id("207472_6746pi_207472_6746")).click();
            driver.findElement(By.id("207472_6746pi_207472_6746")).clear();
            driver.findElement(By.id("207472_6746pi_207472_6746")).sendKeys("rgrtt");
            driver.findElement(By.id("207472_6750pi_207472_6750")).click();
            driver.findElement(By.id("207472_6750pi_207472_6750")).clear();
            driver.findElement(By.id("207472_6750pi_207472_6750")).sendKeys("sdfsf");
            driver.findElement(By.id("207472_7778pi_207472_7778")).click();
            new Select(driver.findElement(By.id("207472_7778pi_207472_7778"))).selectByVisibleText("North America - Mexico");
            driver.findElement(By.xpath("//option[@value='47042']")).click();
            driver.findElement(By.id("207472_7780pi_207472_7780_47054")).click();
            driver.findElement(By.id("207472_7780pi_207472_7780_47056")).click();
        }
        
//        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }
        
        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }
        
        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }
        
        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }
