package tests.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(JUnitPlatform.class)
public class Selenium
{
    private static WebDriver driver;
    
    @BeforeAll
    static void beforeAll()
    {
        System.out.println("BeforeAll...");
        
         ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterAll
    static void afterAll()
    {
        System.out.println("AfterAll...");
                
        driver.quit();
    }  
    
    @Test
    public void IT_Selenium1() throws Exception
    {
        System.out.println("IT_Selenium1...");
        
        driver.get( "http://10.19.17.12:8080/TestProjectCICD" );
        
        String HeadingTop = driver.findElement(By.cssSelector("#HeadingTop")).getText();
        
        assertEquals("TestProjectCICD", HeadingTop);
    }
}