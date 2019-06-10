package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Manages initialization and cleaning up Selenium Webdriver instance based on specified settings properties
 */
public class Driver {

    private static WebDriver driver;

    public Driver(){
        TestSettings settings = TestSettings.getInstance();
        System.setProperty("webdriver.chrome.driver", settings.getChromeDriverPath());
        switch (settings.getDriverType()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "headless":
                driver = initHeadlessDriver();
                break;
            default:
                driver = initChromeDriver();
        }
        setDriverTimeouts();
    }

    private void setDriverTimeouts(){
        driver.manage().timeouts().implicitlyWait(BasePage.DEFAULT_WAIT_FOR_ELEMENT_LOAD, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(BasePage.DEFAULT_WAIT_FOR_PAGE_LOAD, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(BasePage.DEFAULT_WAIT_FOR_ELEMENT_LOAD, TimeUnit.SECONDS);
    }

    private WebDriver initChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-fullscreen");
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver initHeadlessDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=" + TestSettings.getInstance().getWindowSize());
        return new ChromeDriver(chromeOptions);
    }

    /**
     * @return current Selenium Webdriver instance
     */
    public WebDriver getWebdriver(){
        return driver;
    }

    /**
     * Tears down current Selenium Webdriver instance and its processes
     */
    public void driverTearDown(){
        driver.close();
        driver.quit();
    }

}
