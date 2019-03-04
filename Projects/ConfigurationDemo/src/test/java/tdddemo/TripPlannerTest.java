package tdddemo;

import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InOrder;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
/**
 *
 * @author TM
 */
@RunWith(JUnitPlatform.class)
public class TripPlannerTest {

     @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }
    
//     @Test
//     public void hello2() {
//         ConstructorBasedTripPlanner tp = new ConstructorBasedTripPlanner();
//         tp.planTrip("ss", "s1", "s2", null);
//         assertTrue(true);
//         assertEquals("abc", "abc");
//     }
     
    @Test
    void assumptionTest()
    {
        assumeTrue( false );        
        assertEquals("SameString", "SSameString", "Was not equal");
    }
    
    @Test
    public void testHamcrestBasics() {
        assertThat(2, is(2));
        assertThat("Hello", is(("Hello")));
        assertThat(2.00001, is(2.00001));
    }
    
    @Mock
    ArrayList<String> mockList1 = new ArrayList();
    
     @Test
    public void testMockitoMocks()
    {
        System.out.println("MockList1IsEmpty: " + mockList1.isEmpty());
        mockList1.add("FirstString");
        assertThat(mockList1.size(), is(0));
        mockList1.clear();
        
        when(mockList1.get(10)).thenReturn("Hello");
        assertThat(mockList1.size(), is(0));
        assertThat(mockList1.get(10).length(), is(5));
        assertThat(mockList1.get(10), is("Hello"));
        verify(mockList1).isEmpty();
        verify(mockList1, times(2)).get(10);
        
        /*
        MockitoAnnotations.initMocks(this);
        ArrayList<String> mockList2 = mock(ArrayList.class);
        when(mockList2.get(10)).thenReturn("Hello");
        assertThat(mockList2.size(), is(0));
        assertThat(mockList2.get(10).length(), is(5));
        assertThat(mockList2.get(10), is("Hello"));
        verify(mockList2).isEmpty();
        verify(mockList2, times(2)).get(10);
        */
        
        verify(mockList1, atLeast(1)).get(10);
        verify(mockList1, atMost(3)).get(10);
        verify(mockList1, never()).clone();                
        verify(mockList1, never()).contains(anyString());
        verify(mockList1).add("FirstString");
        verify(mockList1).add(anyString());        

        mockList1.add("SomeString");
        mockList1.clear();
        mockList1.size();
        InOrder inOrder = inOrder(mockList1);
        inOrder.verify(mockList1).add("SomeString");
        inOrder.verify(mockList1).clear();
        inOrder.verify(mockList1).size();
    }
    
}
