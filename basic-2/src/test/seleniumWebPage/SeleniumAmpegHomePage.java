import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAmpegHomePage extends PageObject {
	protected SeleniumAmpegHomePage(ChromeDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public ProductPage clickProductPage() {
		
		WebElement menuElement = getProductPageElement("main-item products");
			
		menuElement.click();	
		
		return new ProductPage(this.driver, this.baseUrl);
	}
	
	protected WebElement getProductPageElement(String productElement) {
		
		return driver.findElement(By.xpath("//div[@id='global-topnav']//a[@class = '"+ productElement +"']"));
	}
} 
