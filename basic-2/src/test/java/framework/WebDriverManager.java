package framework;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverManager {
	static final String WEB_DRIVER_SYSTEM_PROPERTY_CHROME = "webdriver.chrome.driver";
	static final String WEB_DRIVER_SYSTEM_PROPERTY_EDGE = "webdriver.edge.driver";
	static final String chromeDriverPath = "C:\\Users\\Administrator\\Desktop\\chromedriver.exe";
	static final String edgeDriverPath = "C:\\Users\\Administrator\\Desktop\\msedgedriver.exe";
	protected static WebDriver driver;
	
	public static WebDriver createDriver() {
		
		if (driver == null) {
			String driverType = getDriverType();
		
		if(driverType.equals("Chrome")){
			System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY_CHROME, chromeDriverPath);
			driver = new ChromeDriver();
		}else if(driverType.equals("Edge")){
			System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY_EDGE, edgeDriverPath);
			driver = new EdgeDriver();
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
