package tests.steps;

import base.ScenarioContext;
import base.TestSettings;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pages.InboxPage;
import pages.LoginPage;

/**
 * Created by Andres on 6/7/2019.
 */
public class SignInSteps {

    // **** GIVEN's ****

    @Given("^I sign in the application using correct credentials$")
    public void iSignInTheApplicationUsingCorrectCredentials() throws Throwable {
        TestSettings ts = TestSettings.getInstance();
        LoginPage page = (LoginPage) ScenarioContext.get(ScenarioContext.ContextKey.LOGIN_PAGE);
        page.navigateToURL(ts.getSignInUrl());
        page.signIn(ts.getSignInLogin(), ts.getSignInPassword());
    }

    // **** THEN's ****

    @Then("^I'm on application Inbox page$")
    public void iMOnApplicationInboxPage() throws Throwable {
        InboxPage page = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        Assert.assertEquals(page.getPageTitle(), "");
        Assert.assertEquals(page.getPageURL(), "");
    }
}
