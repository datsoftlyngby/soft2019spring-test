package account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccountStateTransitionModel
{
    @Test
    public void testWithdraw()
    {
        Account account = new Account(0);
        
        account.withdraw(50);
        
        assertEquals(-50, account.getBalance());
    }
    
    @Test
    public void testDeposit()
    {
        Account account = new Account(0);
        
        account.deposit(50);
        
        assertEquals(50, account.getBalance());
    }
    
    @Test
    public void testSwitchCoverage()
    {
        Account account = new Account(0);
        
        account.deposit(50);
        account.withdraw(50);
        
        assertEquals(0, account.getBalance());
    }
    
}