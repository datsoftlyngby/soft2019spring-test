package cupcakeshop.database.mockito;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cupcakeshop.database.mapper.CakeMapper;
import entity.cupcakeshop.Cake;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitPlatform.class)
public class T_E_S_T_CakeMapper
{
    private static CakeMapper cakeMapper;
    
    @BeforeAll
    public static void beforeAll()
    {   
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        ResultSet resultSet = mock(ResultSet.class);
        
        try
        {
            when(dataSource.getConnection()).thenReturn(connection);
            when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(true);
            when(resultSet.getString("cupcakeName")).thenReturn("ChoccoNut").thenReturn("ChocolateNuts"); 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        cakeMapper = new CakeMapper();        
        cakeMapper.setDataSource(dataSource);
    }

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testCakeMapper()
    {
        System.out.println("testCakeMapper...");
        
        Cake cake = cakeMapper.getCakeById(1);
        assertThat(cake.getName(), is("ChoccoNut"));
        cake.setName("ChocolateNuts");
        cakeMapper.updateCake(cake);
        cake = cakeMapper.getCakeById(1);
        assertThat(cake.getName(), is("ChocolateNuts"));
    }
}