import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
		protected ChromeDriver driver;
		protected String baseUrl;
		protected static long ATTRIBUTE_TO_MATCH_TIMEOUT_SECONDS= 5;
		
		protected PageObject(ChromeDriver driver, String baseUrl) {
			this.driver = driver;
			this.baseUrl = baseUrl;

			PageFactory.initElements(driver, this);
		}
}
