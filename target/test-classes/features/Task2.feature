@regression

  Feature: list of people with jobs
    
    Scenario: Add a new person with job
      Given Navigate to People with jobs url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
      When I click add Person button
      And I fill in name "Lisa" and job "QA"
      And I click Add button
      Then I check that new person appeared in the list

      Scenario: Edit a person
        When Navigate to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
        And I click on first person pencil-editor
        And I change the name of first person to "Michael"
        And I change the job of first person to "Student"
        And I click on edit button
        Then I check that the list contains a person with changed credentials

        Scenario: Remove a person
          When Navigate to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
          And I click on second person remove sign
          Then I check that removed person is not in updated list

          Scenario: reset original list after adding a person
            When Navigate to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
            And I click add Person button
            And I fill in name "Lisa" and job "QA"
            And I click Add button
            And I check that new person appeared in the list
            And I click to reset the list
            Then I check that list looks like before changes

            Scenario: reset original list after editing a person
              When Navigate to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
              And I click on first person pencil-editor
              And I change the name of first person to "Michael"
              And I change the job of first person to "Student"
              And I click on edit button
              And I check that the list contains a person with changed credentials
              And I click to reset the list
              Then I check that list doesn't has edited person

              Scenario: reset original list after removing a person
                When Navigate to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
                And I click on second person remove sign
                And I check that removed person is not in updated list
                And I click to reset the list
                Then I check that list became original



            Scenario: check that clear button on adding a user works correctly
              When Navigate to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
              And I click add Person button
              And I fill in name "Lisa" and job "QA"
              And I click clear all fields button
              Then I check that all fields are empty













