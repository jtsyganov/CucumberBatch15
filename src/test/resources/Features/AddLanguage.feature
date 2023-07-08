Feature: Add Language Functionalities (USER STORY 16)

  @Language
  Scenario Outline:

    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully into the application
    Then user clicks on admin
    And selects Qualifications and selects Languages
    Then user clicks on add language button and inserts valid "<language>"
    And admin clicks on save button
    Examples:
      | language       |
      | english |
      | spanish   |
      | ukrainian |
      | dutch  |