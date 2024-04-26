package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;
import utils.ReadLocators;

public class KayakHomePage extends BaseClass{
	ReadLocators rl = new ReadLocators();
	
	public void searchDestination(String city) throws InterruptedException {
		
		WebElement destination = driver.findElement(By.xpath(rl.getLocatorValue("dest_field")));
		destination.click();
		destination.sendKeys(city);
		Thread.sleep(2000);
		destination.sendKeys(Keys.ENTER);
		}
		
	public void fromDateSelection(String fDate) {	
		WebElement calender = driver.findElement(By.xpath(rl.getLocatorValue("calendar_field")));
		calender.click();
		
		List <WebElement> dates = driver.findElements(By.xpath(rl.getLocatorValue("dates_field")));
		for (WebElement we : dates) {
			if (we.getAttribute("aria-label").equals(fDate)) {
				System.out.println("Match");
				we.click();
				break;
				}
			}
		}
	
	public void toDateSelection(String toDate) {
		List <WebElement> dates = driver.findElements(By.xpath(rl.getLocatorValue("dates_field")));
		for (WebElement we : dates) {
			if (we.getAttribute("aria-label").equals(toDate)) {
				we.click();
				break;
			}
		}	
	}
	
	public void clickSearchBtn() {
		WebElement searchBtn = driver.findElement(By.xpath(rl.getLocatorValue("search_btn")));
		searchBtn.click();
	}
}