package ampeg.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObject;

public class SvtProPage extends PageObject{
	public SvtProPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public SvtProPage clickSvtProduct() {	
		
		WebElement menuElement = getSvtProProductElement("SVT-3PRO");
		
		menuElement.click();	
		
		return new SvtProPage(driver, baseUrl);	
	}
	
	public AmpegHomePage clickHomepage() {	
			
		getHomeNvagationElement().click();
		
		return new AmpegHomePage(driver, baseUrl);
	}

	private WebElement getHomeNvagationElement() {
		return driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
	}
	
	public WebElement getSvtProProductElement(String svtProProductElement) {
		return driver.findElement(By.xpath("//tbody//a[contains(text(), '" + svtProProductElement + "')]"));
	}
}
