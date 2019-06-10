package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Parent class for Page Object classes.
 */
public abstract class BasePage {

    public static final int DEFAULT_WAIT_FOR_PAGE_LOAD = TestSettings.getInstance().getWaitPageLoad();
    public static final int DEFAULT_WAIT_FOR_ELEMENT_LOAD = TestSettings.getInstance().getWaitElementLoad();

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_LOAD);
    }

    /**
     * Opens web page in web browser by URL
     * @param url of web page
     * @return current page instance
     */
    public BasePage navigateToURL(String url){
        driver.navigate().to(url);
        return this;
    }

    /**
     * @return current web page title
     */
    public String getPageTitle(){
        return driver.getTitle();
    }

    /**
     * @return current web page URL
     */
    public String getPageURL(){
        return  driver.getCurrentUrl();
    }

    protected void setImplicitWaitToZero(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    protected void setImplicitWaitToDefault(){
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_FOR_ELEMENT_LOAD, TimeUnit.SECONDS);
    }
}
