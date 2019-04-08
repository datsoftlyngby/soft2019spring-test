package tests.unit;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitPlatform.class)
public class Unit_Basic
{    
    @Test
    void UT_Basic1()
    {
        System.out.println("UT_Basic1...");
        assertTrue(true);
    }
}