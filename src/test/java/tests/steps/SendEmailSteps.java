package tests.steps;

import POJOs.EmailContent;
import base.ScenarioContext;
import base.TestSettings;
import cucumber.api.java.en.When;
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
}
