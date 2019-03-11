package cupcakeshop.database.h2.embedded;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.h2.tools.DeleteDbFiles;
import cupcakeshop.database.connector.DatabaseConnector;
import cupcakeshop.database.mapper.CakeMapper;
import entity.cupcakeshop.Cake;

@RunWith(JUnitPlatform.class)
public class T_E_S_T_CakeMapper
{
    private static CakeMapper cakeMapper;
    
    private static String sqlStatements = "";
    
    @BeforeAll
    public static void beforeAll()
    {  
        BufferedReader sqlScript;
        try
        {
            sqlScript = new BufferedReader(new InputStreamReader(new FileInputStream("SQL/cupcakeshop_h2.sql"), "UTF-8"));
            
            String sqlStatement;
            while ((sqlStatement = sqlScript.readLine()) != null)
            {
                sqlStatements += sqlStatement;
            }
        
            DatabaseConnector dbc = new DatabaseConnector();
            dbc.setDataSource(new DataSourceH2Embedded().getDataSource());
            dbc.open();
            dbc.preparedStatement(sqlStatements).executeUpdate();
            dbc.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        cakeMapper = new CakeMapper();        
        cakeMapper.setDataSource(new DataSourceH2Embedded().getDataSource());
    }
    
    @AfterAll
    public static void afterAll()
    {
        DeleteDbFiles.execute("./", "cupcakeshop", true);
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