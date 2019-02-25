package creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCreditCardDecisionTable
{
    @Test
    public void testGetDiscountTTT()
    {
        CreditCard creditCard = new CreditCard(true, true, true);

        int expResult = 0;
        int result = creditCard.getDiscount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDiscountTTF()
    {
        CreditCard creditCard = new CreditCard(true, true, false);

        int expResult = 0;
        int result = creditCard.getDiscount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDiscountTFT()
    {
        CreditCard creditCard = new CreditCard(true, false, true);

        int expResult = 20;
        int result = creditCard.getDiscount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDiscountTFF()
    {
        CreditCard creditCard = new CreditCard(true, false, false);

        int expResult = 15;
        int result = creditCard.getDiscount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDiscountFTT()
    {
        CreditCard creditCard = new CreditCard(false, true, true);

        int expResult = 30;
        int result = creditCard.getDiscount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDiscountFTF()
    {
        CreditCard creditCard = new CreditCard(false, true, false);

        int expResult = 10;
        int result = creditCard.getDiscount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDiscountFFT()
    {
        CreditCard creditCard = new CreditCard(false, false, true);

        int expResult = 20;
        int result = creditCard.getDiscount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDiscountFFF()
    {
        CreditCard creditCard = new CreditCard(false, false, false);

        int expResult = 0;
        int result = creditCard.getDiscount();
        assertEquals(expResult, result);
    }
}