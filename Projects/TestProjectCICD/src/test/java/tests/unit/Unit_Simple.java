package tests.unit;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitPlatform.class)
public class Unit_Simple
{    
    @Test
    void UT_Simple1()
    {
        System.out.println("UT_Simple1...");
        assertTrue(true);
    }
}