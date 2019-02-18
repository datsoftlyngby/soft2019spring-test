package hamcrest;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import org.junit.jupiter.api.Disabled;

public class TestHamcrest
{
    @Disabled
    @Test
    public void testJUnit()
    {
        assertEquals(1, 2);
        assertEquals("Hello World", "Hello");
    }
    @Disabled
    @Test
    public void testHamcrest()
    {
        assertThat(2, is(1));
        assertThat("Hello", is(("Hello World")));
    }
 
    List<String> names = Arrays.asList("Mads", "Linda", "Allan");
    @Test
    @Disabled
    public void testJUnitList()
    {
        assertEquals(4, names.size());
        assertTrue(names.contains("Ulrik"));
    }
    @Test
    @Disabled
    public void testHamcrestList()
    {
        assertThat(names, hasSize(4));
        assertThat(names, hasItem("Ulrik"));
    }

    List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 6, 7);
    @Disabled
    @Test
    public void testHamcrestCustomMatcher()
    {
        assertThat(numbers, everyItem(greaterThan(10)));
    }
}