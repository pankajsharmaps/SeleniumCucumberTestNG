package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;


public class TrivagoHomePage extends BaseClass{
	
	String SEARCH_CITY_ID = "input-auto-complete";
	String CHECK_IN_OUT_DATE_XPATH = "//*[@class='DatePicker_calendarMonth__QzjFe']//child::time";
	String SEARCH_BTN_XPATH = "//button[@type='submit']";
	
	public void searchCity(String city) throws InterruptedException {
		driver.findElement(By.id(SEARCH_CITY_ID)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(SEARCH_CITY_ID)).sendKeys(city);;
	}
	
	public void enterHotelOrDest(String city) throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.findElement(By.id(SEARCH_CITY_ID)).sendKeys(city);
		Thread.sleep(2000);
		driver.findElement(By.id(SEARCH_CITY_ID)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}
	
	public void checkInDt(String checkInDt) throws InterruptedException {
		List <WebElement> dateList = driver.findElements(By.xpath(CHECK_IN_OUT_DATE_XPATH));
		for (int i=0; i<dateList.size(); i++) {
			if (checkInDt.equals(dateList.get(i).getAttribute("datetime").toString())) {
				dateList.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	
	public void checkOutDt(String checkOutDt) throws InterruptedException {
		List <WebElement> dateList = driver.findElements(By.xpath(CHECK_IN_OUT_DATE_XPATH));
		for (int i=0; i<dateList.size(); i++) {
			if (checkOutDt.equals(dateList.get(i).getAttribute("datetime").toString())) {
				dateList.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	
	public void searchClick() throws InterruptedException {
		driver.findElement(By.xpath(SEARCH_BTN_XPATH)).click();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
	}
}

//@FindBy(id="input-auto-complete")
//WebElement searchCity;
//
//@FindBy(xpath="//*[@class='DatePicker_calendarMonth__QzjFe']//child::time") 
//List<WebElement> datesChild;
//
//@FindBy(xpath="//button[@type='submit']")
//WebElement searchBtn;
//
//
//public void searchCity(String city) throws InterruptedException {
//	searchCity.click();
//	searchCity.sendKeys(city);
//}
//
//public void checkInDt(String checkInDt) throws InterruptedException {
//	System.out.println(datesChild.size());
//	for (int i=0; i<datesChild.size(); i++) {
//		if (checkInDt.equals(datesChild.get(i).getAttribute("datetime").toString())) {
//			datesChild.get(i).click();
//			Thread.sleep(2000);
//			break;
//		}
//	}
//}
//
//public void checkOutDt(String checkOutDt) throws InterruptedException {
//	System.out.println(datesChild.size());
//	for (int i=0; i<datesChild.size(); i++) {
//		if (checkOutDt.equals(datesChild.get(i).getAttribute("datetime").toString())) {
//			datesChild.get(i).click();
//			Thread.sleep(2000);
//			break;
//		}
//	}
//}
//
//public void searchClick() throws InterruptedException {
//	searchBtn.click();
//	Thread.sleep(25000);
//}
//}