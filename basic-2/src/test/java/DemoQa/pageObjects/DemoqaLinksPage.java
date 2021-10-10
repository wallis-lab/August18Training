package DemoQa.pageObjects;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DemoQa.controlExtension.HyperLinkControlExtension;
import DemoQa.framework.DemoqaPageObject;

public class DemoqaLinksPage extends DemoqaPageObject{
	String search_handle;
	
	public DemoqaLinksPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		search_handle = driver.getWindowHandle();
	}
	
	public DemoqaLinksPage clickHomeHyperLink() throws InterruptedException{
		
		HyperLinkControlExtension hyperLink = new HyperLinkControlExtension(driver.findElement(By.xpath("//a[@id='simpleLink']")));
		hyperLink.click();
		checkHomePageDispaly();
		return new DemoqaLinksPage(this.driver, this.baseUrl);
	}
	
	public DemoqaLinksPage clickCreatedHyperLink() throws InterruptedException {

		Set<String> allWindow = driver.getWindowHandles();  
		List<String> it = new ArrayList<String>(allWindow); 

		driver.switchTo().window(it.get(0));
		
		HyperLinkControlExtension hyperLink = new HyperLinkControlExtension(driver.findElement(By.xpath("//a[@id='created']")));
		hyperLink.click();
		checkHomePageDispaly();
		return new DemoqaLinksPage(this.driver, this.baseUrl);
	}
	
	public DemoqaLinksPage clickNewPageJoinNowButton() throws InterruptedException{

		Set<String> handles = driver.getWindowHandles();
			    for (String handle : handles) {
			    	if(handle != search_handle) {
			    		driver.switchTo().window(handle);
			    		Thread.sleep(2000);
			    		//checkJoinLinkPageDisplay();
			    	}
			    }			        
			    HyperLinkControlExtension hyperLink = new HyperLinkControlExtension(driver.findElement(By.xpath(".//img[@class='banner-image']")));
			    hyperLink.click();
			    
		return new DemoqaLinksPage(this.driver, this.baseUrl);
	}
	
	public String getActualTestWhenClickCreated() {
		
		WebElement element = driver.findElement(By.xpath("//p[@id='linkResponse']"));

		return element.getText();
	}
	
	public void checkHomePageDispaly() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		//String currentUrl = driver.getCurrentUrl();
		wait.until(ExpectedConditions.urlMatches("https://demoqa.com/"));
	
	}
	
	public void checkLinkPageDispaly() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		//String currentUrl = driver.getCurrentUrl();
		wait.until(ExpectedConditions.urlMatches("https://demoqa.com/links"));
	
	}
	
	public void checkJoinLinkPageDisplay() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		//String currentUrl = driver.getCurrentUrl();
		wait.until(ExpectedConditions.urlMatches("https://www.toolsqa.com/selenium-training/"));
	}
}

