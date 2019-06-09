package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Andres on 6/7/2019.
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

    public String getSignInUrl(){
        return signInUrl;
    }

    public String getSignInLogin(){
        return signInLogin;
    }

    public String getSignInPassword(){
        return signInPassword;
    }

    public Integer getWaitPageLoad(){
        return waitPageLoad;
    }

    public Integer getWaitElementLoad(){
        return waitElementLoad;
    }

    public Integer getWaitCustom(){
        return waitCustom;
    }

    public String getDriverType(){
        return driverType;
    }

    public String getWindowSize(){
        return windowSize;
    }

    public String getChromeDriverPath() { return chromeDriverPath; }

    public String getScreenshotsPath() { return screenshotPath; }
}
