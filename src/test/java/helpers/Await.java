package helpers;

import base.TestSettings;
import org.awaitility.core.ConditionFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.with;

/**
 * Created by Andres on 6/9/2019.
 */
public class Await {

    private static ConditionFactory withListener(){
        return with().conditionEvaluationListener(conditionListener -> System.out.println(conditionListener.getDescription() +
                "|elapsed:" + conditionListener.getElapsedTimeInMS() +
                "|remained:" + conditionListener.getRemainingTimeInMS()));
    }

    public static void waitUntil(Callable<Boolean> condition){
        withListener().
                await().
                atMost(TestSettings.getInstance().getWaitCustom(), TimeUnit.SECONDS).
                until(condition);
    }

    public static void waitUntilIgnoringExceptions(Callable<Boolean> condition){
        withListener().
                given().
                ignoreExceptions().
                await().
                atMost(TestSettings.getInstance().getWaitCustom(), TimeUnit.SECONDS).
                until(condition);
    }
}
