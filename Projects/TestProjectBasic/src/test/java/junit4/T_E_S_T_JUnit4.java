package junit4;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class T_E_S_T_JUnit4
{
    @Before
    public void setUp()
    {
        System.out.println("SetUp...");
    }

    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("SetUpClass...");
    }

    @After
    public void tearDown()
    {
        System.out.println("TearDown...");
    }

    @AfterClass
    public static void tearDownClass()
    {
        System.out.println("TearDownClass...");
    }

    @Test
    public void testBoolean()
    {
        assertTrue(true);
    }

    @Test(expected = Exception.class) 
    public void testException() throws Exception
    {
        throw new Exception("Exception thrown...");
    }
}