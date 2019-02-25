package account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccountBoundaryValues
{
    Account account = new Account();
    double balance, percentage;

    @Test
    public void testGetInterestNegativeRightBound()
    {
        balance = -0.01;
        percentage = 0.00;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInterest3LeftBound()
    {
        balance = 0.00;
        percentage = 0.03;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInterest3RightBound()
    {
        balance = 100.00;
        percentage = 0.03;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInterest5LeftBound()
    {
        balance = 100.01;
        percentage = 0.05;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInterest5RightBound()
    {
        balance = 999.99;
        percentage = 0.05;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInterest7LeftBound()
    {
        balance = 1000.00;
        percentage = 0.07;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInterest7RightBound()
    {
        balance = 999999.99;
        percentage = 0.07;
        
        account.setBalance(balance);
        
        double expResult = balance * percentage;
        double result = account.getInterest();
        assertEquals(expResult, result);
    }
}