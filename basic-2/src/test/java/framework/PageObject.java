package framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
		protected WebDriver driver;
		protected String baseUrl;
		protected static long ATTRIBUTE_TO_MATCH_TIMEOUT_SECONDS= 5;
		
		protected PageObject(WebDriver driver, String baseUrl) {
			this.driver = driver;
			this.baseUrl = baseUrl;

			PageFactory.initElements(driver, this);
		}
}
