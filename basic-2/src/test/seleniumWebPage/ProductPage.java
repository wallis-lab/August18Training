import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ProductPage extends PageObject{
	
	protected ProductPage(ChromeDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public ClassicSeriesPage clickClassicSeriesPage() {	
		
		WebElement menuElement = getProductTypeElement("/products/classic/");
		
		menuElement.click();
		
		return new ClassicSeriesPage(this.driver, this.baseUrl);
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
