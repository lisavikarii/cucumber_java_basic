@regression
Feature: task1.feature
      @debugs
      Scenario Outline: scenario outline for error cases
        Given Navigate to url "https://kristinek.github.io/site/tasks/enter_a_number"
        When I enter number : "<number>"
        And I click submit button
        Then I see error message: "<message>"
        @not_working
        Examples:
          | number  | message               |
          | 0       | Number is too small   |
          | 111     | Number is too big     |
          | six     | Please enter a number |

        Scenario Outline: scenario for correct numbers
          Given Navigate to url "https://kristinek.github.io/site/tasks/enter_a_number"
          When I enter a correct number : "<number>"
          And I click submit button
          Then I see alert message: "<message>"
          Examples:
          | number | message                   |
          | 66     | Square root of 66 is 8.12 |

          
          







      