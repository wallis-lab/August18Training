package framework;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {
	protected WebDriver driver;
	protected String baseUrl;
	protected DriverManager manager;
	
	protected TestBase(String baseUrl){
		this.baseUrl = baseUrl;
	}
	
	@Before
	public void setup() {
		String driverType= getDriverType();
		this.manager= DriverManagerFactory.getManager(driverType);
		this.manager.createDriver();
		this.driver=this.manager.getDriver();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
		catch(Exception e){
			 throw new RuntimeException();
			 }
		
		return propertie.getProperty("browserType");
	}
	
	@After
	public void cleanup() {
		this.manager.quitDriver();
	}
}
