package tests.steps;

import base.Driver;
import base.ScenarioContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.LoginPage;

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
            try {
                // Code to capture and embed images in test reports (if scenario fails)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.getWebdriver().close();
        driver.getWebdriver().quit();
    }
}
