package DemoQa.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class DemoqaPageObject {
	protected WebDriver driver;
	protected String baseUrl;
	protected static long ATTRIBUTE_TO_MATCH_TIMEOUT_SECONDS= 5;
	
	protected DemoqaPageObject(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;

		PageFactory.initElements(driver, this);
	}
}
