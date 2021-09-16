import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
		protected ChromeDriver driver;
		protected String baseUrl;
		protected static long ATTRIBUTE_TO_MATCH_TIMEOUT_SECONDS= 5;
		
		protected PageObject(ChromeDriver driver, String baseUrl) {
			this.driver = driver;
			this.baseUrl = baseUrl;

			PageFactory.initElements(driver, this);
		}
		
		protected WebElement getProductPageElement(String productElement) {
			return driver.findElement(By.xpath("//div[@id='global-topnav']//a[@class = '"+productElement+"']"));
		}
		
		protected WebElement getClassicPageElement(String productElement) {
			return driver.findElement(By.xpath("//td[@class='borderBottom']/a[contains(@href, '"+productElement+"')]"));
		}
		
		protected WebElement getSvtProProductPageElement(String productElement) {
			return driver.findElement(By.xpath("//tbody//a[contains(text(), '"+productElement+"')]"));
		}
		
		protected WebElement getSvtProProductElement(String productElement) {
			return driver.findElement(By.xpath("//tbody//a[contains(text(), '"+productElement+"')]"));
		}
		
		protected WebElement WebWaitTimeInProductListPage(String idName) {
		
			WebDriverWait wait = new WebDriverWait(this.driver, 10);
			
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(idName)));	
		}
		
		protected Boolean WebWaitTimeInitemProductPage(String titleName) {
			
			WebDriverWait wait = new WebDriverWait(this.driver, 10);
			
			boolean status=wait.until(ExpectedConditions.titleIs(titleName));
			
			return status;	
		}		
}
