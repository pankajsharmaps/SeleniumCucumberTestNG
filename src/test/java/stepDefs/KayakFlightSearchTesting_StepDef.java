package stepDefs;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.KayakHomePage;
import pageObjects.KayakSearchResultPage;

public class KayakFlightSearchTesting_StepDef extends BaseClass{

	KayakHomePage khp = new KayakHomePage();
	KayakSearchResultPage ksr = new KayakSearchResultPage();
	
	@Given("^I am on Kayak Home Page$")
	public void i_am_on_kayak_home_page() throws Exception {
		BaseClass.initialization();
		driver.get("http://kayak.co.in");
		BaseClass.takeSS();
	}

	@When("^I perform flight search to destination (\\w+)$")
	public void i_perform_flight_search_to_destination(String city) throws InterruptedException, IOException {
		System.out.println(city);
		khp.searchDestination(city);
		BaseClass.takeSS();
	}

	@When("^providing from date (.*?) and to date (.*?)$")
	public void providing_from_date_and_to_date(String fDate, String toDate) throws IOException {
		System.out.println(fDate);
		khp.fromDateSelection(fDate);
		khp.toDateSelection(toDate);
		BaseClass.takeSS();
	}

	@When("^click on search button")
	public void click_on_search_button() {
		System.out.println("Searching");
		khp.clickSearchBtn();
	}

	@Then("^Flight result page should be displayed.$")
	public void flight_result_page_should_be_displayed() throws Exception {
		ksr.priceSortingValidation();
		BaseClass.takeSS();
		BaseClass.tearDown();
	}
}
