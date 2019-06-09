package tests.steps;

import base.Driver;
import base.ScenarioContext;
import base.TestSettings;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;

import java.io.File;

/**
 * Created by Andres on 6/7/2019.
 */
public class Hooks {

    @Before
    public void initializeTest(Scenario scenario){
        Driver driver = new Driver(scenario);
        LoginPage page = new LoginPage(driver.getWebdriver());
        ScenarioContext.set(ScenarioContext.ContextKey.LOGIN_PAGE, page);
        ScenarioContext.set(ScenarioContext.ContextKey.DRIVER, driver);
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        Driver driver = (Driver) ScenarioContext.get(ScenarioContext.ContextKey.DRIVER);
        if (scenario.isFailed()) {
            File sourceFile = ((TakesScreenshot) driver.getWebdriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(sourceFile, new File(TestSettings.getInstance().getScreenshotsPath() + scenario.getName() + ".jpg"));
            } catch (Exception e) {
                System.out.println("ERROR OCCURRED DURING TAKING SCREENSHOT:" + e.toString());
            }
        }
        driver.getWebdriver().close();
        driver.getWebdriver().quit();
    }
}
