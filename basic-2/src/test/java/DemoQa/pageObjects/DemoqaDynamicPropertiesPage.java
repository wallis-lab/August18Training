package test.java.DemoQa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.DemoQa.framework1.DemoqaPageObject1;

public class DemoqaDynamicPropertiesPage extends DemoqaPageObject1 {
	protected DemoqaDynamicPropertiesPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public DemoqaDynamicPropertiesPage clickSVT410HLFDetailPage() {
		
		WebElement menuElement = getClassicProductPageElement("SVT-410HLF");
		
		menuElement.click();

		return new DemoqaDynamicPropertiesPage(this.driver, this.baseUrl);
	}	
	
	public WebElement getClassicProductPageElement(String classicProductElement) {
		return driver.findElement(By.xpath("//tbody//a[contains(text(), '" + classicProductElement + "')]"));
	}
}
