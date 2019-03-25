package cucumberselenium;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    WebDriver driver;
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginFormLocator = By.id("login");
    By successMessageLocator = By.cssSelector(".flash.success");
    By failureMessageLocator = By.cssSelector(".flash.error");

    @Given("^user navigates to the-internet.herokuapp.com/login$")
    public void navigatePage() {
        System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @When("^user logs in using Username as \"([^\"]*)\"$")
    public void user_logs_in_using_Username_as(String username) throws Exception {
        driver.findElement(usernameLocator).sendKeys(username);
        System.out.println("Username is: " + username);
    }

    @When("^password as \"([^\"]*)\"$")
    public void password_as(String password) throws Exception {
        System.out.println("Password is:" + password);
        driver.findElement(passwordLocator).sendKeys(password);
    }

    @Then("^login should be successful$")
    public void login_should_be_successful() throws Exception {
        System.out.println("Submit");
        driver.findElement(loginFormLocator).submit();
    }

    @Then("^Home page should be displayed$")
    public void home_page_should_be_displayed() throws Exception {
        System.out.println("Login succeeded");
        assertTrue("success message not present", driver.findElement(successMessageLocator).isDisplayed());
        driver.quit();

    } 

  
}
