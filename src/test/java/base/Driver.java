package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andres on 6/7/2019.
 */
class Driver {

    private static WebDriver driver;
    private String scenarioName;

    Driver(String scenarioName){
        this.scenarioName = scenarioName;
        TestSettings settings = TestSettings.getInstance();
        //String chromeDriverPath = settings.
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
        driver.manage().timeouts().pageLoadTimeout(BasePage.DEFAULT_WAIT_FOR_ELEMENT_LOAD, TimeUnit.SECONDS);
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

    WebDriver getWebdriver(){
        return driver;
    }

}
