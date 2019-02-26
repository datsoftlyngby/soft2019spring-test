package hamcrest;

import java.util.List;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.everyItem;

@RunWith(JUnitPlatform.class)
public class T_E_S_T_Hamcrest
{
    @Test
    public void testHamcrestBasics()
    {
        assertThat(2, is(2));
        assertThat("Hello", is(("Hello")));
        assertThat(2.00001, is(2.00001));
    }
    
    @Test
    public void testJUnit()
    {
        assertEquals(1, 2);
        assertEquals("Hello World", "Hello");
    }
    @Test
    public void testHamcrest()
    {
        assertThat(2, is(1));
        assertThat("Hello", is(("Hello World")));
    }
 
    List<String> names = List.of("Mads", "Linda", "Allan");
    @Test
    public void testJUnitList()
    {
        assertEquals(4, names.size());
        assertTrue(names.contains("Ulrik"));
    }
    @Test
    public void testHamcrestList()
    {
        assertThat(names, hasSize(4));
        assertThat(names, hasItem("Ulrik"));
    }

    List<Integer> numbers = List.of(1, 3, 4, 5, 6, 7);
    @Test
    public void testHamcrestCustomMatcher()
    {
        assertThat(numbers, everyItem(greaterThan(10)));
    }
}