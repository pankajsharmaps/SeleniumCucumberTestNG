
Feature: Search Google


  Scenario: Perform search
    Given I am on google home page
    When I perform a search
    Then Search result should come
