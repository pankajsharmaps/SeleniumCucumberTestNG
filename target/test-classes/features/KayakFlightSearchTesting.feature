Feature: Kayak Testing

  @Kayak @Functional
  Scenario Outline: Testing the flight search functionality of KAYAK travel website
    Given I am on Kayak Home Page
    When I perform flight search to destination <destination>
    And providing from date <fromDate> and to date <toDate>
    And click on search button
    Then Flight result page should be displayed.

    Examples: 
      | destination 	 | fromDate 			| toDate  			 |
      | Mumbai 	| 26 May, 2024			    | 27 May, 2024   |
      | Pune 		| 27 June, 2024 			  | 29 June, 2024  |