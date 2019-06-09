package base;

import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andres on 6/7/2019.
 */
public class Driver {

    private static WebDriver driver;
    private String scenarioName;

    public Driver() { throw new IllegalStateException("Should be instantiated using parametrized constructor only"); }

    public Driver(Scenario scenario){
        this.scenarioName = scenario.getName();
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

    public WebDriver getWebdriver(){
        return driver;
    }

}
