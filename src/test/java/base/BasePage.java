package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andres on 6/7/2019.
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

    public BasePage navigateToURL(String url){
        driver.navigate().to(url);
        return this;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getPageURL(){
        return  driver.getCurrentUrl();
    }
}
