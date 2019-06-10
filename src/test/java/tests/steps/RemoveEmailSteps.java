package tests.steps;

import base.ScenarioContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Await;
import org.testng.Assert;
import pages.InboxPage;

public class RemoveEmailSteps {

    // **** GIVEN's ****

    @Given("^I delete all available incoming Email messages$")
    public void iDeleteAllAvailableIncomingEmailMessages() throws Throwable {
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        inboxPage.deleteAllAvailableIncomeMessages();
    }

    // **** WHEN's ****

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

    @Then("^I see number of incoming Email messages decreased accordingly$")
    public void iSeeNumberOfIncomingEmailMessagesDecreasedAccordingly() throws Throwable {
        Integer numberOfMessagesBefore = (Integer) ScenarioContext.get(ScenarioContext.ContextKey.INCOMING_MESSAGES_NUMBER);
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        if (numberOfMessagesBefore == 0){
            Await.waitUntil(() -> inboxPage.getNumberOfIncomingEmailMessages() == numberOfMessagesBefore);
            Assert.assertEquals(numberOfMessagesBefore,inboxPage.getNumberOfIncomingEmailMessages());
        } else {
            Await.waitUntil(() -> numberOfMessagesBefore - 1 == inboxPage.getNumberOfIncomingEmailMessages());
            Assert.assertTrue(numberOfMessagesBefore - 1 == inboxPage.getNumberOfIncomingEmailMessages());
        }
    }
}
