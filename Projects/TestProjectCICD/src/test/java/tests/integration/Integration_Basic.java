package tests.integration;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitPlatform.class)
public class Integration_Basic
{    
    @Test
    void IT_Basic1()
    {
        System.out.println("IT_Basic1...");
        assertTrue(true);
    }
}