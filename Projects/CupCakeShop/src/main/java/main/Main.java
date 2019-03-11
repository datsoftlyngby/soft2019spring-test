package main;

import database.datasource.DataSourceMysql;
import database.mapper.CakeMapper;
import entity.Cake;

public class Main
{
    private static CakeMapper cakeMapper;
    
    public static void main(String[] args)
    {
        cakeMapper = new CakeMapper();        
        cakeMapper.setDataSource(new DataSourceMysql().getDataSource());

        Cake cake = cakeMapper.getCakeById(1);
        
        System.out.println("CAKE: " + cake);
    }
}
