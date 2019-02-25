package junit5;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitPlatform.class)
public class TestSimpleJUnit5
{    
    @Test
    void testSimpleJUnit5()
    {
        System.out.println("SimpleJUnit5");
        assertTrue(true);
    }
}