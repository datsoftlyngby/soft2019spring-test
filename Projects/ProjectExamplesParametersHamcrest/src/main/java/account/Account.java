package account;

public class Account
{
    private double balance;

    public Account()
    {
        balance = 0;
    }

    public Account(double b)
    {
        balance = b;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public double getInterest()
    {   
        return 0.0;
    }
    
    public double calculateYearlyInterest()
    {
        Account temp = new Account(balance);
        
        for(int month = 1; month <= 12; month++)
        {
            temp.setBalance(temp.getBalance() + temp.getInterest());
        }
        
        return temp.getBalance() - balance;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }    
}