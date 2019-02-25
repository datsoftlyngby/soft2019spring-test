package account;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.RepetitionInfo;

@DisplayName("RepeatedTests")
public class TestAccountRepeatedTests
{
    @RepeatedTest(value = 3)
    @DisplayName("RepeatingTest")
    void getBalance()
    {
        Account account = new Account(5000);
        double expected = 350.00;
        
        assertEquals(expected, account.getInterest(), 0.0001);
    }
    
    List<Account> accounts = new ArrayList<>(
        Arrays.asList(
            new Account(999.99), 
            new Account(1000.00), 
            new Account(999999.99)
        ));
    
    List<Double> interests = new ArrayList<>(Arrays.asList(49.9995, 70.0, 69999.9993));

    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("RepeatingTest")
    void getInterest(TestInfo testInfo, RepetitionInfo repetitionInfo)
    {
        int index = repetitionInfo.getCurrentRepetition() - 1;
        
        Account account = accounts.get(index);
        double interest = interests.get(index);
            
        assertEquals(interest, account.getInterest(), 0.0001);
    }
}