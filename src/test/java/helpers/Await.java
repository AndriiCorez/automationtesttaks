package helpers;

import base.TestSettings;
import org.awaitility.core.ConditionFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.with;

/**
 * Contains functionality for waiting any for conditions to be true
 * Default values for delay, interval are:
 * 100 milliseconds, 100 milliseconds
 */
public class Await {

    private static ConditionFactory withListener(){
        return with().conditionEvaluationListener(conditionListener -> System.out.println(conditionListener.getDescription() +
                "|elapsed:" + conditionListener.getElapsedTimeInMS() +
                "|remained:" + conditionListener.getRemainingTimeInMS()));
    }

    /**
     * Waits during the timeout specified as Custom wait in .properties settings until true output of
     * @param condition conditional statement
     */
    public static void waitUntil(Callable<Boolean> condition){
        withListener().
                await().
                atMost(TestSettings.getInstance().getWaitCustom(), TimeUnit.SECONDS).
                until(condition);
    }

    /**
     * Waits ignoring any thrown exceptions during the timeout specified as Custom wait in .properties settings until true output of
     * @param condition conditional statement
     */
    public static void waitUntilIgnoringExceptions(Callable<Boolean> condition){
        withListener().
                given().
                ignoreExceptions().
                await().
                atMost(TestSettings.getInstance().getWaitCustom(), TimeUnit.SECONDS).
                until(condition);
    }
}
