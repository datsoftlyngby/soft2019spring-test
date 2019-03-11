package database.connector;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector
{
    private DataSource dataSource;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DatabaseConnector()
    {
    }

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }
    
    public Connection open()
    {
        try
        {
            if(connection == null || connection.isClosed())
            {
                connection = dataSource.getConnection();

                return connection;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void close()
    {
        try
        {
            if(resultSet != null)
            {
                resultSet.close();
            }

            if(statement != null)
            {
                statement.close();
            }

            if(connection != null && !connection.isClosed())
            {
                connection.close();
                connection = null;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public PreparedStatement preparedStatement(String sql)
    {
        try
        {
            return connection.prepareStatement(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public PreparedStatement preparedStatement(String sql, int indicator)
    {
        try
        {
            return connection.prepareStatement(sql, indicator);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
}