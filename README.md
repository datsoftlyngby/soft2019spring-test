# Test

<hr>

## Course Book
"Developer Testing - Building Quality into Software" by Alexander Tarlinder <br>

[Available at Amazon.com](https://www.amazon.com/Developer-Testing-Building-Addison-Wesley-Signature/dp/0134291069) <br>

[See Author website](http://developertesting.rocks) 

<hr>

## Overall objectives of the course
To qualify the student to become a technical tester. <br>
To be able to assist with operational execution of test activities, primarily with focus on automated test. <br>
The profile is an integrated tester/developer profile, i.e. a developer with enhanced test skills where focus is on test and quality so that quality can be built into the code from the beginning. <br>
Testable code, code coverage, regression testing, technical reviews, frameworks for automated testing and test data generation are primary activities for the profile.

<hr>

## Learning objectives (General)

### Knowledge
The student must have knowledge of:

* Important test strategies and test models as well as their role in the systems development
* Test as an integral part of a development project
* Different test types and their applicability

### Skills
The student can:

* Ensure traceability between system demands and test at all levels
* Apply both black box and white box test techniques
* Apply various criteria for test coverage
* Apply techniques for both verification and validation
* Apply techniques and tools for the automation of different test types
* Construct system to manage the test and bug fixing process in development projects

### Competencies
The student can:
 
* Define, plan and execute tests in a development project that are suitable for the quality criteria of the project
* Plan and manage the implementation of internal as well as external test of a system
* Design testable systems

## Learning objectives (Specific for the course)

### Testing in Software Life Cycle 
-	Be able to compare different test types and their objectives (functional, non-functional, maintenance)
-	Be able to compare different test levels and their objectives (unit, integration, system, user acceptance)
-	Be able to use the Test Pyramid as a guideline to how much test automation to put into each test level.
-	Know the activities in a traditional test process (ISTQB 2011)
-	Know different roles involved in testing (Business Analyst/PO, Dev, Tester etc)
-	Be able to explain the principles and characteristics of agile testing 
-	Be able to explain testing objectives that critique and support software respectively (validation and verification)
-	Be able to explain the Agile Test Quadrants as part of a test strategy
-	Be able to discuss software quality from a test perspective

### Testability
-	Be able to describe the benefits of testable software
-	Be able to produce testable software
-	Be able to design software with Test-Driven Development – Classic Style and Mockist style
-	Use interfaces and apply dependency injection to make code more testable
-	Know the difference between mocks, stubs, fakes, spies and dummies and when to use them
-	Perform state testing and behavior testing
-	Be able to setup and use Mockito

### Test Case Design
- Be able to describe the purpose of equivalence partitioning and boundary value analysis in tests
-	Be able to apply equivalence partitioning and boundary value analysis in tests
-	Describe the benefits and construction of decision tables and state transition models in the context of test case design
-	Create and use decision tables and state transition models in tests
-	Explain the concept and need for data-driven testing and getting test data from files
-	Explain the purpose of test coverage and how to measure code coverage
-	Be able to use a code coverage tool such as JaCoCo
-	Be able to do structural test case design
-	Explain the importance and value of static test techniques
-	Be able to use static test tools such as CheckStyle for coding standards and JaCoCo/Source Code Metrics to calculate metrics such as cyclomatic complexity

### Unit Testing
-	Be able to design, structure, and automate unit tests
-	Know general features and usage of xUnit Framework API
-	Implement high quality automated tests with xUnit Framework
-	Perform repeated, parameterized and dynamic tests with uniform input values from different sources, such as arrays, lists and files
-	Explain the advantages and the disadvantages of different assertion libraries and using alternative matchers

### Integration Testing
-	Understand integration testing in general
-	Know different approaches to integration testing
-	Be able to handle production and test databases separately
-	Be able to automate integration tests using test databases, database testing frameworks, in-memory databases and mocking
-	Be able to test APIs (REST services) with tool like REST Assured

### System Testing
-	Know the difference between system testing and acceptance testing
-	Be able to capture requirements as system tests
-	Be able to automate system tests for web applications with Selenium 
-	Be able to do Behavior-Driven-Development with Gherkin to capture customer examples and Cucumber to run test scenarios against your system under test

### Functional Testing / Nonfunctional Testing
-	Know the difference between functional and nonfunctional testing
-	Know the different types of nonfunctional tests and the basic implications involved in nonfunctional testing
- Set up and execute different types of functional and non functional tests
- Be able to set up and execute a basic performance test
- Produce metrics regarding system performance

### Continuous Integration / Continuous Deployment
-	Know the difference between automated testing, test automation, continuous integration, delivery and deployment and DevOps principles
-	Be able to execute different tests separately using test suites and build goals, plugins, profiles and properties
-	Be able to test locally and remotely using a virtual machine image
-	Be able to deploy remotely using a virtual machine image
-	Set up an automation server capable of building, testing and deploying depending on test results

<hr>

## Study Points
You earn studypoints (SP) by completing a number of activities from the list below. <br>
There are 7 study point activities in total throughout the course. 

| Task                           | Hand-out      | Hand-in               | Study points|
|--------------------------------|:-------------:|:---------------------:|:----------:|
| Peer review 1     |  Ongoing | May 5 at 12:00 (noon)       | 10  |
| Peer review 2     |  Ongoing  |  May 5 at 12:00 (noon)    | 10  |
| Peer review 3     |  Ongoing  |  May 5 at 12:00 (noon)    | 10  |
| Peer review 4     |  Ongoing |  May 5 at 12:00 (noon)   | 10  |
| Semester project review 1    |   May 6 |  See time schedule  | 15  |
| Semester project review 2    |  May 13 |  See time schedule   | 15  |
| Semester project hand-in  |  April 8 |  May 24 at 12:00 (noon)   | 30  |

You can earn 100 study points for completing all the study point activities. <br>
It is a requirement, that you must earn at least 80 study points to be eligible for the exam.

<hr>

## Peer Reviews
Each student will have to review assignments from other students in order to earn study points for the peer reviews. <br>
Which students to review assignments for is predetermined and can be seen in the peer reviews list, where the student id for each review can be found. <br>
Each assignment can only be reviewed once and each completed review will result in 10 study points. <br>
Each student determines together with their reviewer which assignment to review and how to review the assignment. <br>
[Peer Reviews List](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Slides/Peer%20Reviews%20List.pdf)

### Hand-ins
Requirements in order to be accepted for study point approval....
* All reviews need to be uploaded **before May 5th noon (12:00:00)** in pdf format to the "Test Spring 2019" Moodle flow under “Peer Reviews” 
* Each review must be named **"student id being reviewed" + "_" + "assignment id being reviewed" + ".pdf"** <br>
_(Example: "23_6.pdf"   // Review of assignment 6 made by student with id 23...)_ <br>
_(Reviewer name will automatically be registered in moodle when uploading the pdf)_

### Evaluation Criteria
Each review should have an extent of approximately 2400 characters and should cover each of the following evaluation criteria to some extent.
* What was done well? Why?
* What could be improved? How?
* Overall, what did you think of the hand-in?
* What did you learn from this hand-in? Use this space for yourself, think about what you learned that you can use in the future.

### Peer grade system
Starting the 18th of March in week 12 and ending the 29th of April in week there will furthermore be the possibility each week, to hand in an assignment and doing a review with the peer grade system, apart from the Moodle option if this is preferred before the final deadline for the peer reviews is reached.

<hr>

## Assignments

| Assignment id | Assignment name | Assignment link |
|-------------|:-------------:|:-------------:|
| 1 |  Test cases  | [01 Test Cases Assignment](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/01%20Test%20cases%20assignment.pdf)
| 2 |  Unit testing  | [02 Unit Testing Assignment](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/02%20Unit%20Testing%20Assignment.pdf) |
| 3 |  Testability  |[03 Testability Assignment](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/03%20Testability%20assignment.pdf) |
| 4 |  Specification based testing techniques | [04 Specification Based Testing Techniques Assignment ](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/04%20Specification%20Based%20Testing%20Techniques%20Assignment.pdf) |
| 5 |  Dependencies  | [05 Dependencies Assignment ](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/05%20Dependencies%20Assignment.pdf) |
| 6 |  TDD  | [06 TDD Assignment ](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/06%20TDD%20assignment.pdf)|
| 7 |  Integration testing  | [07 Integration Testing Assignment](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/07%20Integration%20Testing%20Assignment.pdf)|
| 8 |  Functional testing  |[08 Functional Testing (Selenium) - see end of slide deck](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Slides/08%20Functional%20testing.pdf) |
| 9 |  Nonfunctional testing  |[09 Nonfunctional Testing](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/09%20Nonfunctional%20Testing%20Assignment.pdf) |
| 10 |  CI / CD  |[10 CI / CD](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/10%20CI%20CD%20Assignment.pdf) |

<hr>

## Semester project
The semester project will start the 29th of April in week 18 and end the 24th of May.
It must be completed in groups consisting 3 - 4 group members.
During the semester project period, the group must attend two group reviews of their project, in order to receive the study points given for them.

[Test Semester Project](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/TestSemesterProject.pdf)

<hr>

## Exam

### Admission criteria
The student must fulfil the mandatory learning activities 

### Examination form:  

* The exam consists of two short presentations (5 minutes each), followed by a discussion with the examiner and the censor. 

* Presentation 1 – Topic: 
The student draws a topic and makes a presentation based on the learning objectives and the assignments of the semester. 

* Presentation 2 – Semester project: 
The student presents a self-chosen topic based on the semester project.
 
### Assessment
One single grade is given according to the 7-point grading scale  
