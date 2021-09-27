package test.java.DemoQa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.DemoQa.framework1.DemoqaPageObject1;

public class DemoqaElementsPage extends DemoqaPageObject1{
	public DemoqaElementsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public DemoqaTestBoxPage clickTestBoxPage() {
		
		WebElement menuElement = getMostElementsPageElement("Text Box");
		
		menuElement.click();

		return new DemoqaTestBoxPage(this.driver, this.baseUrl);
	}	
	
	public DemoqaRadioButtonPage clickRadioButtonPage() {
		
		WebElement menuElement = getMostElementsPageElement("Radio Button");
		
		menuElement.click();

		return new DemoqaRadioButtonPage(this.driver, this.baseUrl);
	}
	
	public DemoqaLinksPage clickLinksPage() {
		
		WebElement menuElement = getMostElementsPageElement("Links");
		
		menuElement.click();

		return new DemoqaLinksPage(this.driver, this.baseUrl);
	}
	public DemoqaDynamicPropertiesPage clickDynamicPropertiesPage() {
		
		WebElement menuElement = getDynamicPropertiesPageElement();
		
		menuElement.click();
		return new DemoqaDynamicPropertiesPage(this.driver, this.baseUrl);
	}
	
	public WebElement getMostElementsPageElement(String classicProductElement) {
		return driver.findElement(By.xpath("//li[@class='btn btn-light ']//span[contains(text(),'" + classicProductElement + "')]"));
	}
	public WebElement getDynamicPropertiesPageElement() {
		//return driver.findElement(By.xpath("//li[@class='btn btn-light active']//span[contains(text(),'" + classicProductElement + "')]"));
		//("//li[@class='btn btn-light active']") $x("//ul[@class='menu-list']/li[@id='item-8']")
		//$x("//ul[@class='menu-list']/li[@id='item-8']/span[contains (text(),'Dynamic Properties')]")
		return driver.findElement(By.xpath("//li[@id='item-8']/span[contains(text(),'Dynamic')]"));
	}
	
}
