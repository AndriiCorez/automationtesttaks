package base;

import java.util.HashMap;

/**
 * Created by Andres on 6/7/2019.
 */
public final class ScenarioContext {

    private static ScenarioContext instance = null;
    private  ScenarioContext(){ scenarioContext = new HashMap();}
    static HashMap scenarioContext;

    public static ScenarioContext getInstance(){
        if (instance == null){
            instance = new ScenarioContext();
        }
        return instance;
    }

    public static void set(Object key, Object value) {
        scenarioContext.put(key, value);
    }

    public static Object get(Object key){
        return scenarioContext.get(key.toString());
    }
}
