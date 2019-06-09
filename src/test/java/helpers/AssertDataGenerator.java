package helpers;

import base.TestSettings;

/**
 * Created by Andres on 6/9/2019.
 */
public class AssertDataGenerator {

    public static String getExpectedInboxTitle(){
        return TestSettings.getInstance().getSignInLogin() + " - Gmail";
    }

    public static String getExpectedInboxURL(){
        return TestSettings.getInstance().getSignInUrl() + "#inbox";
    }
}
