
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import static junit.framework.Assert.assertEquals;

public class CalculatorStepDefs {

    int input;
    int result = 0;
    int sum = 0;
    private List<Integer> numbers;

    @Given("^a list of numbers$")
    public void the_input(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // Act
    @When("^I summarize them$")
    public void the_calculator_is_run() {
        for (Integer number : numbers) {
            sum += number;
        }
    }

    @Then("^should I get (\\d+)$")
    public void the_output_should_be(int expectedSum) {

        assertEquals(expectedSum, sum);

    }
}
