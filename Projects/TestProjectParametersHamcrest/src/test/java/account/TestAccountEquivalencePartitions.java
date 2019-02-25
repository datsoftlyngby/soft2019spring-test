package account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccountEquivalencePartitions
{
    Account account = new Account();
    double balance, percentage; 
    
    @Test
    public void testGetInterestNegative()
    {
        balance = -10;
        percentage = 0.00;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInterest3Percent()
    {
        balance = 50;
        percentage = 0.03;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInterest5Percent()
    {
        balance = 260;
        percentage = 0.05;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInterest7Percent()
    {
        balance = 1348;
        percentage = 0.07;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
}