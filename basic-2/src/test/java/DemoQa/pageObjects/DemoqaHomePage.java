package test.java.DemoQa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaHomePage extends DemoqaPageObject{
	public DemoqaHomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public DemoqaHomePage clickElementsPage() {
		
		WebElement menuElement = getProductPageElement("1");
			
		menuElement.click();	
		
		return new DemoqaHomePage(this.driver, this.baseUrl);
	}
	
	protected WebElement getHomePageElement(String productElement) {
			
		return driver.findElement(By.xpath((".//div[@class='category-cards']/div['"+ productElement +"']")));
	
	}

	
}
