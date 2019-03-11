package cupcakeshop.database.dbunit;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import cupcakeshop.database.connector.DatabaseConnector;
import cupcakeshop.database.mapper.CakeMapper;
import entity.cupcakeshop.Cake;
import entity.cupcakeshop.Top;
import java.sql.Connection;
import java.io.FileInputStream;
import java.util.List;
import static org.dbunit.Assertion.assertEqualsIgnoreCols;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@RunWith(JUnitPlatform.class)
public class T_E_S_T_CakeMapper
{
    private static CakeMapper cakeMapper;
    
    private static DatabaseConnector dbc;
    private static Connection connection;
    private static IDatabaseConnection dbConnection;
    private static IDataSet xmlDataSet;
    private static QueryDataSet databaseDataSet;
    private static ITable xmlTable, databaseTable;

    @BeforeAll
    public static void beforeAll()
    {
        dbc = new DatabaseConnector();
        dbc.setDataSource(new DataSourceMysql().getDataSource());
    }
    
    @BeforeEach
    public void beforeEach()
    {
        try
        {
            connection = dbc.open();
            dbConnection = new DatabaseConnection(connection, "cupcakeshop_test");
            dbConnection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
            dbConnection.getConfig().setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());
        
            xmlDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("DATASETS/cupcakeshop_test.xml"));
            
            DatabaseOperation.CLEAN_INSERT.execute(dbConnection, xmlDataSet);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        cakeMapper = new CakeMapper();
        cakeMapper.setDataSource(new DataSourceMysql().getDataSource());
    }
    
    @AfterEach
    public void afterEach()
    {
        try
        {
            dbConnection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        dbc.close();
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
    
    @Test
    public void testCakeMapperGetAllTops() throws Exception
    {
        System.out.println("testCakeMapperGetAllTops...");
        
        List<Top> tops = cakeMapper.getAllTops();
        
        assertThat(tops.size(), is(5));        
        assertThat(tops.get(0).getName(), is("Chocolate"));        
        assertThat(tops.get(0).getPrice(), is(5.0));        
    }
    
    @Test
    public void testCakeMapperCreateTop1() throws Exception
    {
        System.out.println("testCakeMapperCreateTop1...");

        Top top = new Top();
        top.setName("Coconut");
        top.setPrice(8.0);
        cakeMapper.createTop(top);
        
        databaseDataSet = new QueryDataSet(dbConnection);
        databaseDataSet.addTable("cupcaketopping");
        databaseTable = databaseDataSet.getTable("cupcaketopping");
        
        assertThat(databaseTable.getValue(5, "price"), is(top.getPrice()));
    }
    
    @Test
    public void testCakeMapperCreateTop2() throws Exception
    {
        System.out.println("testCakeMapperCreateTop2...");

        Top top = new Top();
        top.setName("Coconut");
        top.setPrice(8.0);
        cakeMapper.createTop(top);
        
        databaseDataSet = new QueryDataSet(dbConnection);
        databaseDataSet.addTable("cupcaketopping");
        databaseTable = databaseDataSet.getTable("cupcaketopping");
        
        xmlDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("DATASETS/ToppingCreated.xml"));
        xmlTable = xmlDataSet.getTable("cupcaketopping");
        
        for(int row = 0; row < xmlTable.getRowCount(); row++)
        { 
            String column = "cupcakeToppingName";
    
            assertThat(databaseTable.getValue(row, column).toString(), is(xmlTable.getValue(row, column).toString()));
            
            column = "price";
            
            assertThat(databaseTable.getValue(row, column).toString(), is(xmlTable.getValue(row, column).toString()));
        }
    }
    
    @Test
    public void testCakeMapperCreateTop3() throws Exception
    {
        System.out.println("testCakeMapperCreateTop3...");

        Top top = new Top();
        top.setName("Coconut");
        top.setPrice(8.0);
        cakeMapper.createTop(top);
        
        databaseDataSet = new QueryDataSet(dbConnection);
        databaseDataSet.addTable("cupcaketopping");
        databaseTable = databaseDataSet.getTable("cupcaketopping");
        
        xmlDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("DATASETS/ToppingCreated.xml"));
        xmlTable = xmlDataSet.getTable("cupcaketopping");

        String[] ignoreColumns = {"idTopping"}; 
        assertEqualsIgnoreCols(xmlTable, databaseTable, ignoreColumns);
    }
}