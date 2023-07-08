Feature: Employee enters his profile and makes language changes

  @testcase2
  Scenario:Employee makes language changes
    #Given open the browser and launch HRMS application
    When employee enters valid email and valid password
    And click on login button
    When employee clicks on My Info button
    And employee clicks on Qualifications button
    And employee clicks on Add Languages button
    And employee selects language, fluency, competency and write comments
    And user clicks on save button
    #And user clicks on save button
    #And close the browser