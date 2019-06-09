package tests.steps;

import base.ScenarioContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.InboxPage;

/**
 * Created by Andres on 6/7/2019.
 */
public class RemoveEmailSteps {

    // **** WHEN's ****

    @When("^I Remove newly received email message on Inbox page$")
    public void iRemoveNewlyReceivedEmailMessageOnInboxPage() throws Throwable {
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        inboxPage.deleteFirstEmail();
        System.out.println("done");
    }

    @When("^I Remove first email message on Inbox page$")
    public void iRemoveFirstEmailMessageOnInboxPage() throws Throwable {
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        inboxPage.deleteFirstEmail();
    }

    // **** THEN's ****

    @Then("^There is no more incoming email messages on Inbox page$")
    public void thereIsNoMoreIncomingEmailMessagesOnInboxPage() throws Throwable {
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        Assert.assertTrue(inboxPage.isIncomingMessageListEmpty());
    }
}
