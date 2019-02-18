package account;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccountDynamicTests
{
    Account account = new Account();    
    double balance, percentage, expected;
        
    @TestFactory
    public List<DynamicTest> dynamicTest()
    {
        List<Double> balances = new ArrayList<>(Arrays.asList(999.99, 1000.00, 999999.99));
        List<Double> percentages = new ArrayList<>(Arrays.asList(0.05, 0.07, 0.07));

        List<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i = 0; i < balances.size(); i++)
        {
            balance = balances.get(i);
            percentage = percentages.get(i);
            
            account.setBalance(balance);
            expected = balance * percentage;
            
            Executable exec = () -> assertEquals(expected, account.getInterest());
            String testName = "DynamicTestgetInterest" + i;
            DynamicTest dynamicTest = DynamicTest.dynamicTest(testName, exec);
            dynamicTests.add(dynamicTest);
        }
        
        return dynamicTests;
    }
}