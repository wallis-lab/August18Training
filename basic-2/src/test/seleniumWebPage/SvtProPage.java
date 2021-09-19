import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SvtProPage extends PageObject{
	protected SvtProPage(ChromeDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public SvtProPage clickSvtProduct() {	
		
		WebElement menuElement = getSvtProProductElement("SVT-3PRO");
		
		menuElement.click();	
		
		return new SvtProPage(driver, baseUrl);	
	}
	
	public SeleniumAmpegHomePage clickHomepage() {	
			
		getHomeNvagationElement().click();
		
		return new SeleniumAmpegHomePage(driver, baseUrl);
	}

	private WebElement getHomeNvagationElement() {
		return driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
	}
	
	public WebElement getSvtProProductElement(String svtProProductElement) {
		return driver.findElement(By.xpath("//tbody//a[contains(text(), '" + svtProProductElement + "')]"));
	}
} 