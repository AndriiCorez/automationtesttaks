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
 * Initializes and cleans up scenario run
 */
public class Hooks {

    @Before
    public void initializeTest(Scenario scenario){
        System.out.println(scenario.getName() + " scenario is running");
        Driver driver = new Driver();
        LoginPage page = new LoginPage(driver.getWebdriver());
        ScenarioContext.set(ScenarioContext.ContextKey.LOGIN_PAGE, page);
        ScenarioContext.set(ScenarioContext.ContextKey.DRIVER, driver);
    }

    @After
    public void cleanUpTest(Scenario scenario) {
        Driver driver = (Driver) ScenarioContext.get(ScenarioContext.ContextKey.DRIVER);
        if (scenario.isFailed()) {
            File sourceFile = ((TakesScreenshot) driver.getWebdriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(sourceFile, new File(TestSettings.getInstance().getScreenshotsPath() + scenario.getName() + ".jpg"));
            } catch (Exception e) {
                System.out.println("ERROR OCCURRED DURING TAKING SCREENSHOT:" + e.toString());
            }
        }
        driver.driverTearDown();
    }
}
