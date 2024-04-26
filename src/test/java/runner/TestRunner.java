 package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
		features="src/test/resources/features",
		glue= {"stepDefs"},	
		dryRun = false,
		monochrome = true,
		tags = "@Trivago",
		plugin= {"pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"html:target/cucumber-reports/cucumber-pretty"}
		)



public final class TestRunner extends AbstractTestNGCucumberTests {
	
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpCucumber() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
		
//	@BeforeMethod(alwaysRun = true)
//	public void setUpClass() throws Exception {}	
	
	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}
}
