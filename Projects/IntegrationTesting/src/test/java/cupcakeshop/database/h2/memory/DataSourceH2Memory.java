package cupcakeshop.database.h2.memory;

import java.sql.SQLException;
import org.h2.jdbcx.JdbcDataSource;

public class DataSourceH2Memory
{
    private JdbcDataSource dataSource = new JdbcDataSource();
    
    public DataSourceH2Memory()
    {
        dataSource.setURL("jdbc:h2:mem:cupcakeshop;DB_CLOSE_DELAY=-1");
    }
    
    public JdbcDataSource getDataSource()
    {
        return dataSource;
    }
}