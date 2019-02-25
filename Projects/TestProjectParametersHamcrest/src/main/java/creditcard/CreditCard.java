package creditcard;

public class CreditCard
{
    boolean newCustomer, loyaltyCard, coupon;

    public CreditCard()
    {
    }
    
    public CreditCard(boolean nc, boolean lc, boolean c)
    {
        newCustomer = nc;
        loyaltyCard = lc;
        coupon = c;
    }

    public int getDiscount()
    {
        return 0;
    }
}
