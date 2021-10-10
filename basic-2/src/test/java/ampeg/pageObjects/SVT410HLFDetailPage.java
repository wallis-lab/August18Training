package ampeg.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObject;

public class SVT410HLFDetailPage extends PageObject{
	public SVT410HLFDetailPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String returnTheHandlingweightValue() {
		WebElement element = this.driver.findElement(By.xpath("//div[@class='specsCopy']"));
		
		String[] segments = element.getText().split("\n");
		
		return segments[segments.length - 1];
	}
}
