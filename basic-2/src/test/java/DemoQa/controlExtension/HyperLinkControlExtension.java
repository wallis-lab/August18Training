package DemoQa.controlExtension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HyperLinkControlExtension {
	
	private WebElement mappedElement;
	
	public HyperLinkControlExtension(WebElement mappedElement){
		this.mappedElement=mappedElement;
	}
	
	public void click() {
		mappedElement.click();
	}
}
