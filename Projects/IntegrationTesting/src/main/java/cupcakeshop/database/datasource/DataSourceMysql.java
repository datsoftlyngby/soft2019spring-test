package cupcakeshop.database.datasource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceMysql
{
    private MysqlDataSource dataSource = new MysqlDataSource();
    
    public DataSourceMysql()
    {
        try
        {
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("cupcakeshop_PRODUCTION");
            dataSource.setUser("root");
            dataSource.setPassword("admin");
            dataSource.setUseSSL(false);
            dataSource.setAllowMultiQueries(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}