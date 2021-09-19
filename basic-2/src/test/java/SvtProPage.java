import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SvtProPage extends PageObject{
	protected SvtProPage(ChromeDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public SvtProPage clickSvtProduct() {	
		
		WebElement menuElement = getSvtProProductElement("SVT-3PRO");
		
		if (WebWaitTimeInitemProductPage("Ampeg: Pro Series")==true)
			menuElement.click();	
		
		return new SvtProPage(driver, baseUrl);	
	}
	
	public SeleniumAmpegHomePage clickHomepage() {	
		
		if (WebWaitTimeInitemProductPage("Ampeg: Pro Series - SVT-3PRO")==true)		
			getHomeNvagationElement().click();
		
		return new SeleniumAmpegHomePage(driver, baseUrl);
	}

	private WebElement getHomeNvagationElement() {
		return driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
	}
}
