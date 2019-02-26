package mockito;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InOrder;
import org.mockito.Spy;
import org.mockito.Captor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(JUnitPlatform.class)
public class T_E_S_T_Mockito
{  
    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }
    
    @Mock
    ArrayList<String> mockList1 = new ArrayList();

    @Test
    public void testMockitoMocks()
    {
        //MockitoAnnotations.initMocks(this);
        
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
        
        ArrayList<String> mockList2 = mock(ArrayList.class);
        
        System.out.println("MockList2IsEmpty: " + mockList2.isEmpty());
        mockList2.add("SecondString");
        assertThat(mockList2.size(), is(0));
        mockList2.clear();
        
        when(mockList2.get(10)).thenReturn("Hello");
        assertThat(mockList2.size(), is(0));
        assertThat(mockList2.get(10).length(), is(5));
        assertThat(mockList2.get(10), is("Hello"));
        verify(mockList2).isEmpty();
        verify(mockList2, times(2)).get(10);
        
        verify(mockList2, atLeast(1)).get(10);
        verify(mockList2, atMost(3)).get(10);
        verify(mockList2, never()).clone();                
        verify(mockList2, never()).contains(anyString());
        verify(mockList2).add("SecondString");
        verify(mockList2).add(anyString());        

        mockList2.add("SomeString");
        mockList2.clear();
        mockList2.size();
        InOrder inOrder = inOrder(mockList2);
        inOrder.verify(mockList2).add("SomeString");
        inOrder.verify(mockList2).clear();
        inOrder.verify(mockList2).size();
    }
    
    @Spy
    ArrayList<String> spyArrayList = spy(new ArrayList());
    
    @Test
    public void testMockitoSpies()
    {
        ArrayList<String> spyList = spy(new ArrayList());
        
        System.out.println("SpyListIsEmpty: " + spyList.isEmpty());
        
        spyList.add("one");
        spyList.add("two");
        
        System.out.println("SpyListIsEmpty: " + spyList.isEmpty());
        
        assertThat(spyList.size(), is(2));
        
        doReturn(100).when(spyList).size();
        assertThat(spyList.size(), is(100));
        
        verify(spyList).add("one");
        verify(spyList).add("two");
    }
    
    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void testMockitoArgumentCaptor()
    {
        ArrayList<String> mockedList = mock(ArrayList.class);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        
        mockedList.add("MockedListElement1");
        mockedList.add("MockedListElement2");
        mockedList.add("MockedListElement3");
        
        verify(mockedList, times(3)).add(argumentCaptor.capture());
        
        System.out.println("ArgumentCaptorValue: " + argumentCaptor.getValue());
        System.out.println("ArgumentCaptorAllValues: " + argumentCaptor.getAllValues());
        
        assertThat(List.of("MockedListElement1", "MockedListElement2", "MockedListElement3"), is(argumentCaptor.getAllValues()));
    }
    
    @Test
    public void testMockitoMockCalendar()
    {
        Calendar mockCalendar = mock(Calendar.class);
                
        System.out.println("MockCalendarHour: " + mockCalendar.get(Calendar.HOUR));
        System.out.println("MockCalendarYear: " + mockCalendar.get(Calendar.YEAR));
        System.out.println("MockCalendarFirstDayOfWeek: " + mockCalendar.getFirstDayOfWeek());
        System.out.println("MockCalendarTime: " + mockCalendar.getTime());

        when(mockCalendar.get(Calendar.HOUR)).thenReturn(123456);
        when(mockCalendar.get(Calendar.YEAR)).thenReturn(987654);
        when(mockCalendar.getFirstDayOfWeek()).thenReturn(-58);
        when(mockCalendar.getTimeInMillis()).thenReturn(new GregorianCalendar(1834, 11, 11, 23, 34, 45).getTimeInMillis());
        
        System.out.println("MockCalendarHour: " + mockCalendar.get(Calendar.HOUR));
        System.out.println("MockCalendarYear: " + mockCalendar.get(Calendar.YEAR));
        System.out.println("MockCalendarFirstDayOfWeek: " + mockCalendar.getFirstDayOfWeek());
        System.out.println("MockCalendarTime: " + mockCalendar.getTime());
        
        assertThat(mockCalendar.get(Calendar.HOUR), is(123456));
        
        verify(mockCalendar, times(2)).getFirstDayOfWeek();
    }
}