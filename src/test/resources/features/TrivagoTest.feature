
Feature: Test Trivago

  @Trivago @Functional
  Scenario: Test Trivago search functionality
    Given I am on Trivago home page
    When I search for hotel
    Then I should get search result