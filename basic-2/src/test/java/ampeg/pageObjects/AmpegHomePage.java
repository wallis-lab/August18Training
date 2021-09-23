package ampeg.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.PageObject;

public class AmpegHomePage extends PageObject {
	public AmpegHomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public AmpegProductPage clickProductPage() {
		
		WebElement menuElement = getProductPageElement("main-item products");
			
		menuElement.click();	
		
		return new AmpegProductPage(this.driver, this.baseUrl);
	}
	
	protected WebElement getProductPageElement(String productElement) {
		
		return driver.findElement(By.xpath("//div[@id='global-topnav']//a[@class = '"+ productElement +"']"));
	}
}

