package stepDefs;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TrivagoHomePage;

public class TrivagoTestStepDefs extends BaseClass{
	TrivagoHomePage thp = new TrivagoHomePage(); 

	@Given("^I am on Trivago home page$")
	public void i_am_on_trivago_home_page() throws Throwable {			
	    System.out.println("User is on home page");	   
	    BaseClass.initialization();
	    driver.get("http://trivago.com");
	    BaseClass.takeSS();
	}
	
	@When("^I search for hotel$")
	public void i_search_for_hotel() throws Throwable {
		System.out.println("Searching hotels");
		System.out.println(driver.getCurrentUrl());
//		thp.searchCity("Dehradun");
//		thp.checkInDt("2022-09-15");
//		thp.checkOutDt("2022-09-17");
//		thp.searchClick();
	}

	@Then("^I should get search result$")
	public void i_should_get_search_result() throws Throwable {
		System.out.println("Hotel results");
		BaseClass.tearDown();
	}
}