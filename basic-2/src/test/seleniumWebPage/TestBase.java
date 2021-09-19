import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {
	final String WEB_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
	protected ChromeDriver driver;
	protected String baseUrl;
	
	@Before
	public void setup() {
		String chromeDriverPath = "C:\\Users\\Administrator\\Desktop\\chromedriver.exe";
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, chromeDriverPath);
		this.baseUrl = "https://ampeg.com";	
			
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		this.driver.navigate().to(this.baseUrl);
	}
	
	@After
	public void cleanup() {
		this.driver.quit();
	}
} 