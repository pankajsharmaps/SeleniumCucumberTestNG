package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadLocators {
	
	public Properties prop;
	
	String filePath = System.getProperty("user.dir")+"/src/test/resources/config/locators.properties";
	
	public String getLocatorValue(String fieldName) {	
		prop = new Properties();
		try {
			prop = new Properties ();
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
			}
		catch (IOException e) {
		e.printStackTrace();
			}	
		return prop.getProperty(fieldName);
	}
}