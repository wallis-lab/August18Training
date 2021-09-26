package test.java.DemoQa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaElementsPage extends DemoqaPageObject{
	protected AmpegClassicSeriesPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public DemoqaElementsPage clickTestBoxPage() {
		
		WebElement menuElement = getClassicProductPageElement("Text Box");
		
		menuElement.click();

		return new SVT410HLFDetailPage(this.driver, this.baseUrl);
	}	
	public DemoqaElementsPage clickRadioButtonPage() {
		
		WebElement menuElement = getClassicProductPageElement("Radio Button");
		
		menuElement.click();

		return new SVT410HLFDetailPage(this.driver, this.baseUrl);
	}
	public DemoqaElementsPage clickLinksPage() {
		
		WebElement menuElement = getClassicProductPageElement("Links");
		
		menuElement.click();

		return new SVT410HLFDetailPage(this.driver, this.baseUrl);
	}
	public DemoqaElementsPage clickDynamicPropertiesPage() {
		
		WebElement menuElement = getClassicProductPageElement("Dynamic Properties");
		
		menuElement.click();

		return new SVT410HLFDetailPage(this.driver, this.baseUrl);
	}
	
	public WebElement getMostElementsPageElement(String classicProductElement) {
		return driver.findElement(By.xpath("//li[@class='btn btn-light ']//[contains(text(),'" + classicProductElement + "')]"));
	}
	public WebElement getDynamicPropertiesPageElement(String classicProductElement) {
		return driver.findElement(By.xpath("//li[@class='btn btn-light active']//[contains(text(),'" + classicProductElement + "')]"));
	}
}
