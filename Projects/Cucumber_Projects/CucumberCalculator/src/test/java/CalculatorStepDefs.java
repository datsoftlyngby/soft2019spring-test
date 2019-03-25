
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.cucumbercalculator.Calculator;
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author TM
 */
public class CalculatorStepDefs {

    Calculator calc = new Calculator();
    int input;
    int result = 0;

    // Arrange - get input data from table
    @Given("^the input (\\d+)$")
    public void the_input(int input) {
        this.input = input;
    }

    // Act
    @When("^the calculator is run$")
    public void the_calculator_is_run() {
        result = calc.addOne(input);
    }

    //Assert - get expected result from table
    @Then("^the output should be (\\d+)$")
    public void the_output_should_be(int expectedResult) {
        assertEquals(expectedResult, result);

    }

}
