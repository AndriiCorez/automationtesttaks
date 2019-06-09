package tests.steps;

import POJOs.EmailContent;
import base.ScenarioContext;
import base.TestSettings;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Await;
import org.testng.Assert;
import pages.ComposeEmailPage;
import pages.InboxPage;

import java.util.List;

/**
 * Created by Andres on 6/7/2019.
 */
public class SendEmailSteps {

    // **** WHEN's ****

    @When("^I send the following email to same test Gmail account$")
    public void iSendTheFollowingEmailToSameTestGmailAccount(List<EmailContent> emailContents) throws Throwable {
        InboxPage inboxPage = (InboxPage) ScenarioContext.get(ScenarioContext.ContextKey.INBOX_PAGE);
        ComposeEmailPage composePage = inboxPage.clickComposeEmailButton();
        composePage.sendEmailTo(TestSettings.getInstance().getSignInLogin(), emailContents.get(0));
        ScenarioContext.set(ScenarioContext.ContextKey.COMPOSE_EMAIL_PAGE, composePage);
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

}
