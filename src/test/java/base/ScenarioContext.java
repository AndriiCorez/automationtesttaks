package base;

import java.util.HashMap;

/**
 * Stores any objects during scenario run
 */
public class ScenarioContext {

    private static ScenarioContext instance = null;
    private ScenarioContext(){ scenarioContext = new HashMap();}
    static HashMap scenarioContext;

    /**
     * @return an instance of the Context or creates new one if instance is null
     */
    public static ScenarioContext getInstance(){
        if (instance == null){
            instance = new ScenarioContext();
        }
        return instance;
    }

    /**
     * Stores object by
     * @param key any object used as a Key in HashMap
     * @param value any object used as a Value in HashMap
     */
    public static void set(Object key, Object value) {
        getInstance();
        scenarioContext.put(key, value);
    }

    /**
     * @param key any object used as a Key in HashMap
     * @return stored object
     */
    public static Object get(Object key){
        return scenarioContext.get(key);
    }

    /**
     * Custom Keys for storing and retrieving objects in the Context
     */
    public enum ContextKey{
        // Test
        DRIVER,
        // Pages
        LOGIN_PAGE, INBOX_PAGE, COMPOSE_EMAIL_PAGE,
        // Test data
        INCOMING_MESSAGES_NUMBER
    }
}
