package framework;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {
	protected WebDriver driver;
	protected String baseUrl;
	
	protected TestBase(String baseUrl){
		this.baseUrl = baseUrl;
	}
	
	@Before
	public void setup() {
		this.driver = WebDriverManager.createDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		this.driver.navigate().to(this.baseUrl);
	}
	
	@After
	public void cleanup() {
		WebDriverManager.quitDriver();
	}
}
