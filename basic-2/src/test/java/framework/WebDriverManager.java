package framework;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ampeg.foundation.ChormeDriverManager;
import ampeg.foundation.EdgeDriverManager;

public class WebDriverManager {
	protected static WebDriver driver;
	
	public static WebDriver createDriver() {
		
		if (driver == null) {
			String driverType = getDriverType();
		
		if(driverType.equals("Chrome")){
			System.setProperty(ChormeDriverManager.WEB_DRIVER_SYSTEM_PROPERTY_CHROME, ChormeDriverManager.chromeDriverPath);
			driver = new ChromeDriver();
		}else if(driverType.equals("Edge")){
			System.setProperty(EdgeDriverManager.WEB_DRIVER_SYSTEM_PROPERTY_EDGE, EdgeDriverManager.edgeDriverPath);
			driver = new ChromeDriver();
		}
		}
			return driver;
	}
	
	 public static String getDriverType() { 
		Properties propertie = new Properties();
		try{					 
			 String filePath = ".\\resources\\config.properties";
			 InputStream inputstream =new FileInputStream(filePath);
			 propertie.load(inputstream);
			}
		catch(FileNotFoundException e){
			 e.printStackTrace();
			 }
		catch(IOException e) {
			e.printStackTrace();
		}
		return propertie.getProperty("browserType");		
	}
	
	public static void quitDriver() {
		driver.quit();
		driver = null;
	}
}
