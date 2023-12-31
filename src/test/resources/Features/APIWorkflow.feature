Feature: API workflow for HRMS

  Background:
    Given a JWT is generated
  @api
  Scenario: create the employee using API call
    Given a request is prepared to create the employee
    When a POST call is made to create the employee
    Then the status code for creating the employee is 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as the global variable to be used for other calls

  @apijsonworkflow
  Scenario: create the employee using API call
    Given a request is prepared to create the employee using json payload
    When a POST call is made to create the employee
    Then the status code for creating the employee is 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as the global variable to be used for other calls

  @apijsonworkflow
  Scenario: retrieve an employee using API call
    Given a request is prepared to get the created employee
    When a GET call is made to get the employee
    Then the status code for this employee is 200
    Then the employee data we get having id "employee.employee_id" must match with globally stored employee id
    Then the retrieved data at "employee" object matches with the data of created employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |john         |smith       |bob            |Male      |2022-02-24  |confirmed |SDET         |

  @apidynamic
  Scenario: create the employee using API call
    Given a request is prepared to create an employee with dynamic data "john" , "smith" , "bob" , "M" , "2022-02-24" , "Confirmed" , "SDET"
    When a POST call is made to create the employee
    Then the status code for creating the employee is 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as the global variable to be used for other calls

  @updateemployee
  Scenario: updating the employee via API call
    Given a request is prepared to update an employee
    When a PUT call is made to update an employee
    Then the status code of updated employee is 200