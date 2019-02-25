package junit4;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner
{
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(T_E_S_T_JUnit4Suite_SuiteClass.class);

        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
        
        System.out.println(result.wasSuccessful());
    }
}
