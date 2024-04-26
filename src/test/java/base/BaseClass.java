package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseClass {
	
public static WebDriver driver;
public static Properties prop = new Properties ();

	public BaseClass() {
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
			prop.load(fis);
		} 
		catch (IOException e) {
			e.getMessage();
		}
	}
	
	public static void initialization() {	
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
//		driver.get(prop.getProperty("testurl")); 
	}	
	
	public static void tearDown() {
		driver.close();
	}
	
	public static void takeSS() throws IOException {
//		Date t = new Date();
		
		String destPath = System.getProperty("user.dir")+"/src/test/resources/screenShots/"+".png";
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(destPath);
		
		FileUtils.copyFile(srcFile, destFile);
	}
}