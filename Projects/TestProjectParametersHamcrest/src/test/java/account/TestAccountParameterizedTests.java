package account;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ParameterizedTests")
public class TestAccountParameterizedTests
{    
    @DisplayName("ParameterizedTestValueSource")
    @ParameterizedTest(name = "Number: {index} - Account with values \"{0}\" should be {1}")
    @ValueSource(strings = {"999.99,49.9995", "1000.00,70.0", "999999.99, 69999.9993"} )
    void parameterizedTestValueSource(String values)
    {
        double balance = Double.parseDouble(values.split(",")[0]);        
        double expected = Double.parseDouble(values.split(",")[1]);        
        
        Account account = new Account(balance);
        
        assertEquals(expected, account.getInterest(), 0.0001);
    }
    
    @DisplayName("AccountParameterizedTest")
    @ParameterizedTest
    @MethodSource("parameters")
    void accountParameterizedTest(double balance, double expected)
    {
        Account account = new Account(balance);
        
        assertEquals(expected, account.getInterest(), 0.0001);
    }

    public static Collection<Object[]> parameters()
    {
        return Arrays.asList(new Object[][]
        {
            { 999.99, 49.9995 }, 
            { 1000.00, 70.0 }, 
            { 999999.99, 69999.9993 }
        });
    }
}