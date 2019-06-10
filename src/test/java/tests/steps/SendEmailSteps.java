package tests.steps;

import POJOs.EmailContent;
import base.ScenarioContext;
import base.TestSettings;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Await;
import org.testng.Assert;
import pages.ComposeEmailPage;
import pages.InboxPage;
import java.util.List;
import static helpers.AssertDataGenerator.getExpectedInboxTitle;

public class SendEmailSteps {

    // **** GIVEN's ****

    @Given("^I get current number of incoming email messages$")
    public void iGetCurrentNumberOfIncomingEmailMessages() throws Throwable {
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        Await.waitUntil(() -> inboxPage.getPageTitle().endsWith(getExpectedInboxTitle()));
        ScenarioContext.set(ScenarioContext.ContextKey.INCOMING_MESSAGES_NUMBER, inboxPage.getNumberOfIncomingEmailMessages());
    }

    // **** WHEN's ****

    @When("^I send the following email to same test Gmail account$")
    public void iSendTheFollowingEmailToSameTestGmailAccount(List<EmailContent> emailContents) throws Throwable {
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        ComposeEmailPage composePage = inboxPage.clickComposeEmailButton();
        composePage.sendEmailTo(TestSettings.getInstance().getSignInLogin(), emailContents.get(0));
        ScenarioContext.set(ScenarioContext.ContextKey.COMPOSE_EMAIL_PAGE, composePage);
    }

    @When("^I send the following email to same test Gmail account if there is no Email messages on the list$")
    public void iSendTheFollowingEmailToSameTestGmailAccountIfThereIsNoEmailMessagesOnTheList(List<EmailContent> emailContents) throws Throwable {
        Integer currentMessagesNumber = (Integer) ScenarioContext.get(ScenarioContext.ContextKey.INCOMING_MESSAGES_NUMBER);
        if (currentMessagesNumber == 0){
            iSendTheFollowingEmailToSameTestGmailAccount(emailContents);
        }
    }

    // **** THEN's ****

    @Then("^I can see new email with \"([^\"]*)\" subject appeared in incoming mail list$")
    public void iCanSeeNewEmailWithSubjectAppearedInIncomingMailList(String expectedSubject) throws Throwable {
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        Await.waitUntilIgnoringExceptions(() -> inboxPage.getIncomingEmailTitles().get(0).equals(expectedSubject));
        Assert.assertEquals(inboxPage.getIncomingEmailTitles().get(0), expectedSubject);
    }

    @Then("^I see popup message with \"([^\"]*)\" text on Inbox page$")
    public void iSeePopupMessageWithTextOnInboxPage(String expectedMessageTxt) throws Throwable {
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        Await.waitUntilIgnoringExceptions(() -> inboxPage.getPopupMessageTxt().equals(expectedMessageTxt));
        Assert.assertEquals(inboxPage.getPopupMessageTxt(), expectedMessageTxt);
    }

    @Then("^I see number of incoming Email messages changed by \"([^\"]*)\"$")
    public void iSeeNumberOfIncomingEmailMessagesChangedBy(Integer changedByValue) throws Throwable {
        Integer numberOfMessagesBefore = (Integer) ScenarioContext.get(ScenarioContext.ContextKey.INCOMING_MESSAGES_NUMBER);
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        Integer numberOfMessagesAfter = inboxPage.getNumberOfIncomingEmailMessages();
        if (changedByValue > 0) {
            Assert.assertTrue(numberOfMessagesAfter == (numberOfMessagesBefore + changedByValue));
        } else {
            Assert.assertTrue(numberOfMessagesAfter == numberOfMessagesBefore - changedByValue);
        }
    }
}
