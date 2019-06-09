package base;

import java.util.HashMap;

/**
 * Created by Andres on 6/7/2019.
 */
public class ScenarioContext {

    private static ScenarioContext instance = null;
    private ScenarioContext(){ scenarioContext = new HashMap();}
    static HashMap scenarioContext;

    public static ScenarioContext getInstance(){
        if (instance == null){
            instance = new ScenarioContext();
        }
        return instance;
    }

    public static void set(Object key, Object value) {
        getInstance();
        scenarioContext.put(key, value);
    }

    public static Object get(Object key){
        return scenarioContext.get(key);
    }

    public enum ContextKey{
        // Test
        DRIVER,
        // Pages
        LOGIN_PAGE, INBOX_PAGE
    }
}
