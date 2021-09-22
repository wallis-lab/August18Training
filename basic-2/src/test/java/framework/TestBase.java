package framework;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {
	protected WebDriver driver;
	protected String baseUrl;
	String driverType;
	
	protected TestBase(String baseUrl){
		this.baseUrl = baseUrl;
	}
	
	@Before
	public void setup() {
		driverType= getDriverType();
		
		this.driver = DriverManagerFactory.getManager(driverType).getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		this.driver.navigate().to(this.baseUrl);
	}
	
	public String getDriverType() {
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
	
	@After
	public void cleanup() {
		DriverManager.quitDriver();
	}
}
