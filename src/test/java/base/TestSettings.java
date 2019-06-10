package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Stores settings data stored in .properties file of the project
 */
public final class TestSettings {

    private static TestSettings instance = null;
    private static final String propertiesFilePath = "src/test/resources/test-settings.properties";
    private static final String settingsPrefix = "test-settings.";
    private static Properties properties;

    private static String getTestSettingsValue(String propertiesVariable) {
        return properties.getProperty(settingsPrefix + propertiesVariable);
    }

    private static Integer getTestSettingsIntegerValue(String propertiesVariable) {
        return Integer.parseUnsignedInt(properties.getProperty(settingsPrefix + propertiesVariable));
    }

    private static void initializeProperties(){
        instance.signInUrl = getTestSettingsValue("signInUrl");
        instance.signInLogin = getTestSettingsValue("signInLogin");
        instance.signInPassword = getTestSettingsValue("signInPassword");
        instance.waitPageLoad = getTestSettingsIntegerValue("waitPageLoad");
        instance.waitElementLoad = getTestSettingsIntegerValue("waitElementLoad");
        instance.waitCustom = getTestSettingsIntegerValue("waitCustom");
        instance.driverType = getTestSettingsValue("driverType");
        instance.windowSize = getTestSettingsValue("windowSize");
        instance.chromeDriverPath = getTestSettingsValue("chromeDriverPath");
        instance.screenshotPath = getTestSettingsValue("screenshotPath");
    }

    /**
     * @return an instance of the Settings or creates new one if instance is null
     */
    public static TestSettings getInstance(){
        if (instance == null){
            properties = new Properties();
            try {
                properties.load(new FileInputStream(propertiesFilePath));
            } catch (IOException e){
                System.out.println("ERROR occurred while loading properties file by path:" + propertiesFilePath + "\n" + e.toString());
                System.exit(-1);
            }

            instance = new TestSettings();
            initializeProperties();
        }
        return instance;
    }

    private String signInUrl;
    private String signInLogin;
    private String signInPassword;
    private Integer waitPageLoad;
    private Integer waitElementLoad;
    private Integer waitCustom;
    private String driverType;
    private String windowSize;
    private String chromeDriverPath;
    private String screenshotPath;

    /**
     * @return Application sign in page URL
     */
    public String getSignInUrl(){
        return signInUrl;
    }

    /**
     * @return Login to pass application sign in process
     */
    public String getSignInLogin(){
        return signInLogin;
    }

    /**
     * @return Password to pass application sign in process
     */
    public String getSignInPassword(){
        return signInPassword;
    }

    /**
     *
     * @return Timeout value in seconds for web page to load
     */
    public Integer getWaitPageLoad(){
        return waitPageLoad;
    }

    /**
     * @return Timeout value in seconds for web elements to load on the web page
     */
    public Integer getWaitElementLoad(){
        return waitElementLoad;
    }

    /**
     * @return Timeout value in seconds for any custom waiting actions
     */
    public Integer getWaitCustom(){
        return waitCustom;
    }

    /**
     * @return Type of the Selenium Webdriver
     */
    public String getDriverType(){
        return driverType;
    }

    /**
     * @return Window size of the Web browser
     */
    public String getWindowSize(){
        return windowSize;
    }

    /**
     * @return File path for Selenium Webdriver executable in the system/project
     */
    public String getChromeDriverPath() { return chromeDriverPath; }

    /**
     * @return Directory path to store screenshots made on Scenario failure
     */
    public String getScreenshotsPath() { return screenshotPath; }
}
