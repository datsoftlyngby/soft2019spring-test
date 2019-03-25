
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

class SodaMachine {

    static final double PRICE = 1.5;

    static String getSoda(int amount) {
        if (amount >= PRICE) {
            return "soda";
        } else {
            return "nope";
        }
    }
}

public class StepDefinitions {

    private int account;
    private String actualAnswer;

    @Given("^I have \\$(\\d+) in my account$")
    public void i_have_$_in_my_account(int account) {
        this.account = account;
    }

    @When("^I wave my magic ring at the machine$")
    public void i_wave_my_magic_ring_at_the_machine() {
        actualAnswer = SodaMachine.getSoda(account);
    }

    @Then("^I should get a \"([^\"]*)\"$")
    public void i_should_get_a(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
