
Feature: Rotten totamo testing

  
Scenario Outline: Rotten tomato login
  Given I am on rotten tomato page
  When I click on LOG IN btn
  And Provide <EmailAddress> and <Password>
  And click on LOGIN btn
  Then I should be able to login
  

Examples: 
  | EmailAddress  | Password  |   
  | abc					  | 123			  |
  | Pan					  | xyz			  |
  | Ram					  | Pass@123  |