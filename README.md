# QAFinalAssignment

## Scrum
### Sprint Backlog

| Task | Story Points | Progress |
| --- | :---: | :---: |
| Create Classes | 1 | Done |
| Implement CRUD Method for Survey | 2 | Done |
| Implement CRUD Methods for SurveyResponse | 2 | Done |
| Implement Calculations Methods on Survey Answers | 2 | Done |
| Add Test Coverage Metric to Project | 3 | Done |
| Add Team Version Control to Project | 1 | TODO |
| Add Review Checklist to Project | 1 | TODO |
| **Total Story Points for Sprint** | **12** |    |

### Task Estimaition

For Story points in the Sprint Backlog I used a points system between 1 and 5 to determine the size and difficulty of each task. 1 being the easiest the 5 being the most difficult. Any task that was a 5 would be broken down into smaller sub tasks, for example developing the code for this project woud have been a 5, but breaking it down into smaller blocks got each task down into a 1 or 2 point task. The tasks with 2 are more difficult than the tasks with 1 as they also involve developing tests for the code implemented. 

## Test Coverage Metric
Test Coverage is the degree of which a test suite covers the application code. To implement this I created unit tests for every method that I created in the Controller class. For each method I would create at least unit tests, one for getting the correct result and anothe for unit test for error handling. I created 36 unit tests for 17 methods.

The Code Coverage tool I decided to use is called Jacoco, however for one reason or another I could not get it to geneate the Test Coverage reports.

![Jacoco Failure](images/jacocofailure.jpg)

 So unfortuantly I could not use to generate test coverage, and had to resort to a more primative way to come up with a result, which I got off the this (website)[https://reqtest.com/testing-blog/test-coverage-metrics/].

![Test Coverage Formula](images/testcoverageformula.jpg)

Using the above formula, I calculate that the code in which I'm testing (Controller.java + Survey.java + SurveyResponse.java + Question.java) is 280 lines of code. and my ControllerTest.java class is 360 lines of code (This these numbers are leaving out the imports and other non-function lines of code). This gives me a Testing Coverage of 133%. However given the primitive calculation of this I would take the result with a pinch of salt. 

## Team Version Control

## Code Review Checklist