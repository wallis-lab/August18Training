package test.java.DemoQa.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.DemoQa.framework1.DemoqaPageObject1;

public class DemoqaDynamicPropertiesPage extends DemoqaPageObject1 {
	public DemoqaDynamicPropertiesPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public WebElement getVisibleElement() {
		
		return driver.findElement(By.xpath("//button[@id='visibleAfter']"));
	}
	
	public void waitForTextToAppear(WebDriver newDriver) {
		
	    WebDriverWait wait = new WebDriverWait(newDriver,5);
	    
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("visibleAfter")));
	}
}

