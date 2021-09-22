import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPage extends PageObject{
	
	protected ProductPage(ChromeDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public ClassicSeriesPage clickClassicSeriesPage() {	
		
		WebElement menuElement = getClassicPageElement("/products/classic/");
		
		WebWaitTimeInProductListPage("oma-omacro");
		menuElement.click();
		
		return new ClassicSeriesPage(this.driver, this.baseUrl);
	}
	
	public SvtProPage clickSvtProPage() {
		
		WebElement menuElement = getClassicPageElement("/products/pro/");
		
		WebWaitTimeInProductListPage("oma-omacro");
		
		menuElement.click();
		
		return new SvtProPage(driver, baseUrl);
	}
}
