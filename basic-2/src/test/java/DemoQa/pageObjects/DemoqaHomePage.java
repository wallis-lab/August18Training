package test.java.DemoQa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.DemoQa.framework.DemoqaPageObject;

public class DemoqaHomePage extends DemoqaPageObject{
	public DemoqaHomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public DemoqaElementsPage clickElementsPage() {
		
		WebElement menuElement = getHomePageElement("1");
			
		menuElement.click();	
		
		return new DemoqaElementsPage(this.driver, this.baseUrl);
	}
	
	protected WebElement getHomePageElement(String productElement) {
			
		return driver.findElement(By.xpath((".//div[@class='category-cards']/div['"+ productElement +"']")));
	
	}	
}
