package ampeg.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.PageObject;

public class AmpegProductPage extends PageObject{
	protected AmpegProductPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public AmpegClassicSeriesPage clickClassicSeriesPage() {	
		
		WebElement menuElement = getProductTypeElement("/products/classic/");
		
		menuElement.click();
		
		return new AmpegClassicSeriesPage(this.driver, this.baseUrl);
	}
	
	public SvtProPage clickSvtProPage() {
		
		WebElement menuElement = getProductTypeElement("/products/pro/");
		
		menuElement.click();
		
		return new SvtProPage(driver, baseUrl);
	}
	
	public WebElement getProductTypeElement(String productTypeElement) {
		return driver.findElement(By.xpath("//td[@class='borderBottom']/a[contains(@href, '" + productTypeElement + "')]"));
	}
}

