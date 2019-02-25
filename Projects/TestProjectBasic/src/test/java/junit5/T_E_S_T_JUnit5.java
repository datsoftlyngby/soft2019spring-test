package junit5;

import static java.time.Duration.ofSeconds;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@RunWith(JUnitPlatform.class)
@Tag("JUnit5")
@DisplayName("TestClass")
@TestMethodOrder(OrderAnnotation.class)
public class T_E_S_T_JUnit5
{    
    @BeforeAll
    static void beforeAll()
    {
        System.out.println("Before all tests");
    }

    @BeforeEach
    void beforeEach()
    {
        System.out.println("Before each test");
    }

    @AfterEach
    void afterEach()
    {
        System.out.println("After each test");
    }

    @AfterAll
    static void afterAll()
    {
        System.out.println("After all tests");
    }
    
    @Test
    @Disabled
    void failingTest()
    {
        fail("Failing on purpose");
    }
    
    @Test
    @Tag("JUnit5")
    @Order(1)
    @DisplayName("Test of contained spaces")
    void spacesContainedTest()
    {
        assertEquals("   ", "   ", "Spaces not contained");
    }
    
    @Test
    @Order(0)
    void differentAssertionsTest()
    {
        assertEquals(1.23, 1.23, "Was not equal");
        assertEquals(123, 123, "Was not equal");
        assertEquals("SameString", "SameString", "Was not equal");
        assertNotEquals("SameString", "NotSameString", "Was equal");
        assertSame("SameString", "SameString", "Was not same");
        assertNotSame(" ", "", "Was same");
        assertTrue(true, "Was not true");
        assertFalse(false, "Was not false");
        assertNull(null, "Was not null");
        assertNotNull("", "Was null");
        
        String s1 = new String("SameString");
        String s2 = new String("SameString");
        assertEquals(s1, s2, "Was not equal");
        assertSame(s1, s2, "Was not same");
        assertNotSame(s1, s2, "Was not same");
    }
    
    @Test
    void assumptionTest()
    {
        assumeTrue( false );        
        assertEquals("SameString", "SSameString", "Was not equal");
    }
    
    @Test
    @Tag("SeveralAssertions")
    void severalAssertionsTest()
    {
        int[] numbers = {0, 1, 2, 3, 4};
        
        assertEquals(numbers[0], 1);
        assertEquals(numbers[3], 3);
        assertEquals(numbers[4], 4);
    }
    
    @Test
    @Tag("SeveralAssertions")
    void severalAssertionsAllTest()
    {
        int[] numbers = {0, 1, 2, 3, 4};
        
        assertAll("NumbersInArrayPosition",
        () -> assertEquals(1, numbers[0]),
        () -> assertEquals(3, numbers[3]),
        () -> assertEquals(4, numbers[4]));
    }
    
    @Test
    public void lambdasTest()
    {
        assertTrue(true);
        
        assertTrue(true, "");
                
        assertTrue(false, 
                () -> 
                {
                    System.out.println("Execute some code before returning");
                    return "Hello";
                } 
        );
    }
    
    @Test
    public void indexOutOfBoundsExceptionTest()
    {
        //Throwable noException = assertThrows(IndexOutOfBoundsException.class, () -> {} );
                
        Throwable exception = assertThrows(IndexOutOfBoundsException.class,
            () -> { throw new IndexOutOfBoundsException("Index out of bounds"); }
        );
        System.out.println(exception.getMessage());
    }
    
    @Test
    public void timeoutTest()
    {
        assertTimeout(ofSeconds(5), 
                () -> {
                    new Thread().sleep(8000);
                }, "Timed out"
        );        
    }
    
    @Test
    public void timeoutPreemptivelyTest()
    {
        assertTimeoutPreemptively(ofSeconds(5), 
                () -> {
                    new Thread().sleep(100000);
                }, "Timed out preemptively"
        );      
    }
    
    @TestFactory
    public Collection<DynamicTest> dynamicTest()
    {
        List<String> input = new ArrayList<>(Arrays.asList("Hello", "Yes", "No"));
        List<String> output = new ArrayList<>(Arrays.asList("Hello", "Yes", "No"));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i = 0; i < input.size(); i++)
        {
            String in = input.get(i);
            String out = output.get(i);
            
            Executable exec = () -> assertEquals(out, in);
            String testName = "TestInputOutput" + i;
            DynamicTest dynamicTest = DynamicTest.dynamicTest(testName, exec);
            dynamicTests.add(dynamicTest);
        }
        
        return dynamicTests;
    }
    
    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection()
    {
        return Arrays.asList(
            DynamicTest.dynamicTest("1st dynamic test", () -> assertTrue(2==2)),
            DynamicTest.dynamicTest("2nd dynamic test", () -> assertEquals("ABC", "ABC"))
        );
    }
    
    @ParameterizedTest
    @ValueSource(strings={"racecar", "radar", "able was I ere I saw elbar"})
    void testStrings(String string)
    {
        assertTrue(string.endsWith("r"));
    }
    
    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo)
    {
        assertEquals(5,repetitionInfo.getTotalRepetitions());
    }
}