package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import base.BaseClass;
import utils.ReadLocators;


public class KayakSearchResultPage extends BaseClass{
	ReadLocators rl = new ReadLocators();
	
	public void priceSortingValidation() throws Exception {
			
		WebElement cheapestLink = driver.findElement(By.cssSelector(rl.getLocatorValue("cheapest_link_css")));
		cheapestLink.click();
		
		Thread.sleep(5000);
		
		List <WebElement> priceList = 
				driver.findElements(By.xpath(rl.getLocatorValue("prices_xpath")));
		Thread.sleep(2000);
		Reporter.log("The number of flight result in default view is : "+priceList.size());
				
		int priceListInt [] = new int[priceList.size()];
		
		for (int i =0;  i<priceList.size(); i++) {
			priceListInt[i] =  Integer.parseInt((priceList.get(i).getText().split(" ")[1]).replace(",", ""));	
		}
		
		boolean priceOrderCheck = true;
		
		for (int i =0; i<priceList.size()-1; i++) {
			if (priceListInt[i]>priceListInt[i+1]) {
				Reporter.log("The prices are NOT in increasing order : FAILED");
				priceOrderCheck = false;
			}
		}
		
		if(priceOrderCheck) {
			Reporter.log("The prices are in increasing order : PASSED");
		}
	}
}