package helpers;

import base.TestSettings;

/**
 * Generates expected results test data
 */
public class AssertDataGenerator {

    /**
     * @return Part of the application Inbox page title
     */
    public static String getExpectedInboxTitle(){
        return TestSettings.getInstance().getSignInLogin() + " - Gmail";
    }

    /**
     * @return Application Inbox page URL
     */
    public static String getExpectedInboxURL(){
        return TestSettings.getInstance().getSignInUrl() + "#inbox";
    }
}
