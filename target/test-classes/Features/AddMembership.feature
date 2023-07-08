Feature: Add Membership Functionalities (USER STORY 18)

  @Qualifications
  Scenario Outline:

    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully into the application
    Then user clicks on admin
    And selects Qualifications and selects Membership
    Then user clicks on add button and inserts valid "<name>"
    And admin clicks on save button
Examples:
  | name       |
  | goalkeeper |
  | defender   |
  | midfielder |
  | forward    |
