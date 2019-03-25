Feature: Adding

Scenario Outline: Add by one
Given the input <input>
When the calculator is run
Then the output should be <output>

Examples:
|input | output|
|4     | 5     | 
|14    |15     | 