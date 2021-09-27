package test.java.DemoQa.pageObjects;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.DemoQa.framework.DemoqaPageObject;

public class DemoqaLinksPage extends DemoqaPageObject{
	String search_handle;
	
	public DemoqaLinksPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		search_handle = driver.getWindowHandle();
	}
	
	public DemoqaLinksPage clickHomeHyperLink() throws InterruptedException {
		
		WebElement RadioButtonElement = getPageHyperLinkElement("simpleLink");
		
		RadioButtonElement.click();
	
		return new DemoqaLinksPage(this.driver, this.baseUrl);
	}
	
	public DemoqaLinksPage clickNewPageJoinNowButton() throws InterruptedException{

		Set<String> handles = driver.getWindowHandles();
			    for (String handle : handles) {
			    	if(handle != search_handle) {
			    		driver.switchTo().window(handle);
			    		Thread.sleep(2000);	    	
			    	}
			    }			        
			    WebElement RadioButtonElement = getJoinNowElement("banner-image");
	    		RadioButtonElement.click();
		return new DemoqaLinksPage(this.driver, this.baseUrl);
	}
	
	public DemoqaLinksPage clickCreatedHyperLink() throws InterruptedException {
		
		Set<String> allWindow = driver.getWindowHandles();  
		List<String> it = new ArrayList<String>(allWindow); 

		driver.switchTo().window(it.get(0));
		
		WebElement RadioButtonElement = getPageHyperLinkElement("created");
		RadioButtonElement.click();
		
		return new DemoqaLinksPage(this.driver, this.baseUrl);
	}

	public WebElement getPageHyperLinkElement(String HomeHyperLinkElement) {

		return driver.findElement(By.xpath("//a[@id='"+ HomeHyperLinkElement + "']"));
	}
	
	public WebElement getJoinNowElement(String JoinNowElement) {

		return driver.findElement(By.xpath(".//img[@class='"+JoinNowElement+"']"));
	}
	
	public String getActualTestWhenClickCreated() {
		
		WebElement element = driver.findElement(By.xpath("//p[@id='linkResponse']"));

		return element.getText();
	}
}

