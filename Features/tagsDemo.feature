
Feature: CRM test

@SmokeTest @RegressionTest @E2ETest
Scenario: Login scenario
Given Login scenario test
   
@SmokeTest
Scenario: Lead creation
Given Lead creation testing
   
Scenario: Account creation
Given Account creation testing steps
  
@SmokeTest
Scenario: Lead delete
Given I want to Lead delete
   
@E2ETest 
Scenario: Lead contacted
Given I want to write a step with precondition Lead contacted

@RegressionTest
Scenario: Account deleted
Given I want Account to be deleted

@SmokeTest
Scenario: Opportunity creation
Given Opportunity creation testing


Scenario: Lead to opportunity conversion
Given Lead to opportunity conversion

@SmokeTest
Scenario: Opportunity deleted
Given Opportunity deleted

@RegressionTest @E2ETest
Scenario: Logout step
Given I want to Logout from system
   